import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { LoginService } from '../../services/login.service';
import { Account } from './../../objects/account';

@Component({
  selector: 'app-admin-accounts',
  templateUrl: './admin-accounts.component.html',
  styleUrls: ['./admin-accounts.component.css']
})
export class AdminAccountsComponent implements OnInit {

  accounts: Account[];
  acc: Account;

  constructor(
    private user: UserService,
    private login: LoginService  
  ) { }

  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.acc = account));
    this.fetchUsers();
  }

  public fetchUsers(){
    this.user.getAllUsers().subscribe(
      data => {
        this.accounts = data;
        console.log(data);
      }
    )
  }

  deleteUser(id: string){
    this.user.deleteUser(id).subscribe();
    location.reload();
  }

  verifyUser(id: string){
    this.user.verifyUser(id).subscribe();
    location.reload();
  }

  checkAdmin(accountId: string){
    if(accountId == this.acc.accountId){
      return false;
    }
    else{
      return true;
    }
  }
}
