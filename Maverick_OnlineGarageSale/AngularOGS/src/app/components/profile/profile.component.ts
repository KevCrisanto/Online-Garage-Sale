import { CookieService } from 'ngx-cookie-service';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Account } from '../../objects/account';
import { Address } from '../../objects/address';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  account: Account;
  address = new Address('','','','','','','','',null);

  public detVisible = true;
  public formVisible = false;

  public addDetVisible = true;
  public addVisible = false;

  public showForm(){
    this.detVisible = !this.detVisible;
    this.formVisible = !this.formVisible;
  }

  public showAddForm(){
    this.addDetVisible = !this.addDetVisible;
    this.addVisible = !this.addVisible;
  }

  constructor(private login: LoginService, private cookieService: CookieService, private user: UserService) {
   }

  ngOnInit() {
    this.login.currentAccount.subscribe(account => this.account = account);
  }

  update(a: Account){
    this.login.updateService(this.account).subscribe(
      data => {
        if(data != null){
          this.login.changeAccount(data);
        }
      },
      error => {
        console.log('error');
      }
    )
    this.showForm();
  }

  updateAddress(a: Address){
    this.login.addressService(this.address).subscribe();
  }

  upgrade(id: String){
    this.user.upgradeUser(id).subscribe();
    location.reload();
  }
  
}
