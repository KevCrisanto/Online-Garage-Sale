import { Component, OnInit, Input } from '@angular/core';
import { Item } from './../../objects/item'

@Component({
  selector: 'app-item',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {
  @Input() item: Item;
  constructor() {}

  ngOnInit() {}
}