import { Card } from './card';
export class Account {
  constructor(
    public accountId: string,
    public username: string,
    public password: string,
    public firstName: string,
    public lastName: string,
    public email: string,
    public creationDate: Date,
    public isVerified: boolean,
    public isPremium: boolean,
    public isAdmin: boolean,
    public isActive: boolean,
    public creditCards: Card[]
  ) {}
}
