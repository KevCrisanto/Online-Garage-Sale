import { CreditCard } from './credit-card';
export class Address {
    constructor(
        addressId: string,
        addressLine1: string,
        addressLine2: string,
        aptNumber: string,
        postOfficeBox: string,
        city: string,
        country: string,
        zipcode: string,
        creditCards: CreditCard[]

      ) {}
}
