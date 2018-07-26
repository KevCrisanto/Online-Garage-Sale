import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from './../objects/account';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  checkLogin(){

    this.http.post("endpoint_url", {
      key1: "value",
      key2: "value",
      etc: "value"
      }).subscribe(
        PASS => {},
        FAIL => {})

  }
}
