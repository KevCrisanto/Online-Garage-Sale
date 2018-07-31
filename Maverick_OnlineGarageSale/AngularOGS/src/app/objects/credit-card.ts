import { Account } from './account';
import { Address } from './address';
export class CreditCard {
    constructor(
        cardNumber: string,
        userAccounts: Account,
        cardName: string,
        expiration: Date,
        cvv: string,
        address: Address
      ) {}
}
