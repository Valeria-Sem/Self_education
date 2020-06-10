import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PassedTest} from "../modules/passedTest";
import {Testing} from "../modules/testing";

@Injectable({
  providedIn: 'root'
})
export class PassedTestService {
  constructor(private http: HttpClient) {

  }

  saveResult(result: PassedTest): Observable<PassedTest> {
    return this.http.post<PassedTest>('/api/saveResult', result);
  }

  reSaveResult(result: Testing): Observable<Testing> {
    return this.http.post<Testing>('/api/saveResult', result);
  }

  findResult(studId: number, testId: string): Observable<Testing> {
    return this.http.get<Testing>('/api/testing/' + studId + '/' + testId);
  }
}
