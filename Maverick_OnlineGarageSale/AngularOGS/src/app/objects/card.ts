import { Account } from "./account";
import { Address } from "./address";

export class Card{
    constructor(
        public cardNumber: string,
        public userAccount: Account,
        public cardName: string,
        public expiration: string,
        public cvv: string,
        public address: Address
    ){}
    
}