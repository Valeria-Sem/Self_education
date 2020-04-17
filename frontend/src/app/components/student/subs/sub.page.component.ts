import {ChangeDetectorRef, Component, TemplateRef} from "@angular/core";
// import {Product} from "../../modules/product";
// import {Status, Wallet} from "../../modules/wallet";
// import {Role, User} from "../../modules/user";
// import {Subscription, SubStatus} from "../../modules/subscription";
// import {ProductService} from "../../services/product.service";
// import {WalletService} from "../../services/wallet.service";
import {BsModalService} from "ngx-bootstrap";
import {Status, Wallet} from "../../../modules/wallet";
import {Role, User} from "../../../modules/user";
import {Product} from "../../../modules/product";
import {Subscription, SubStatus} from "../../../modules/subscription";
import {StudProd} from "../../../modules/StudProd";
import {ProductService} from "../../../services/product.service";
import {WalletService} from "../../../services/wallet.service";
import {SubService} from "../../../services/subscription.service";
import {UserService} from "../../../services/user.service";
// import {SubService} from "../../services/subscription.service";
// import {UserService} from "../../services/user.service";
// import {CustProd} from "../../modules/CustProd";
// import {Page} from "../../modules/page";


@Component({
  selector: "app-sub.page",
  templateUrl: "./sub.page.component.html",
  styleUrls: ['./sub.page.component.css']
})
export class SubPageComponent {
  // products: Page;
  public wallet: Wallet;
  public user: User = this.userService.currentUser;
  public newBalance: number;
  public walletStatus: Status = 0;
  public balance: number;
  product: Product;
  subscription: Subscription;
  public subscriptionStatus: SubStatus = 0;
  isCust: boolean = false;
  cust: string = Role.USER;
  studProd: StudProd[];
  currentPage: number = 0;
  page: number;

  constructor(private productService: ProductService,
              private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private subService: SubService,
              private userService: UserService) {}


  // pageChanged(event: any): void {
  //   this.currentPage = event.page - 1;
  //   if(this.user.role !== this.cust) {
  //     this.productService.getProductsByIdOrganisation(this.user.idOrganisation, this.currentPage, 6).subscribe((data) => {
  //       this.products = data as Page;
  //       this.cdr.detectChanges();
  //     });
  //   } else {
  //     this.subService.getSub(this.user.idCustomer).subscribe((data) => {
  //       this.custProd = data as CustProd[];
  //     });}
  // }

  ngOnInit(){
      this.subService.getSub(this.user.idStudent).subscribe((data) => {
        this.studProd = data as StudProd[];
      });
  }


  public unsubscribe(idSub){
    this.subService.unsubscribe(idSub).subscribe(() => {
      this.studProd = this.studProd.filter(product => {
        return product.idSubscription !== idSub;
      })
    });
  }

}
