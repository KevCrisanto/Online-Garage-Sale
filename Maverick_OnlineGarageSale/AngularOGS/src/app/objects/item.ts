export class Item {
  constructor(
    public id: number,
    public name: string,
    public description: string,
    public category: string,
    public itemStatus: string,
    public price: number,
    public accountId: number
  ) {}
}
