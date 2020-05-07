import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RightAnswers} from "../modules/rightAnswers";

@Injectable({
  providedIn: 'root'
})
export class AnswerService {
  constructor(private http: HttpClient) {

  }

  getRightAnswer(userAnswersMap: Object): Observable<RightAnswers> {
    return this.http.post<RightAnswers>('/api/right', userAnswersMap);
  }
}
