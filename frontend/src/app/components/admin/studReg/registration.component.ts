import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {Role, User} from "../../../modules/user";
import {Status} from "../../../modules/wallet";
import {RegistrationService} from "../../../services/registration.service";
import {GroupService} from "../../../services/group.service";
import {Group} from "../../../modules/group";

@Component({
  selector: "app-studReg",
  templateUrl: "./registration.component.html",
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit{

  information: User;
  public login: string;
  public password: string = "123456";
  public name: string;
  public surname: string;
  public patronymic: string;
  public idGroup: string;
  public balance: number = 15;
  public walletStatus: Status = Status.ACTIVE;
  public role: Role = Role.USER;
  groups: Group[];

  constructor(private registrationService:RegistrationService,
              private cdr: ChangeDetectorRef,
              private groupService: GroupService) {
  }

  ngOnInit(){
    this.groupService.getGroups().subscribe((data) => {
      this.groups = data as Group[];
      this.cdr.detectChanges();
    });
  }

  public getGroupId(group){
    this.idGroup = group;
  }

  public saveStudent(information): void {
    this.information = new User(this.name, this.surname, this.patronymic,
      this.idGroup, this.login, this.password, this.role, this.balance,
      this.walletStatus);
    this.registrationService.saveStudent(this.information).subscribe();
  }
}
