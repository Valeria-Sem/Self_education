import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Subscription} from "../modules/subscription";
import {StudProd} from "../modules/StudProd";
import {Report} from "../modules/report";

@Injectable({
  providedIn: 'root'
})
export class SubService {

  constructor(private http: HttpClient) {
  }

  subscribeStudent(information: StudProd, idStud: number, idProd: string): Observable<Subscription> {
    return this.http.post<Subscription>('/api/subscription/student/' + idStud +'/prod/' + idProd, information);
  }

  getSub(idStud: number): Observable<StudProd[]> {
    return this.http.get<StudProd[]>('/api/studentSub/student/' + idStud);
  }

  getStud(idProd: string): Observable<Report[]> {
    return this.http.get<Report[]>('/api/report/course/' + idProd);
  }

  unsubscribe(idSub: string): Observable<void> {
    return this.http.delete<void>('/api/subscription/delete/' + idSub);
  }

  getSubscription(idStud: number, idProd: string): Observable<Subscription> {
    return this.http.get<Subscription>('/api/subscription/' + idStud + '/' + idProd);
  }

  finishSub(subInfo: Subscription, idStud: number, idProd: string): Observable<Subscription>{
    return this.http.post<Subscription>('/api/subscription/student/' + idStud +'/prod/' + idProd, subInfo);
  }
}
