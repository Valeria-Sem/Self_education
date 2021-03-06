import {ChangeDetectorRef, Component, OnInit, TemplateRef, ViewChild} from "@angular/core";
import {Wallet} from "../../../modules/wallet";
import {BsModalRef, BsModalService, ModalDirective} from "ngx-bootstrap";
import {User} from "../../../modules/user";
import {UserService} from "../../../services/user.service";
import {Product} from "../../../modules/product";
import {ProductService} from "../../../services/product.service";
import {SubService} from "../../../services/subscription.service";
import {StudProd} from "../../../modules/StudProd";
import {SubStatus} from "../../../modules/subscription";
import {WalletService} from "../../../services/wallet.service";


@Component({
  selector: "app-sharp",
  templateUrl: "./sharp.component.html",
  styleUrls: ['./sharp.component.css']
})
export class SharpComponent implements OnInit {
  @ViewChild('childModal', {read: false}) childModal: ModalDirective;
  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  user$ = this.userService.currentUser$;
  public balance: number;
  product: Product;
  modalRef: BsModalRef;
  studProd: StudProd[];
  subscription: StudProd;
  public status: SubStatus = SubStatus.ACTIVE;
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
    this.productService.getProductByCourseId('2').subscribe((data) => {
      this.product = data as Product;
      this.cdr.detectChanges();
    });
    this.getStudentSubs();
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

      this.subscription = new StudProd( this.user.idStudent.toString(), this.product.idProduct, SubStatus.ACTIVE );
      this.subService.subscribeStudent(this.subscription, this.user.idStudent, this.product.idProduct).subscribe();
      this.getStudentSubs();
      this.isVisibleButton = false;
      console.log(this.subscription)
    }
  }
}
