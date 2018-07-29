import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from './../objects/account';
import { HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'applications/json'  
  })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginurl = "http://localhost:8085/Maverick_OnlineGarageSale/LoginServlet";
  private registerUrl = "http://localhost:8085/Maverick_OnlineGarageSale/RegisterServlet";

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
   
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
   
      // TODO: better job of transforming error for user consumption
      //this.log(`${operation} failed: ${error.message}`);
   
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  constructor(private http: HttpClient) { }
  //input: Account
  checkLogin(account: Account): Observable<Account>{
    return this.http.post<Account>(this.loginurl,account, httpOptions)
    .pipe(catchError(this.handleError<Account>('checkLogin'))
    );  
  }
  registerService(account: Account): Observable<Account>{
    return this.http.post<Account>(this.registerUrl, account, httpOptions);
  }

  
}
