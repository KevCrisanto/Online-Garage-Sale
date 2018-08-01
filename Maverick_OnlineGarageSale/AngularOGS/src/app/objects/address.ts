import { CreditCard } from './credit-card';
export class Address {
    constructor(
        public addressId: string,
        public addressLine1: string,
        public addressLine2: string,
        public aptNumber: string,
        public postOfficeBox: string,
        public city: string,
        public country: string,
        public zipcode: string,
        public creditCards: CreditCard[]

      ) {}
}
