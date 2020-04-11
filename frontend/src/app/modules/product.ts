export class Product {
  idProduct: string;
  productName: string;
  description: string;
  courseId: string;
  price: number;
  img: string;


  constructor( productName: string, description: string,
               courseId: string, price: number, img: string) {
    this.productName = productName;
    this.description = description;
    this.courseId = courseId;
    this.price = price;
    this.img = img;
  }
}


