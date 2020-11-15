import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {Group} from "../../../modules/group";
import {User} from "../../../modules/user";
import {GroupService} from "../../../services/group.service";
import {UserService} from "../../../services/user.service";
import {BsModalService} from "ngx-bootstrap";
import {Router} from "@angular/router";
import {SubService} from "../../../services/subscription.service";
import {ProductService} from "../../../services/product.service";
import {Product} from "../../../modules/product";
import {Report} from "../../../modules/report";
import {DocumentCreator} from "../studentPage/cv-generator";
import {achievements, education, experiences, skills} from "../studentPage/cv-data";
import {Packer} from "docx";
import {saveAs} from "file-saver";


@Component({
  selector: "app-admin-courses",
  templateUrl: "./admin-courses.component.html",
  styleUrls: ['./admin-courses.component.css']
})
export class AdminCoursesComponent implements OnInit{
  products: Product[];
  product: Product;
  users: Report[];
  selectedId: string;

  constructor(private groupService: GroupService,
              private userService: UserService,
              private subscriptionService: SubService,
              private productService: ProductService,
              // private walletService: WalletService,
              private cdr: ChangeDetectorRef,
              private modalService: BsModalService,
              private route: Router
              // private subService: SubService,private organisationService: OrganisationService
  ) {
  }

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe((data) => {
      this.products = data as Product[];
      this.cdr.detectChanges();
    });
  }

  public students(event: any, idProduct: string): void {
    this.subscriptionService.getStud(idProduct).subscribe((data) => {
      this.users = data as Report[];
      this.cdr.detectChanges();
    });
  }
  name = "Angular";

  public download(): void {
    const documentCreator = new DocumentCreator();
    const doc = documentCreator.create([
      experiences,
      education,
      skills,
      achievements
      // this.user.name
    ]);

    Packer.toBlob(doc).then(blob => {
      console.log(blob);
      saveAs(blob, "report.docx");
      console.log("Document created successfully");
    });
  }

   Export2Doc(element, filename = ''){
    let preHtml = "<html xmlns:o='urn:schemas-microsoft-com:office:office' " +
      "xmlns:w='urn:schemas-microsoft-com:office:word' " +
      "xmlns='http://www.w3.org/TR/REC-html40'><head><meta charset='utf-8'>" +
      "<title>Export HTML To Docx</title></head><body>";
     let postHtml = "</body></html>";
     let html = preHtml+document.getElementById(element).innerHTML+postHtml;

     let blob = new Blob(['\ufeff', html], {
      type: 'application/msword'
    });

    // Specify link url
     let url = 'data:application/vnd.ms-word;charset=utf-8,' + encodeURIComponent(html);

    // Specify file name
    filename = filename?filename+'.doc':'document.doc';

    // Create download link element
     let downloadLink = document.createElement("a");

    document.body.appendChild(downloadLink);

    if(navigator.msSaveOrOpenBlob ){
      navigator.msSaveOrOpenBlob(blob, filename);
    }else{
      // Create a link to the file
      downloadLink.href = url;

      // Setting the file name
      downloadLink.download = filename;

      //triggering the function
      downloadLink.click();
    }

    document.body.removeChild(downloadLink);

  }

}
