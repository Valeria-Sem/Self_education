export class Report {
  idSubscription: string;
  idProduct: string;
  studentId: string;
  name: string;
  surname: string;
  patronymic: string;


  constructor(idSubscription: string,
              idProduct: string, name: string,
              studentId: string, surname: string,
              patronymic: string) {
    this.idSubscription = idSubscription;
    this.studentId = studentId;
    this.idProduct = idProduct;
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
  }
}


