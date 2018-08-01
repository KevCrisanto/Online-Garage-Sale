import { Address } from './../../objects/address';
import { Component, OnInit, Input } from '@angular/core';
import * as $ from 'jquery';
import { HttpClient } from '@angular/common/http';
import { LoginService } from './../../services/login.service';
import { Account } from './../../objects/account';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  // account = Account;
  // account2 = Account;

  constructor(private http: HttpClient, private login: LoginService) {}

  account: Account;

  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.account = account));

    $(document).ready(function() {
      const panelOne = $('.form-panel.two').scrollHeight,
        panelTwo = $('.form-panel.two')[0].scrollHeight;

      $('.form-panel.two')
        .not('.form-panel.two.active')
        .on('click', function(e) {
          e.preventDefault();

          $('.form-toggle').addClass('visible');
          $('.form-panel.one').addClass('hidden');
          $('.form-panel.two').addClass('active');
          $('.form').animate(
            {
              height: panelTwo
            },
            200
          );
        });

      $('.form-toggle').on('click', function(e) {
        e.preventDefault();
        $(this).removeClass('visible');
        $('.form-panel.one').removeClass('hidden');
        $('.form-panel.two').removeClass('active');
        $('.form').animate(
          {
            height: panelOne
          },
          200
        );
      });
    });
  }

  

  //acc = new Account('', '', '', '', '', '', null, false, false, false, false);
  regAcc = new Account('','', '', '', '', '', null, false, false, false, false,null);

  cLogin() {
    this.login.checkLogin(this.account).subscribe(
      data => {
        this.login.changeAccount(data);
        //if(this.account.email != null)
      },
      error => {
        console.log('error');
      }
    );
  }

  register(a: Account) {
    this.login.registerService(this.regAcc).subscribe(
      data => {
        this.login.changeAccount(data);
        console.log(data);
      },
      error => {
        console.log('error');
      }
    );
  }
}
