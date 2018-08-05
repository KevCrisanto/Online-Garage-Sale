import { ItemService } from './../../../services/item.service';
import { HttpClient } from '@angular/common/http';
import { Item } from './../../../objects/item';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Router, NavigationExtras} from "@angular/router";

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {
  imageUrlArray: string[] = [
    'http://2.bp.blogspot.com/-7gFjnPs_j1w/TjlsJA3zjaI/AAAAAAAADEk/qhTVh8XrZuM/s1600/Saleen+S7+2002+02.jpg',
    'http://www.robotshop.com/blog/en/files/alpha2_humanoid_robot.jpg',
    'https://usedcomputersforsale.files.wordpress.com/2014/02/used-desktop-computers.jpg'
  ];
  public item: Item = new Item('','','',null,'','',0,null);
  // public avgRatingUrl = "http://localhost:8085/Maverick_OnlineGarageSale/GetAvgRatingServlet";
  // public avgPremRatingUrl = "http://localhost:8085/Maverick_OnlineGarageSale/GetAvgPremRatingServlet";
  public avgRatingUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/GetAvgRatingServlet";
  public avgPremRatingUrl = "http://18.219.13.188:8085/Maverick_OnlineGarageSale/GetAvgPremRatingServlet";
  public avgRating: number = 0;
  public avgPremRating: number = 0;
  constructor(private route: ActivatedRoute,private http:HttpClient,private itemService: ItemService,
              private router: Router) {
    this.route.queryParams.subscribe(
      params => {
        this.itemService.getItemById(params["item"]).subscribe(
          data => {
            this.item = data;
            this.getAvgRating(data.accountId.accountId);
            this.getAvgPremRating(data.accountId.accountId);
          },
          error => {
            console.log('error');
          }
        );
      },
      error => {
        console.log('error');
      }
    );
  }

  ngOnInit() {}
  public onTap() {
    console.log(this.item.itemId);
    let navigationExtras: NavigationExtras = {
        queryParams: {
            "item": this.item.itemId
        }
    };
    this.router.navigate(["item-checkout"], navigationExtras);
  }
  public getAvgRating(accid: string){
    this.http.post<number>(this.avgRatingUrl, accid).subscribe(
      data => {
        console.log(data);
        this.avgRating = data;
      },
      error => {
        console.log('error');
      }
    );
  }

  public getAvgPremRating(accid: string){
    this.http.post<number>(this.avgPremRatingUrl, accid).subscribe(
      data => {
        console.log(data);
        this.avgPremRating = data;
      },
      error => {
        console.log('error');
      }
    );
  }
}
