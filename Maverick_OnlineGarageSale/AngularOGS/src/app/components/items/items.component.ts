import { Component, OnInit, Input } from '@angular/core';
import { Item } from './../../objects/item'
import {Router, NavigationExtras} from "@angular/router";

@Component({
  selector: 'app-item',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {
  @Input() item: Item;
  constructor(private router: Router) {}

  ngOnInit() {}
  public onTap() {
    let navigationExtras: NavigationExtras = {
        queryParams: {
            "item": this.item.itemId
        }
    };
    this.router.navigate(["item-detail"], navigationExtras);
  }
}