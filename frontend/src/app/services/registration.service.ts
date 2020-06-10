import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {tap} from "rxjs/operators";
import {User} from "../modules/user";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  public userForRegister: User = null;

  constructor(private http: HttpClient) {
  }

  saveStudent(information: User): Observable<User> {
    return this.http.post<User>('/api/registration/student', information);
  }

}
