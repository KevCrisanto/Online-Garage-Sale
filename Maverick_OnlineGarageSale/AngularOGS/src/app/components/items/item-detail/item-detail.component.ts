import { Item } from './../../../objects/item';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

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
  public item: Item;
  // public item: Item = new Item('','','',null,'','',0,null);
  constructor(private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
      this.item = JSON.parse(params["item"]);
      console.log(this.item);

    });
  }

  ngOnInit() {}
}
