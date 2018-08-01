import { Account } from './account';
import { Address } from './address';
export class CreditCard {
    constructor(
        public cardNumber: string,
        public userAccounts: Account,
        public cardName: string,
        public expiration: Date,
        public cvv: string,
        public address: Address
      ) {}
}
