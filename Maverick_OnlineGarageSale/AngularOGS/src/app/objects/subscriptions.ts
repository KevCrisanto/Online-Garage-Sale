import { Tier } from './tier';
export class Subscriptions {
    constructor(
        sub_id: number,
        userId: string,
        tiers: Tier[],
        subscriptionEndDate: Date
      ) {}
}
