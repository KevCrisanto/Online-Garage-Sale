import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { Account } from '../objects/account';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // getAllUsersUrl = "http://localhost:8085/Maverick_OnlineGarageSale/GetAllUsersServlets";
  // deleteUserUrl = "http://localhost:8085/Maverick_OnlineGarageSale/DeleteUserByIdServlet";
  getAllUsersUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/GetAllUsersServlets";
  deleteUserUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/DeleteUserByIdServlet";

  constructor(private http: HttpClient) { }

  getAllUsers(){
    return this.http.get<Account[]>(this.getAllUsersUrl);
  }

  deleteUser(id: String){
    return this.http.post<String>(this.deleteUserUrl, id);
  }
}
