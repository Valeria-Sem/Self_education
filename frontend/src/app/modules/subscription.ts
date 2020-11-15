export class Subscription {
  idSubscription: string;
  idStudent: number;
  status: SubStatus;
  idProduct: string;

  constructor(idSubscription: string,idStudent: number,
              idProduct: string, status: SubStatus) {
    this.idSubscription = idSubscription;
    this.idProduct = idProduct;
    this.idStudent = idStudent;
    this.status = status;

  }
}

export enum SubStatus {
  ACTIVE = 1,
  FINISHED
}

