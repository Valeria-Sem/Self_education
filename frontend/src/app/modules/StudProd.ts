import {SubStatus} from "./subscription";

export class StudProd {
  idSubscription: string;
  idStudent: string;
  idProduct: string;
  name: string;
  description: string;
  price: number;
  img: string;
  subscriptionStatus: SubStatus;


  constructor(idSubscription: string,
              idStudent: string, name: string,
              idProduct: string, description: string,
              price: number, img: string, subscriptionStatus: SubStatus) {
    this.idSubscription = idSubscription;
    this.idProduct = idProduct;
    this.idStudent = idStudent;
    this.name = name;
    this.description = description;
    this.price = price;
    this.img = img;
    this.subscriptionStatus = subscriptionStatus;

  }
}


