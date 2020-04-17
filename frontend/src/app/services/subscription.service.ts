import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Subscription} from "../modules/subscription";
import {StudProd} from "../modules/StudProd";

@Injectable({
  providedIn: 'root'
})
export class SubService {

  constructor(private http: HttpClient) {
  }

  subscribeStudent(information: Subscription, idStud: number, idProd: string): Observable<Subscription> {
    return this.http.post<Subscription>('/api/subscription/student/' + idStud +'/prod/' + idProd, information);
  }

  getSub(idStud: number): Observable<StudProd[]> {
    return this.http.get<StudProd[]>('/api/studentSub/student/' + idStud);
  }

  unsubscribe(idSub: string): Observable<void> {
    return this.http.delete<void>('/api/subscription/delete/' + idSub);
  }
}
