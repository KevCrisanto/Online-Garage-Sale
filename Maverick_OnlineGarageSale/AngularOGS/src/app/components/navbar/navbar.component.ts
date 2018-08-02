import { Component, OnInit } from '@angular/core';
import { NavbarService } from '../../services/navbar.service';
import { LoginService } from '../../services/login.service';
import { Account } from './../../objects/account';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  ResetAcc = new Account('','', '', '', '', '', null, false, false, false, false,null);

  constructor(private nav: NavbarService, private login: LoginService, private router: Router) { }

  ngOnInit() {
  }

  logout(){
    this.login.changeAccount(this.ResetAcc);
    this.router.navigate(['login']);
    
  }


}
