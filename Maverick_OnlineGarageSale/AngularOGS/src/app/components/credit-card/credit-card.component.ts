import {
  Component,
  OnInit,
  ViewChild,
  ElementRef,
  DoCheck
} from '@angular/core';
import { CardModule } from 'ngx-card/ngx-card';
import { NgForm } from '../../../../node_modules/@angular/forms';
import { Account } from '../../objects/account';
import { Card } from '../../objects/card';
import { Address } from '../../objects/address';
import { CardService } from '../../services/card.service';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-credit-card',
  templateUrl: './credit-card.component.html',
  styleUrls: ['./credit-card.component.css']
})
export class CreditCardComponent implements OnInit, DoCheck {
  imports: [CardModule];

  @ViewChild('cardNumber') cardNumber: ElementRef;

  constructor(private cardS: CardService, private login: LoginService) {}
  accounts: Account[];
  account = new Account(
    '',
    '',
    '',
    '',
    '',
    '',
    null,
    false,
    false,
    false,
    false,
    null
  );
  invalid = false;
  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.account = account));
  }

  address = new Address(
    '',
    '809 Bobbert Way',
    '',
    '',
    '',
    'Denver',
    'USA',
    '80234',
    null
  );
  creditCard = new Card('', this.account, '', '', '', this.address);

  ngDoCheck() {
    if (
      this.cardNumber.nativeElement.classList.contains('jp-card-invalid') ||
      this.cardNumber.nativeElement.value === ''
    ) {
      console.log('Error');
      this.invalid = true;
    } else {
      this.invalid = false;
    }
  }

  insert(c: Card) {
    console.log(this.creditCard);
    console.log(this.account);
    console.log(this.address);
    this.cardS.cardService(this.creditCard).subscribe();
  }
}
