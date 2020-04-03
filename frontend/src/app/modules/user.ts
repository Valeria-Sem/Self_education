import {Status} from "./wallet";

export class User {

  idUser: number;
  login: string;
  password: string;
  role: Role;
  idWallet: string;
  balance: number;
  walletStatus: Status;
  idStudent: string;
  name: string;
  surname: string;
  idGroup: string;
  groupName: string;


  constructor(login: string, password: string, role: Role, balance: number, walletStatus: Status,   groupName: string) {
    this.login = login;
    this.password = password;
    this.role = role;
    this.balance = balance;
    this.walletStatus = walletStatus;
    this.groupName = groupName;
  }


}

export enum Role {
  ADMIN = "ADMIN",
  USER = "USER"
}

