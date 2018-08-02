import { Account } from './account';
import { FileInfo } from './file';
// export class Item {
//   constructor(
//     public id: number,
//     public name: string,
//     public description: string,
//     public category: string,
//     public itemStatus: string,
//     public price: number,
//     public accountId: number,
//     public images: string[]
//   ) {}
// }
export class Item {
    constructor(
      public itemId: string,
      public itemName: string,
      public description: string,
      public accountId: Account,
      public category: string,
      public itemStatus: string,
      public price: number,
      public itemFile: FileInfo
    ) {}
  }