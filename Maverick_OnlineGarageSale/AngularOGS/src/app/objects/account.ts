import { CreditCard } from './credit-card';
export class Account {
  constructor(
    id: string,
    username: string,
    password: string,
    firstName: string,
    lastName: string,
    email: string,
    Date: Date,
    isVerified: boolean,
    isPremium: boolean,
    isAdmin: boolean,
    isActive: boolean,
    creditCards: CreditCard[]
  ) {}
}
