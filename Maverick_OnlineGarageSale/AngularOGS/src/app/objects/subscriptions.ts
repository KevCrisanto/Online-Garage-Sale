import { Tier } from './tier';
export class Subscriptions {
    constructor(
        public sub_id: number,
        public userId: string,
        public tiers: Tier[],
        public subscriptionEndDate: Date
      ) {}
}
