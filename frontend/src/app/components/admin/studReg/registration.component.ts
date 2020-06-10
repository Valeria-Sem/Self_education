import {ChangeDetectorRef, Component, OnInit, TemplateRef} from "@angular/core";
import {Role, User} from "../../../modules/user";
import {Status} from "../../../modules/wallet";
import {RegistrationService} from "../../../services/registration.service";
import {GroupService} from "../../../services/group.service";
import {Group} from "../../../modules/group";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";

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
  private subscriptions: Subscription[] = []
  public patronymic: string;
  public idGroup: string;
  public balance: number = 15;
  public walletStatus: Status = Status.ACTIVE;
  public role: Role = Role.USER;
  groups: Group[];
  bsModalRef: BsModalRef;
  unauthorizedError: string = null;


  constructor(private registrationService:RegistrationService,
              private cdr: ChangeDetectorRef,
              private groupService: GroupService,
              private modalService: BsModalService) {
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

  public saveStudent(information, template: TemplateRef<any>): void {
    this.information = new User(this.name, this.surname, this.patronymic,
      this.idGroup, this.login, this.password, this.role, this.balance,
      this.walletStatus);
    this.subscriptions.push( this.registrationService.saveStudent(this.information).subscribe((user) =>{
      this.registrationService.userForRegister = user as User;
      if (this.registrationService.userForRegister.errors == null) {
         this.openModal(template);
      }
    }, error => {
      if (error.status == 500) {
        this.unauthorizedError = 'This login already exist';
        // this.login.value = '';
        // this.password.nativeElement.value = '';
      }
    }))
  }

  openModal(template: TemplateRef<any>) {
    this.bsModalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }
}
