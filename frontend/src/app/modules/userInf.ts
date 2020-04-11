import {Role} from "./user";

export class UserInf {

  idUser: number;
  login: string;
  password: string;
  role: Role


  constructor(idUser: number, login: string, password: string, role: Role) {
    this.idUser = idUser;
    this.login = login;
    this.password = password;
    this.role = role;
  }


}
