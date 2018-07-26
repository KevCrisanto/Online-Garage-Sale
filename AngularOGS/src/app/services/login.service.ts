import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from './../objects/account';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  checkLogin(){
    return this.http.get<Account>("http://localhost:8085/javascript/");
  }
}
