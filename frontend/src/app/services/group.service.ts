import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Group} from "../modules/group";

@Injectable({
  providedIn: 'root'
})

export class GroupService {

  constructor(private http : HttpClient) { }

  getGroups(): Observable<Group[]>{
    return this.http.get<Group[]>('/api/group')
  }

  getGroupById(idGroup: string): Observable<Group>{
    return this.http.get<Group>('/api/group/' + idGroup)
  }
}
