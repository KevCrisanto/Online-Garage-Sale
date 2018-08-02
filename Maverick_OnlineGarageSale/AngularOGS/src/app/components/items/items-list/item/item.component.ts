import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../../../../objects/item';
import {Router, NavigationExtras} from "@angular/router";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  @Input() item: Item;
  constructor(private router: Router) {}

  ngOnInit() {}
  public onTap() {
    let navigationExtras: NavigationExtras = {
        queryParams: {
            "item": JSON.stringify(this.item)
        }
    };
    this.router.navigate(["item-detail"], navigationExtras);
  }
}
