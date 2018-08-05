import { Account } from './account';
import { Item } from './item';
export class Transaction {
    constructor(
        public transactionId: string,
        public buyer: Account,
        public seller: Account,
        public item: Item,
        public transactionAmount: number,
        public memo: string,
        public rating: number
      ) {}
}
