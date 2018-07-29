import { Component, OnInit, ViewChild, ElementRef, DoCheck } from '@angular/core';
import { CardModule } from 'ngx-card/ngx-card';
import { NgForm } from '../../../../node_modules/@angular/forms';

@Component({
  selector: 'app-credit-card',
  templateUrl: './credit-card.component.html',
  styleUrls: ['./credit-card.component.css']
})
export class CreditCardComponent implements OnInit, DoCheck {

  imports: [
    CardModule
  ];

  @ViewChild('cardNumber') cardNumber: ElementRef;

  constructor() { }
  invalid;
  ngOnInit() {
  }

  ngDoCheck() {
    if (this.cardNumber.nativeElement.classList.contains('jp-card-invalid') || this.cardNumber.nativeElement.value === '') {
      console.log('Error');
      this.invalid = true;
    } else {
      this.invalid = false;
    }
  }

  test(form: NgForm) {
    console.log(form);
  }

}
