import {ChangeDetectorRef, Component, Input, OnInit} from "@angular/core";
import {GroupService} from "../../../services/group.service";
import {UserService} from "../../../services/user.service";
import {BsModalService} from "ngx-bootstrap";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../../../modules/user";
import {Group} from "../../../modules/group";
import {StudProd} from "../../../modules/StudProd";
import {SubService} from "../../../services/subscription.service";
import { Document, HeadingLevel, Media, Packer, Paragraph, Table, TableCell, TableRow, VerticalAlign} from "docx";
import { saveAs } from "file-saver";
// import * as fileSaver from 'file-saver';
import { experiences, education, skills, achievements } from "./cv-data";
import { DocumentCreator } from "./cv-generator";
// import * as fs ;

@Component({
  selector: "app-studPage",
  templateUrl: "./studentPage.component.html",
  styleUrls: ['./studentPage.component.css']
})
export class StudentPageComponent implements OnInit{

  id: string;
  user: User;
  group: Group;
  studProd: StudProd[];

  doc = new Document();

  // image1 = Media.addImage(this.doc, fs.readFileSync(".assets\\img\\coin.png"))

  constructor(private groupService: GroupService,
              private userService: UserService,
              private cdr: ChangeDetectorRef,
              private router: Router,
              private subService: SubService,
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

    this.subService.getSub(+this.id.substr(1, 2)).subscribe((data) => {
      this.studProd = data as StudProd[];
    });
  }
  //
  // public groups(event: any, idGroup: string): void {
  //   this.groupService.getGroupById(idGroup).subscribe((data) => {
  //     this.group = data as Group;
  //     this.cdr.detectChanges();
  //   });
  // }

  //  newContent() {
  //   alert("загрузка нового контента");
  //   document.open();
  //   // document.getElementById(this.id = 'tab1')
  //   document.write("<h1>Долой старое, да здравствует новое!</h1>");
  //   document.close();
  // }

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
      saveAs(blob, this.user.name + ".docx");
      console.log("Document created successfully");
    });
  }

  Export2Doc(element, element2, filename = ''){
    let preHtml = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:w='urn:schemas-microsoft-com:office:word' xmlns='http://www.w3.org/TR/REC-html40'><head><meta charset='utf-8'>" +
      "<title>Export HTML To Docx</title></head><body>";
    let postHtml = "</body></html>";
    let html = preHtml+document.getElementById(element).innerHTML+postHtml;
    let html2 = preHtml+document.getElementById(element2).innerHTML+postHtml;

    let blob = new Blob(['\ufeff', html, html2 ], {
      type: 'application/msword'
    });

    // Specify link url
    let url = 'data:application/vnd.ms-word;charset=utf-8,' + encodeURIComponent(html) + encodeURIComponent(html2);

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

  deleteProfile(){
    this.userService.deleteUser(+this.user.idUser, this.user.idWallet).subscribe(() => {
      this.userService.setUser(null);
      localStorage.removeItem("user");
      this.router.navigate(['/groups']);
    });
  }
}
