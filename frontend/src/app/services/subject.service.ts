import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Course} from "../modules/course";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http : HttpClient) { }

  getSubjects(): Observable<Course[]>{
    return this.http.get<Course[]>('/api/course')
  }

}
