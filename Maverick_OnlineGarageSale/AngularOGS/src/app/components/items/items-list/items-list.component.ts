import { ItemService } from './../../../services/item.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Item } from '../../../objects/item';
import { FileInfo } from '../../../objects/file';
import { Account } from '../../../objects/account';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {
  items: Item[];
  constructor(private http: HttpClient, private itemService: ItemService) {
    // this.items = [
    //   {
    //     itemId: '1',
    //     itemName: 'Lamborghini Huracán 2018',
    //     description:
    //       'The Huracán maintains the 5.2 L naturally aspirated Audi/Lamborghini V10 engine from the Gallardo, tuned for 610 PS (449 kW; 602 hp). To ensure its balance and performance, the car is mid-engined. The V10 has both direct fuel injection and multi-point fuel injection.',
    //     category: 'cars',
    //     itemStatus: 'sold',
    //     price: 180000,
    //     accountId: new Account('1', '', '', '', '', '',
    //     null, false, false, false, false, null),
    //     itemFile: new FileInfo('','http://2.bp.blogspot.com/-7gFjnPs_j1w/TjlsJA3zjaI/AAAAAAAADEk/qhTVh8XrZuM/s1600/Saleen+S7+2002+02.jpg')
    //     // images: [
    //     //   'http://2.bp.blogspot.com/-7gFjnPs_j1w/TjlsJA3zjaI/AAAAAAAADEk/qhTVh8XrZuM/s1600/Saleen+S7+2002+02.jpg'
    //     // ]
    //   },
    //   {
    //     itemId: '2',
    //     itemName: 'Mini robot',
    //     description:
    //       'Humanoid robot kit with open source embedded board; Compatibility with the 6mm grid Ollo frame;',
    //     category: 'toys',
    //     itemStatus: 'sold',
    //     price: 20,
    //     accountId: new Account('1', '', '', '', '', '',
    //     null, false, false, false, false, null),
    //     itemFile: new FileInfo('','http://www.robotshop.com/blog/en/files/alpha2_humanoid_robot.jpg')
    //     // images: [
    //     //   'http://www.robotshop.com/blog/en/files/alpha2_humanoid_robot.jpg'
    //     // ]
    //   },
    //   {
    //     itemId: '3',
    //     itemName: 'Gaming computer',
    //     description:
    //       'A gaming computer is a desktop that is often custom-built for the purpose of increasing performance in modern computer games may require an increase graphical and processing power. One of the most significant differences between regular and gaming machines is video processing.',
    //     category: 'computers',
    //     itemStatus: 'sold',
    //     price: 900,
    //     accountId: new Account('1', '', '', '', '', '',
    //     null, false, false, false, false, null),
    //     itemFile: new FileInfo('','https://usedcomputersforsale.files.wordpress.com/2014/02/used-desktop-computers.jpg')
    //     // images: [
    //     //   'https://usedcomputersforsale.files.wordpress.com/2014/02/used-desktop-computers.jpg'
    //     // ]
    //   }
    // ];
    this.getItems();
  }

  ngOnInit() {}

  getItems() {
    this.itemService.getItemsForSale().subscribe(
      data => {
        this.items = data;
      },
      error => {
        console.log('error');
      }
    );
  }
  // getItems(){

  //   this.trans.getTransactions(this.account).subscribe(
  //     data => {
  //       this.transactions = data;
  //       console.log(data);
  //     },
  //     error => {
  //       console.log('error');
  //     }
  //   );
}
