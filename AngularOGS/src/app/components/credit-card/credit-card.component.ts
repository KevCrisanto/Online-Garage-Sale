import { Component, OnInit } from '@angular/core';
import {CardModule} from 'ngx-card/ngx-card';

@Component({
  selector: 'app-credit-card',
  templateUrl: './credit-card.component.html',
  styleUrls: ['./credit-card.component.css']
})
export class CreditCardComponent implements OnInit {
  imports: [
    CardModule
  ]
  constructor() { }

  ngOnInit() {
  }

}
