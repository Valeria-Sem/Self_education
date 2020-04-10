import {ChangeDetectorRef, Component, Input, OnInit} from "@angular/core";
import {GroupService} from "../../../services/group.service";
import {UserService} from "../../../services/user.service";
import {BsModalService} from "ngx-bootstrap";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../../../modules/user";
import {Group} from "../../../modules/group";

@Component({
  selector: "app-studPage",
  templateUrl: "./studentPage.component.html",
  styleUrls: ['./studentPage.component.css']
})
export class StudentPageComponent implements OnInit{

  id: string;
  user: User;
  group: Group;

  constructor(private groupService: GroupService,
              private userService: UserService,
              private cdr: ChangeDetectorRef,
              private router: Router,
              private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });

    this.userService.getStudentById(this.id.substr(1, 2)).subscribe((data) => {
      this.user = data as User;
      this.cdr.detectChanges();
    });

  }
  //
  // public groups(event: any, idGroup: string): void {
  //   this.groupService.getGroupById(idGroup).subscribe((data) => {
  //     this.group = data as Group;
  //     this.cdr.detectChanges();
  //   });
  // }
}
