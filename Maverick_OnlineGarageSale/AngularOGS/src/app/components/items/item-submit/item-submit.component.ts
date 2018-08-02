import { ItemService } from './../../../services/item.service';
import { Account } from './../../../objects/account';
import { LoginService } from './../../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Item } from './../../../objects/item';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-item-submit',
  templateUrl: './item-submit.component.html',
  styleUrls: ['./item-submit.component.css']
})
export class ItemSubmitComponent implements OnInit {
  subItem: Item;
  // private insertUrl = 'http://localhost:8085/Maverick_OnlineGarageSale/InsertItemServlet';
  private insertUrl = 'http://18.219.13.188:8085/Maverick_OnlineGarageSale/InsertItemServlet';
  constructor(private http: HttpClient, private login: LoginService, private itemService: ItemService) {}

  account: Account;
  selectedFile: File;
  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.account = account));
    this.subItem = new Item('','','',this.account,'','sale',0,null);
  }

  onFileSelected(event){
    this.selectedFile = <File>event.target.files[0];
  }
  submitItem(){
    const fd = new FormData();
    this.subItem.accountId.accountId = this.account.accountId;
    fd.append('subItem',JSON.stringify(this.subItem));
    fd.append('file_name',this.selectedFile.name);
    fd.append('file',this.selectedFile);
    this.http.post(this.insertUrl,fd)
        .subscribe();
    // this.subItem.accountId.accountId = this.account.accountId;
    // console.log(this.subItem);
    // this.itemService.insertItem(this.subItem).subscribe();
  }

}
