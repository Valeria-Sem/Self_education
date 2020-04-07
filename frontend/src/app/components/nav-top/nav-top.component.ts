import {ChangeDetectorRef, Component, OnInit, TemplateRef} from "@angular/core";
import {BsDropdownConfig, BsModalRef, BsModalService} from "ngx-bootstrap";
import {Router} from "@angular/router";
import {Course} from "../../modules/course";
import {CourseService} from "../../services/subject.service";
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from "../../modules/user";
import {UserService} from "../../services/user.service";
import {Subscription} from "rxjs";
import {getTemplate} from "codelyzer/util/ngQuery";


@Component({
  selector: "app-nav-top",
  templateUrl: "./nav-top.component.html",
  styleUrls: ['./nav-top.component.css'],
  providers: [{ provide: BsDropdownConfig, useValue: { isAnimated: true, autoClose: true } }]
})
export class NavTopComponent implements OnInit{
  loaded: boolean;
  course: Course[];
  modalRef: BsModalRef | null;
  modalRef2: BsModalRef;
  myForm: FormGroup;
  private subscriptions: Subscription[] = [];
  loginForm: FormGroup;
  public user: User = this.userService.currentUser;
  user$ = this.userService.currentUser$;
  // products: Product[];
  public login: string;
  public password: string;
  // countOfElements: Page;
  // productEntities: Page;
  currentPage: number = 0;


  constructor(private modalService: BsModalService,
              private courseService: CourseService,
              private cdr: ChangeDetectorRef,
              private formBuilder: FormBuilder,
              private userService: UserService,
              private router: Router) {
  // private productService: ProductService
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }

  openModal2(template: TemplateRef<any>) {
    this.modalRef.hide();
    this.modalRef2 = this.modalService.show(template, {class: 'second'});
  }

  closeModal2(template: TemplateRef<any>) {
    this.modalRef2.hide();
  }

  ngOnInit(): void {
    this.loaded = true;
    this.courseService.getSubjects().subscribe((data) => {
      this.course = data as Course[];
      this.cdr.detectChanges();
    });

    this.myForm = this.formBuilder.group({
      radio: ''
    });

    this.loginForm = new FormGroup({
      "userLogin": new FormControl("", [Validators.required]),
      "userPassword": new FormControl("", Validators.required)
    });
  }

  public getUserInfo(login, password): void {
    // console.log(this.loginForm);
    this.subscriptions.push(
      this.userService.getUserInfo(login, password)
        .subscribe(() => {
            this.modalRef.hide();
          }
        )
    )

    if(this.user.role == 'ADMIN'){
      // this.router.navigate(['/']);

    }
  }

  onHidden(): void {
    console.log('Dropdown is hidden');
  }

  onShown(): void {
    console.log('Dropdown is shown');

  }

  isOpenChange(): void {
    console.log('Dropdown state is changed');
  }

  public onCoursesClickHandler(event: any){
    let files = event.target;
  }

  public logout(): void {
    this.userService.setUser(null);
    localStorage.removeItem("user");
    this.router.navigate(['/']);
  }
}
