import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../../../../objects/item';
import { Router, NavigationExtras } from '@angular/router';
import { LoginService } from '../../../../services/login.service';
import { Account } from '../../../../objects/account';
import { UserService } from '../../../../services/user.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  @Input() item: Item;

  account: Account;

  constructor(private router: Router, private login: LoginService, private user: UserService) {}

  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.account = account));
  }
  public onTap() {
    const navigationExtras: NavigationExtras = {
      queryParams: {
        item: this.item.itemId
      }
    };
    this.router.navigate(['item-detail'], navigationExtras);
  }

  deleteItem(id: String){
    this.user.deleteItemById(id).subscribe();
    location.reload();
  }

  displayDelete(){
    if(this.account.isAdmin){
      return true;
    }
    else if(this.item.accountId.accountId == this.account.accountId){
      return true;
    }
    else{
      return false;
    }
  }

}
