import {ChangeDetectorRef, OnInit, Component, TemplateRef, ViewChild} from "@angular/core";
// import {Product} from "../../../modules/product";
// import {ProductService} from "../../../services/product.service";
import {Status, Wallet} from "../../../modules/wallet";
// import {WalletService} from "../../../services/wallet.service";
import {BsModalRef, BsModalService, ModalDirective} from "ngx-bootstrap";
// import {Subscription, SubStatus} from "../../../modules/subscription";
// import {SubService} from "../../../services/subscription.service";
import {User} from "../../../modules/user";
import {UserService} from "../../../services/user.service";
import {Product} from "../../../modules/product";
import {ProductService} from "../../../services/product.service";
import {Group} from "../../../modules/group";
import {SubService} from "../../../services/subscription.service";
import {StudProd} from "../../../modules/StudProd";
import {Page} from "../../../modules/page";
import {Subscription, SubStatus} from "../../../modules/subscription";
import {WalletService} from "../../../services/wallet.service";


@Component({
  selector: "app-java",
  templateUrl: "./java.component.html",
  styleUrls: ['./java.component.css']
})
export class JavaComponent implements OnInit {
  @ViewChild('childModal', {read: false}) childModal: ModalDirective;
  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  public balance: number;
  user$ = this.userService.currentUser$;
  product: Product;
  modalRef: BsModalRef;
  studProd: StudProd[];
  subscription: StudProd;
  public status: SubStatus = 0;
  bsModalRef: BsModalRef;
  isVisibleButton: boolean = true;

  constructor(private productService: ProductService,
              private userService: UserService,
              private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService,
              private subService: SubService)
  {
  }

  public getStudentSubs(){
    this.subService.getSub(this.user.idStudent).subscribe((data) => {
      this.studProd = data;
      this.studProd.forEach((subscription) => {
        if (this.product.productName == subscription.name) {
          // let element: HTMLElement = document.getElementById(subscription.name);
          // element.classList.add('disabled');
          this.isVisibleButton = false;
        }
      })
    });
  }

  ngOnInit(): void {
    this.productService.getProductByCourseId('3').subscribe((data) => {
      this.product = data as Product;
      this.cdr.detectChanges();
      this.getStudentSubs();
    });
  }

  hideChildModal(): void {
    this.childModal.hide();
  }

  public payAndSub (template: TemplateRef<any>): void {
    if (this.user.balance < this.product.price) {
      this.childModal.show();
    } else {
      this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
      this.balance = (+this.user.balance) - (+this.product.price);
      this.wallet = new Wallet(this.user.idWallet, this.balance, this.user.walletStatus);
      this.walletService.payment(this.wallet).subscribe(() => {
        this.userService.currentUser.balance = this.balance;
        localStorage.setItem("user", JSON.stringify(this.userService.currentUser));
      });

      this.subscription = new StudProd( this.user.idStudent.toString(), this.product.idProduct, this.status);
      this.subService.subscribeStudent(this.subscription, this.user.idStudent, this.product.idProduct).subscribe();
      this.getStudentSubs();
      this.isVisibleButton = false;
    }
  }
}
