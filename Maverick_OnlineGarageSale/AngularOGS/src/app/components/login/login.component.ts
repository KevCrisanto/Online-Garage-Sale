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

  constructor(private http: HttpClient, private login: LoginService) { }

  ngOnInit() {
    $(document).ready(function () {
      var panelOne = $('.form-panel.two').scrollHeight,
        panelTwo = $('.form-panel.two')[0].scrollHeight;

      $('.form-panel.two').not('.form-panel.two.active').on('click', function (e) {
        e.preventDefault();

        $('.form-toggle').addClass('visible');
        $('.form-panel.one').addClass('hidden');
        $('.form-panel.two').addClass('active');
        $('.form').animate({
          'height': panelTwo
        }, 200);
      });

      $('.form-toggle').on('click', function (e) {
        e.preventDefault();
        $(this).removeClass('visible');
        $('.form-panel.one').removeClass('hidden');
        $('.form-panel.two').removeClass('active');
        $('.form').animate({
          'height': panelOne
        }, 200);
      });
    });
  }

  acc = new Account('', '', '', '', '', '', null, false, false, false, false);
  regAcc = new Account('', '', '', '', '', '', null, false, false, false, false);

  get diagnostic() {
    return JSON.stringify(this.acc);
  }
  cLogin(a: Account) {
    this.login.checkLogin(this.acc).subscribe();
    //const newAcc: Account = 
  }
  asdf() {
    this.http.post("http://localhost:8085/Maverick_OnlineGarageSale/LoginServlet", {
      key1: "value",
      key2: "value",
      etc: "value"
    }).subscribe(
      PASS => { },
      FAIL => { })
  }
  register(a: Account) {
    this.login.registerService(this.regAcc).subscribe();
  }
}
