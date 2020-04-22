import {ChangeDetectorRef, Component, OnInit, TemplateRef} from "@angular/core";
import {StudProd} from "../../modules/StudProd";
import {GroupService} from "../../services/group.service";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SubService} from "../../services/subscription.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: "app-course.main.page",
  templateUrl: "./course.main.page.component.html",
  styleUrls: ['./course.main.page.component.css']
})
export class CourseMainPageComponent implements OnInit{
  isSharp: boolean = false;
  isPlus: boolean = false;
  isJava: boolean = false;
  isPython: boolean = false;
  isJS: boolean = false;
  isPHP: boolean = false;
  id: string;
  studProd: StudProd[];
  modalRef: BsModalRef;

  constructor(private subService: SubService,
              private cdr: ChangeDetectorRef,
              private router: Router,
              private route: ActivatedRoute,
              private modalService: BsModalService
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });

    if(this.id == ":1"){
      this.isPlus = true;
    } else if (this.id == ":2"){
      this.isSharp = true;
    } else if (this.id == ":3"){
      this.isJava = true;
    } else if (this.id == ":4"){
      this.isPython = true;
    } else if (this.id == ":5"){
      this.isJS = true;
    } else if (this.id == ":6"){
      this.isPHP = true;
    }
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-lg'}));
  }
}
