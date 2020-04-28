import {ChangeDetectorRef, Component, OnInit, TemplateRef} from "@angular/core";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {SubService} from "../../../services/subscription.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Lectures} from "../../../modules/lectures";
import {LecturesService} from "../../../services/lectures.service";

@Component({
  selector: "app-lectures",
  templateUrl: "./lectures.component.html",
  styleUrls: ['./lectures.component.css']
})

export class LecturesComponent implements OnInit{
  id: string;
  lectures: Lectures[];
  modalRef: BsModalRef;

  constructor(private lecturesService: LecturesService,
              private subService: SubService,
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

    this.lecturesService.getLecturesByIdProduct(this.id.substr(1, 2)).subscribe((data) => {
      this.lectures = data as Lectures[];
      this.cdr.detectChanges();
    });
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-lg'}));
  }

}



