import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Subject} from "../modules/subject";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private http : HttpClient) { }

  getSubjects(): Observable<Subject[]>{
    return this.http.get<Subject[]>('/api/subject')
  }

}
