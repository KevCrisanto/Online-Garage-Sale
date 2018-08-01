import { Item } from './item';
export class File {
    constructor(
        public fileId: string,
        public fileItem: Item,
        public filekey: string
      ) {}
}
