import { Account } from './../../objects/account';
import { Item } from './../../objects/item';
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpUpload = {
  headers: new HttpHeaders({
    'Content-Type': 'undefined'
  })
};
@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.css']
})
export class FilesComponent implements OnInit {

  
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  selectedFile: File = null;

  onFileSelected(event){
    this.selectedFile = <File>event.target.files[0];
  }
  a: Account = new Account('', '', '', '', '', '',
  null, false, false, false, false, null);
  b: Item = new Item('','','',null,'','',0,null);
  onUpload(){
    const fd = new FormData();
    fd.append('asdf',JSON.stringify(this.a));
    fd.append('qwer',JSON.stringify(this.b));
    this.http.post("http://localhost:8085/Maverick_OnlineGarageSale/UploadServlet",
    fd)
        .subscribe(res =>{
          console.log(res);
        })
  }



}
