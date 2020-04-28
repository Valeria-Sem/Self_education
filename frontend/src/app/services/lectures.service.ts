import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Lectures} from "../modules/lectures";

@Injectable({
  providedIn: 'root'
})

export class LecturesService {

  constructor(private http : HttpClient) { }

  getLecturesByIdProduct(idProduct: string): Observable<Lectures[]>{
    return this.http.get<Lectures[]>('/api/lectures/product/' + idProduct)
  }
}
