import { Account } from './account';
import { Item } from './item';
export class Transaction {
    constructor(
        transactionId: string,
        buyer: Account,
        seller: Account,
        item: Item,
        transactionAmount: number,
        memo: string
      ) {}
}
