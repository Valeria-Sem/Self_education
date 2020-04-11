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


@Component({
  selector: "app-php",
  templateUrl: "./php.component.html",
  styleUrls: ['./php.component.css']
})
export class PHPComponent implements OnInit {
  // @ViewChild('childModal', {read: false}) childModal: ModalDirective;

  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  public walletStatus: Status = Status.ACTIVE;
  public balance: number;
  product: Product;
  modalRef: BsModalRef;
  modalRef2: BsModalRef;

  constructor(private productService: ProductService,
              private userService: UserService,
              // private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService)
  // private subService: SubService)
  {
  }

  ngOnInit(): void {
    this.productService.getProductByCourseId('6').subscribe((data) => {
      this.product = data as Product;
      this.cdr.detectChanges();
    });
  }

  // hideChildModal(): void {
  //   this.childModal.hide();
  // }


  // public getCustomerSubs(){
  //   this.subService.getSub(this.user.idCustomer).subscribe((dataProd) => {
  //     this.custProd = dataProd;
  //
  //     this.products.productEntities.forEach((product) => {
  //
  //       this.custProd.forEach((subscription) => {
  //         if (product.name == subscription.name) {
  //           let element: HTMLElement = document.getElementById(subscription.name);
  //           element.classList.add('disabled');
  //         }
  //       })
  //     })
  //   });
  // }


  // public payAndSub (monthPrise, template: TemplateRef<any>, idProd, idOrg): void {
  //   if (this.user.balance < monthPrise) {
  //     this.childModal.show();
  //   } else {
  //     this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  //     this.balance = (+this.user.balance) - (+monthPrise);
  //     this.wallet = new Wallet(this.user.idWallet, this.balance, this.walletStatus);
  //     this.walletService.payment(this.wallet).subscribe(() => {
  //       this.userService.currentUser.balance = this.balance;
  //       localStorage.setItem("user", JSON.stringify(this.userService.currentUser));
  //     });
  //
  //     this.dateOfSub = new Date();
  //     this.subscription = new Subscription(idProd, this.user.idCustomer, this.subscriptionStatus, this.dateOfSub);
  //     this.subService.subscribeCustomer(this.subscription, this.user.idCustomer, idProd).subscribe();
  //
  //     this.walletService.balanceReplenishmentByOrg(idOrg, monthPrise).subscribe( () =>{
  //       this.getCustomerSubs();
  //     });
  //   }
  // }
}
