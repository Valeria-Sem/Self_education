import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, ReplaySubject, Subject} from "rxjs";
import {tap} from "rxjs/operators";
import {UserInf} from "../modules/userInf";
import {User} from "../modules/user";

@Injectable()
export class UserService {

  public currentUser: User;

  public currentUser$: ReplaySubject<User> = new ReplaySubject(1);

  public currentStudent: User;

  public currentStudent$: ReplaySubject<User> = new ReplaySubject(1);

  constructor(private http: HttpClient) {
  }

  getUserInfo(login: string, password: string): Observable<User> {
    return this.http.get<User>('/api/login?login=' + login + '&password=' + password).pipe(
      tap(user => {
        this.currentUser$.next(user);
        this.currentUser = user;
        localStorage.setItem("user", JSON.stringify(user));
      })
    );
  }

  public setUser(user: User): void {
    this.currentUser$.next(user);
    this.currentUser = user;
  }

  deleteUser(idUser: number, idWallet: string): Observable<void> {
    return this.http.delete<void>('/api/registration/user/delete/' + idUser + "/" + idWallet)
  }

  saveUser(user: UserInf): Observable<UserInf> {
    return this.http.post<UserInf>('/api/user', user);
  }

  getUsersByIdGroup(idGroup: string): Observable<User[]> {
    return this.http.get<User[]>('/api/student/group/'+ idGroup);
  }

  getStudentById(idStudent: string): Observable<User> {
    return this.http.get<User>('/api/registration/student/'+ idStudent);
  }

  getStudentsBySearch(searchWord: string): Observable<User[]> {
    return this.http.get<User[]>('/api/student/search?request=' + searchWord);
  }
}
