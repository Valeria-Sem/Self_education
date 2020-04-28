import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Question} from "../modules/question";

@Injectable({
  providedIn: 'root'
})

export class QuestionService {

  constructor(private http : HttpClient) { }

  getQuestionsByTestId(idTest: string): Observable<Question[]>{
    return this.http.get<Question[]>('/api/question/test/' + idTest)
  }

}
