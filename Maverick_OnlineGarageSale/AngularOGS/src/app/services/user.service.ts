import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { Account } from '../objects/account';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // getAllUsersUrl = "http://localhost:8085/Maverick_OnlineGarageSale/GetAllUsersServlets";
  // deleteUserUrl = "http://localhost:8085/Maverick_OnlineGarageSale/DeleteUserByIdServlet";
  // verifyUserUrl = "http://localhost:8085/Maverick_OnlineGarageSale/VerifyUserServlet";
  // upgradeUserUrl = "http://localhost:8085/Maverick_OnlineGarageSale/PremiumUpgradeServlet";
  // deleteItemUrl = "http://localhost:8085/Maverick_OnlineGarageSale/DeleteItemServlet";
  getAllUsersUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/GetAllUsersServlets";
  deleteUserUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/DeleteUserByIdServlet";
  verifyUserUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/VerifyUserServlet";
  upgradeUserUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/PremiumUpgradeServlet";
  deleteItemUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/DeleteItemServlet";

  constructor(private http: HttpClient) { }

  getAllUsers(){
    return this.http.get<Account[]>(this.getAllUsersUrl);
  }

  deleteUser(id: String){
    return this.http.post<String>(this.deleteUserUrl, id);
  }

  verifyUser(id: String){
    return this.http.post<String>(this.verifyUserUrl, id);
  }

  checkVerified(verified: boolean){
    if(verified){
      return true;
    }
    else{
      return false;
    }
  }

  upgradeUser(id: String){
    return this.http.post<String>(this.upgradeUserUrl, id);
  }

  checkPremium(verified: boolean, premium: boolean){
    if(verified){
      if(premium){
        return false;
      }
      else{
        return true;
      }
    }
  }

  deleteItemById(id: String){
    return this.http.post<String>(this.deleteItemUrl, id);
  }
 
}
