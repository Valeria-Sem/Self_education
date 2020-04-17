export class Subscription {
  idSubscription: string;
  idStudent: number;
  idProduct: string;
  status: SubStatus;

  constructor(idStudent: number,
              idProduct: string,
              status: SubStatus) {
    this.idProduct = idProduct;
    this.idStudent = idStudent;
    this.status = status;

  }
}

export enum SubStatus {
  ACTIVE,
  FINISHED
}

