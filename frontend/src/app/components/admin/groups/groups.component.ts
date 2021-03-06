import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {BsDropdownConfig, BsModalService} from "ngx-bootstrap";
import {Group} from "../../../modules/group";
import {GroupService} from "../../../services/group.service";
import {UserService} from "../../../services/user.service";
import {User} from "../../../modules/user";
import {Router} from "@angular/router";
import {switchMap} from "rxjs/operators";

@Component({
  selector: "app-groups",
  templateUrl: "./groups.component.html",
  styleUrls: ['./groups.component.css']
  // providers: [{ provide:, useValue: { isAnimated: true, autoClose: true } }]
})

export class GroupsComponent implements OnInit{
  groups: Group[];
  group: Group;
  users: User[];
  selectedId: string;


  constructor(private groupService: GroupService,
              private userService: UserService,
              // private userService: UserService,
              // private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService,
              private route: Router
    // private subService: SubService,private organisationService: OrganisationService
              ) {
  }

  ngOnInit(): void {
    this.groupService.getGroups().subscribe((data) => {
      this.groups = data as Group[];
      this.cdr.detectChanges();
    });

  }

  public students(event: any, idGroup: string): void {
    this.userService.getUsersByIdGroup(idGroup).subscribe((data) => {
      this.users = data as User[];
      this.cdr.detectChanges();
    });
  }
  //
  // public students(idGroup: string): void {
  //   console.log("Items load");
  //   this.userService.getUsersByIdGroup(idGroup).subscribe((data) => {
  //     this.users = data as User;
  //     this.cdr.detectChanges();
  //   });
  // }

  delete(idGroup: string): void{
    this.groupService.deleteGroup(idGroup).subscribe(() =>{
      this.groupService.getGroups().subscribe((data) => {
        this.groups = data as Group[];
        this.cdr.detectChanges();
      });
    });
  }

}
