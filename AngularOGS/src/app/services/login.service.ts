import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from './../objects/account';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  checkLogin(input: Account){

    this.http.post("http://localhost:8085/Maverick_OnlineGarageSale/", {
      key1: "value",
      key2: "value",
      etc: "value"
      }).subscribe(
        PASS => {},
        FAIL => {})

  }

}
