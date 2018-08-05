import { CookieService } from 'ngx-cookie-service';
import { LoginService } from './../../services/login.service';
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
  // private updateRatingUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/UpdateRatingServlet';
  private updateRatingUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/UpdateRatingServlet';
  constructor(private http: HttpClient, private trans: TransactionsService,
             private login: LoginService,private cookieService: CookieService) { 
  }

  account: Account;

  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.account = account));
    this.getTrans();
  }

  tempBuyer: Account = new Account('5a48fc39-9ea5-436e-8295-4a3bc195fb66','',
   '', '', '', '', null, false, false, false, false,null);
  // tempSeller: Account = new Account('2b1d9453-cdb3-4c02-9ac3-599448771577','',
  //  '', '', '', '', null, false, false, false, false,null);

  getTrans(){
    this.trans.getTransactions(this.cookieService.get('userid')).subscribe(
      data => {
        this.transactions = data;
        console.log(data);
      },
      error => {
        console.log('error');
      }
    );
  }

  updateTrans(r: string, id: string){
    var fd = new FormData();

    fd.append('transid', id);
    fd.append('rating', r);
    this.http.post(this.updateRatingUrl, fd).subscribe();
    location.reload();
  }

  isSeller(accid: string){
    if(accid === this.account.accountId){
      return true;
    }else{
      return false;
    }
  }
  
}
