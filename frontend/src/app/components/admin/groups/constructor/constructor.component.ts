import {ChangeDetectorRef, Component, OnInit, TemplateRef} from "@angular/core";
import {Group} from "../../../../modules/group";
import {GroupService} from "../../../../services/group.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";


@Component({
  selector: "app-constructor",
  templateUrl: "./constructor.component.html",
  styleUrls: ['./constructor.component.css']
})
export class ConstructorComponent implements OnInit{
  bsModalRef: BsModalRef;
  information: Group;
  public idGroup: string;
  public groupName: string;

  constructor(private cdr: ChangeDetectorRef,
              private groupService: GroupService,
              private modalService: BsModalService) {
  }

  ngOnInit(){
  }

  public saveGroup(information): void {
    this.information = new Group(this.groupName);
    this.groupService.saveGroup(this.information).subscribe();
  }

  openModal(template: TemplateRef<any>) {
    this.bsModalRef = this.modalService.show(template, Object.assign({}, {class: 'gray modal-sm'}));
  }
}
