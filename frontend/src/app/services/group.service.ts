import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Group} from "../modules/group";
import {User} from "../modules/user";

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

  saveGroup(information: Group): Observable<Group> {
    return this.http.post<Group>('/api/group/save', information);
  }

  deleteGroup(id: String): Observable<void> {
    return this.http.delete<void>('api/group/delete/' + id);
  }
}
