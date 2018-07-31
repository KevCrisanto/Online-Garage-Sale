import { Account } from "./account";
import { Address } from "./address";

export class Card{
    constructor(
        cardNumber: string,
        userAccount: Account,
        cardName: string,
        expiration: string,
        cvv: string,
        address: Address
    ){}
    
}