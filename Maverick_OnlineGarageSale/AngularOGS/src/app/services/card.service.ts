import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Card } from '../objects/card';
import { Observable } from '../../../node_modules/rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'applications/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CardService {
  private creditCardUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/CreditCardServlet';

  constructor(private http: HttpClient) { }

  cardService(card: Card): Observable<Card> {
    return this.http.post<Card>(this.creditCardUrl, card, httpOptions);
  }
}
