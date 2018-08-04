import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Transaction } from './../objects/transaction';
import { Account } from './../objects/account';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'applications/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class TransactionsService {

  // private getUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/GetTransactionsServlet';
  private getUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/GetTransactionsServlet';

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

  constructor(private http: HttpClient) { }
  
    getTransactions(currAcc: string){
      return this.http.post<Transaction[]>(this.getUrl, currAcc, httpOptions);
    }
    
    
}
