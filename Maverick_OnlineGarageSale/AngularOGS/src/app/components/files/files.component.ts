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

  onUpload(){
    const fd = new FormData();
    fd.append('file_name',this.selectedFile.name);
    fd.append('file',this.selectedFile);
    this.http.post("http://localhost:8085/Maverick_OnlineGarageSale/UploadServlet",
    fd)
        .subscribe(res =>{
          console.log(res);
        })
  }


}
