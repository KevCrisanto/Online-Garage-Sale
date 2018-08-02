import { ItemService } from './../../../services/item.service';
import { Account } from './../../../objects/account';
import { LoginService } from './../../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Item } from './../../../objects/item';
import { HttpClient } from '@angular/common/http';

import * as $ from 'jquery';

@Component({
  selector: 'app-item-submit',
  templateUrl: './item-submit.component.html',
  styleUrls: ['./item-submit.component.css']
})
export class ItemSubmitComponent implements OnInit {
  subItem: Item;
  private insertUrl =
    'http://localhost:8085/Maverick_OnlineGarageSale/InsertItemServlet';
  constructor(
    private http: HttpClient,
    private login: LoginService,
    private itemService: ItemService
  ) {}

  account: Account;
  selectedFile: File;
  imageChangedEvent: any = '';
  croppedImage: any = '';
  cropperReady = false;

  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.account = account));
    this.subItem = new Item('', '', '', this.account, '', 'sale', 0, null);

    // Display fakepath
    $('#upload').on('change', function() {
      // get the file name
      const fileName = $(this).val();
      // replace the "Choose a file" label
      $(this)
        .next('.custom-file-label')
        .html(fileName);
    });
  }

  onFileSelected(event) {
    this.selectedFile = <File>event.target.files[0];
  }

  submitItem() {
    const fd = new FormData();
    this.subItem.accountId.accountId = this.account.accountId;
    this.subItem.accountId.accountId
    fd.append('subItem', JSON.stringify(this.subItem));
    fd.append('file_name', this.selectedFile.name + '.png');
    fd.append('file', this.selectedFile);
    this.http.post(this.insertUrl, fd).subscribe();
    // this.subItem.accountId.accountId = this.account.accountId;
    // console.log(this.subItem);
    // this.itemService.insertItem(this.subItem).subscribe();
  }

  fileChangeEvent(event: any): void {
    this.imageChangedEvent = event;
  }

  imageCroppedFile(image: File) {
    this.selectedFile = image;
  }

  imageLoaded() {
    this.cropperReady = true;
  }
  imageLoadFailed() {
    console.log('Load failed');
  }
}
