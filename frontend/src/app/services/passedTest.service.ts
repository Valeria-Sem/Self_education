import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PassedTest} from "../modules/passedTest";

@Injectable({
  providedIn: 'root'
})
export class PassedTestService {
  constructor(private http: HttpClient) {

  }

  saveResult(result: PassedTest): Observable<PassedTest> {
    return this.http.post<PassedTest>('/api/saveResult', result);
  }

  findResult(studId: number, testId: string): Observable<PassedTest> {
    return this.http.get<PassedTest>('/api/findResult/' + studId + '/' + testId);
  }
}
