import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../../services/login.service';
import { Account } from '../../objects/account';
import { Transactions } from '../../objects/transaction';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {
  account:Account;
  this.login.currentAccount.subscribe(account => this.account = account);

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

}
