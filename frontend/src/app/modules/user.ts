import {Status} from "./wallet";

export class User {

  idUser: number;
  login: string;
  password: string;
  role: Role;

  idWallet: string;
  balance: number;
  walletStatus: Status;

  idStudent: number;
  name: string;
  surname: string;
  patronymic: string;

  idGroup: string;
  groupName: string;

  errors: Map<string, string>;


  constructor(name: string, surname: string, patronymic: string, idGroup: string, login: string, password: string, role: Role,
              balance: number, walletStatus: Status) {
    this.login = login;
    this.password = password;
    this.role = role;
    this.balance = balance;
    this.walletStatus = walletStatus;
    this.idGroup = idGroup;
    this.name = name;
    this.surname = surname;
    this.patronymic = patronymic;
  }


}

export enum Role {
  ADMIN = "ADMIN",
  USER = "USER"
}

