import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {BsDropdownConfig, BsModalService} from "ngx-bootstrap";
import {Group} from "../../modules/group";
import {GroupService} from "../../services/group.service";

@Component({
  selector: "app-groups",
  templateUrl: "./groups.component.html",
  styleUrls: ['./groups.component.css']
  // providers: [{ provide:, useValue: { isAnimated: true, autoClose: true } }]
})
export class GroupsComponent implements OnInit{
  groups: Group[];


  constructor(private groupService: GroupService,
              // private userService: UserService,
              // private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService
              // private subService: SubService,private organisationService: OrganisationService
              ) {
  }

  ngOnInit(): void {
    this.groupService.getGroups().subscribe((data) => {
      this.groups = data as Group[];
      this.cdr.detectChanges();
    });
  }
}
