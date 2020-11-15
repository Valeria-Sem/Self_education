import {ChangeDetectorRef, Component, OnInit, TemplateRef, ViewChild} from "@angular/core";
import {BsModalRef, BsModalService, ModalDirective} from "ngx-bootstrap";
import {SubService} from "../../../services/subscription.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Lectures} from "../../../modules/lectures";
import {LecturesService} from "../../../services/lectures.service";
import {PassedTest} from "../../../modules/passedTest";
import {PassedTestService} from "../../../services/passedTest.service";
import {User} from "../../../modules/user";
import {UserService} from "../../../services/user.service";
import {Testing} from "../../../modules/testing";
import {Subscription, SubStatus} from "../../../modules/subscription";

@Component({
  selector: "app-lectures",
  templateUrl: "./lectures.component.html",
  styleUrls: ['./lectures.component.css']
})

export class LecturesComponent implements OnInit{
  @ViewChild('childModal', {read: false}) childModal: ModalDirective;
  id: string;
  lectures: Lectures[];
  modalRef: BsModalRef;
  passedTest: PassedTest;
  public user: User = this.userService.currentUser;
  testing: Testing;
  idTest: number;
  subscription: Subscription;
  isVisible: boolean = true;


  constructor(private lecturesService: LecturesService,
              private subService: SubService,
              private cdr: ChangeDetectorRef,
              private router: Router,
              private userService: UserService,
              private route: ActivatedRoute,
              private modalService: BsModalService,
              private passedTestService: PassedTestService
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });

    this.subService.getSubscription(this.user.idStudent ,this.id.substr(1, 2)).subscribe((data) => {
      this.subscription = data as Subscription;
      this.cdr.detectChanges();
      if(this.subscription.status === SubStatus.FINISHED){
        this.isVisible = false;
      }
    });

    this.lecturesService.getLecturesByIdProduct(this.id.substr(1, 2)).subscribe((data) => {
      this.lectures = data as Lectures[];
      this.cdr.detectChanges();
    });

    if(this.subscription.status === SubStatus.ACTIVE){
      this.isVisible = false;
    }
  }

  hideChildModal(): void {
    this.childModal.hide();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-lg'}));
    if(this.subscription.status === SubStatus.ACTIVE){
      this.isVisible = false;
    }
  }

  getResult(idLec: string, template: TemplateRef<any>): void{
    this.idTest = (+idLec) - 1;
    this.passedTestService.findResult(this.user.idStudent, this.idTest.toString()).subscribe((data) => {
      this.testing = data as Testing;
      this.cdr.detectChanges();
      if(this.testing.isExist === false){
        if(this.idTest === 0 || this.idTest === 9 || this.idTest === 17 ||
          this.idTest === 23 || this.idTest === 32 || this.idTest === 41){
          this.openModal(template);
        } else {
          this.childModal.show();
        }

      } else {
        this.openModal(template);
      }
    });
  }

  // finishEducation(){
  //   this.subscription = new Subscription( this.subscription.idSubscription ,this.subscription.idStudent,
  //     SubStatus.FINISHED, this.subscription.idProduct);
  //   this.subService.finishSub(this.subscription, this.user.idStudent, this.id.substr(1, 2)).subscribe();
  // }
}



