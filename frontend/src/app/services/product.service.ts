import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Group} from "../modules/group";
import {User} from "../modules/user";
import {Product} from "../modules/product";

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  constructor(private http : HttpClient) { }

  getProductByCourseId(idCourse: string): Observable<Product>{
    return this.http.get<Product>('/api/product/course/' + idCourse)
  }

  getAllProducts(): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product')
  }
}
