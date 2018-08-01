import { CreditCard } from './credit-card';
export class Account {
  constructor(
    public id: string,
    public username: string,
    public password: string,
    public firstName: string,
    public lastName: string,
    public email: string,
    public Date: Date,
    public isVerified: boolean,
    public isPremium: boolean,
    public isAdmin: boolean,
    public isActive: boolean,
    creditCards: CreditCard[]
  ) {}
}
