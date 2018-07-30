import { Component, OnInit } from '@angular/core';
import { Item } from '../../../objects/item';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {
  items: Item[];

  constructor() {
    this.items = [
      {
        id: 1,
        name: 'Ferrari',
        description: 'it is a car',
        category: 'cars',
        itemStatus: 'sold',
        price: 180000,
        accountId: 1
      },
      {
        id: 2,
        name: 'Ferrari 2',
        description: 'it is a car 2',
        category: 'cars 2',
        itemStatus: 'sold',
        price: 180000,
        accountId: 1
      }
    ];
  }

  ngOnInit() {}
}
