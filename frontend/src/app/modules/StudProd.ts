import {SubStatus} from "./subscription";

export class StudProd {
  idSubscription: string;
  idStudent: string;
  productId: string;
  name: string;
  description: string;
  price: number;
  img: string;
  subscriptionStatus: SubStatus;


  constructor(idStudent: string,
              productId: string, subscriptionStatus: SubStatus) {
    // this.idSubscription = idSubscription;
    this.productId = productId;
    this.idStudent = idStudent;
    // this.name = name;
    // this.description = description;
    // this.price = price;
    // this.img = img;
    this.subscriptionStatus = subscriptionStatus;

  }
}


