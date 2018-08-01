import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Account } from '../../objects/account';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  account: Account

  constructor(private login: LoginService) { }

  ngOnInit() {
    this.login.currentAccount.subscribe(account => this.account = account);
  }

}
