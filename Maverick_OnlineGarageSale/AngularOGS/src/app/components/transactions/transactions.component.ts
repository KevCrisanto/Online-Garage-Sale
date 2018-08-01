import { TransactionsService } from './../../services/transactions.service';
import { Transaction } from './../../objects/transaction';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from './../../objects/account';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  transactions: Transaction[];

  constructor(private http: HttpClient, private trans: TransactionsService) { 
    this.getTrans();
  }


  ngOnInit() {
  }

  tempBuyer: Account = new Account('8ac0830a-a424-47cc-8b01-3cb59663380c','',
   '', '', '', '', null, false, false, false, false,null);
  tempSeller: Account = new Account('2b1d9453-cdb3-4c02-9ac3-599448771577','',
   '', '', '', '', null, false, false, false, false,null);

  getTrans(){
    
    this.trans.getTransactions(this.tempBuyer).subscribe(
      data => {
        this.transactions = data;
        console.log(data);
      },
      error => {
        console.log('error');
      }
    );

  }
}
