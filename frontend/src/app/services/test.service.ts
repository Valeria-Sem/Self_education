import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Test} from "../modules/test";

@Injectable({
  providedIn: 'root'
})

export class TestService {

  constructor(private http : HttpClient) { }

  getTestsByLectureId(idLecture: string): Observable<Test>{
    return this.http.get<Test>('/api/test/lecture/' + idLecture)
  }

}
