import { HttpClient } from '@angular/common/http';
import { Account } from './../../../objects/account';
import { LoginService } from './../../../services/login.service';
import { Item } from './../../../objects/item';
import { ItemService } from './../../../services/item.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-checkout',
  templateUrl: './item-checkout.component.html',
  styleUrls: ['./item-checkout.component.css']
})
export class ItemCheckoutComponent implements OnInit {

  public item: Item = new Item('','','',null,'','',0,null);
  account: Account;
  private submitUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/SubmitTransactionServlet';
  // private submitUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/SubmitTransactionServlet';

  constructor(private route: ActivatedRoute,private itemService: ItemService, private login: LoginService,
              private router: Router, private http: HttpClient) {
    this.login.currentAccount.subscribe(account => (this.account = account));
    this.route.queryParams.subscribe(
      params => {
        console.log(params["item"]);
        this.itemService.getItemById(params["item"]).subscribe(
          data => {
            this.item = data;
          },
          error => {
            console.log('error');
          }
        );
      },
      error => {
        console.log('error');
      }
    );
  }

  ngOnInit() {}

  submitTransaction() {
    const fd = new FormData();
    fd.append('item', this.item.itemId);
    fd.append('seller', this.item.accountId.accountId);
    fd.append('buyer', this.account.accountId);
    this.http.post(this.submitUrl, fd).subscribe();
    this.router.navigate(['item-list']);
    // this.subItem.accountId.accountId = this.account.accountId;
    // console.log(this.subItem);
    // this.itemService.insertItem(this.subItem).subscribe();
  }
}
