import { Subscriptions } from './subscriptions';
export class Tier {
    constructor(
        public tier_id: number,
        public name: string,
        public subs: Subscriptions[]
      ) {}
}
