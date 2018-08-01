import { CookieService } from 'ngx-cookie-service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from './../objects/account';
import { HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { BehaviorSubject } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'applications/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/LoginServlet';
  private registerUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/RegisterServlet';
  private getAccountUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/GetUserServlet';
  // private loginUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/LoginServlet';
  // private registerUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/RegisterServlet';

private accountSource = new BehaviorSubject<Account>(
                            new Account('', '', '', '', '', '',
                             null, false, false, false, false, null));

currentAccount = this.accountSource.asObservable();

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      // this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  constructor(private http: HttpClient, private cookieService: CookieService) {
    this.getUserFromCookie();
   }
  // input: Account
  
  checkLogin(account: Account): Observable<Account> {
    return this.http.post<Account>(this.loginUrl, account, httpOptions);
  }

  registerService(account: Account): Observable<Account> {
    return this.http.post<Account>(this.registerUrl, account, httpOptions);
  }

  //update account (shared across components)
  changeAccount(account: Account){
    this.accountSource.next(account);
  }

  getUserById(userId: string):Observable<Account>{
    return this.http.post<Account>(this.getAccountUrl,userId,httpOptions);
  }

  getUserFromCookie(){
    if(this.cookieService.check('userid')){
      this.getUserById(this.cookieService.get('userid')).subscribe(
        data => {
          this.changeAccount(data);
        },
        error => {
          console.log('error');
        }
      );
    }
  }
}
