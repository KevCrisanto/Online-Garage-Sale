import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-admin-accounts',
  templateUrl: './admin-accounts.component.html',
  styleUrls: ['./admin-accounts.component.css']
})
export class AdminAccountsComponent implements OnInit {

  accounts: Account[];

  constructor(private user: UserService) { }

  ngOnInit() {
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

}
