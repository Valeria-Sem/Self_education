import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {Subject} from "../../modules/subject";
import {Router} from "@angular/router";
import {BsModalService} from "ngx-bootstrap";
import {SubjectService} from "../../services/subject.service";

@Component({
  selector: "app-nav-side",
  templateUrl: "./nav-side.component.html",
  styleUrls: ['./nav-side.component.css']
})

export class NavSideComponent implements OnInit{
  loaded: boolean;
  subject: Subject[];

  constructor(private modalService: BsModalService,
              private subjectService: SubjectService,
              private cdr: ChangeDetectorRef,
              private router: Router) {

  }

  ngOnInit(): void {
    this.loaded = true;
    this.subjectService.getSubjects().subscribe((data) => {
      this.subject = data as Subject[];
      this.cdr.detectChanges();
    });
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

  public onCategoriesClickHandler(event: any){
    let files = event.target;
  }
}
