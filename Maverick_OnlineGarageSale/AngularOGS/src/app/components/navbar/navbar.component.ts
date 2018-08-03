import { Component, OnInit } from '@angular/core';
import { NavbarService } from '../../services/navbar.service';
import { LoginService } from '../../services/login.service';
import { Account } from './../../objects/account';
import { Router } from '@angular/router';
import { CookieService } from '../../../../node_modules/ngx-cookie-service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  ResetAcc = new Account('','', '', '', '', '', null, false, false, false, false,null);

  constructor(private nav: NavbarService, private login: LoginService, private router: Router, private cookie: CookieService) { }

  ngOnInit() {
  }

  logout(){
    this.cookie.delete('userid'); 
    // setTimeout(() => this.router.navigate(['login']), 5000);
    location.reload();
    this.router.navigate(['login'])
    
    
  }


}
