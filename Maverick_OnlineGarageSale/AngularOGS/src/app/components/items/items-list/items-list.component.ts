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
        name: 'Lamborghini Huracán 2018',
        description:
          'The Huracán maintains the 5.2 L naturally aspirated Audi/Lamborghini V10 engine from the Gallardo, tuned for 610 PS (449 kW; 602 hp). To ensure its balance and performance, the car is mid-engined. The V10 has both direct fuel injection and multi-point fuel injection.',
        category: 'cars',
        itemStatus: 'sold',
        price: 180000,
        accountId: 1,
        images: [
          'http://2.bp.blogspot.com/-7gFjnPs_j1w/TjlsJA3zjaI/AAAAAAAADEk/qhTVh8XrZuM/s1600/Saleen+S7+2002+02.jpg'
        ]
      },
      {
        id: 2,
        name: 'Mini robot',
        description:
          'Humanoid robot kit with open source embedded board; Compatibility with the 6mm grid Ollo frame;',
        category: 'toys',
        itemStatus: 'sold',
        price: 20,
        accountId: 1,
        images: [
          'http://www.robotshop.com/blog/en/files/alpha2_humanoid_robot.jpg'
        ]
      },
      {
        id: 3,
        name: 'Gaming computer',
        description:
          'A gaming computer is a desktop that is often custom-built for the purpose of increasing performance in modern computer games may require an increase graphical and processing power. One of the most significant differences between regular and gaming machines is video processing.',
        category: 'computers',
        itemStatus: 'sold',
        price: 900,
        accountId: 1,
        images: [
          'https://usedcomputersforsale.files.wordpress.com/2014/02/used-desktop-computers.jpg'
        ]
      }
    ];
  }

  ngOnInit() {}
}
