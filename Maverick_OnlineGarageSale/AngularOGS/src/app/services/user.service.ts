import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = "http://localhost:8085/Maverick_OnlineGarageSale/GetAllUsersServlets"

  constructor(private http: HttpClient) { }

  getAllUsers(){
    return this.http.get<Account[]>(this.url);
  }
}
