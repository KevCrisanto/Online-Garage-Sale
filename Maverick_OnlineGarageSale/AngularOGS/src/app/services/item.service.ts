import { Item } from './../objects/item';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'applications/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class ItemService {
  // private insertUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/InsertItemServlet';
  // private getItemsUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/GetItemsServlet';
  // private getItemByIdUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/GetItemsServlet';
  private insertUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/InsertItemServlet';
  private getItemsUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/GetItemsServlet';
  private getItemByIdUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/GetItemByIdServlet';

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

  insertItem(item: Item) {
    return this.http.post<Item>(this.insertUrl, item, httpOptions);
  }

  getItemsForSale(){
    return this.http.get<Item[]>(this.getItemsUrl);
  }

  getItemById(itemId: string):Observable<Item>{
    return this.http.post<Item>(this.getItemByIdUrl,itemId,httpOptions);
  }
}
