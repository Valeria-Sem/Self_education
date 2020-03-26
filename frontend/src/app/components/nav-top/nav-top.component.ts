import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {BsModalService} from "ngx-bootstrap";
import {Router} from "@angular/router";
import {Course} from "../../modules/course";
import {CourseService} from "../../services/subject.service";

@Component({
  selector: "app-nav-top",
  templateUrl: "./nav-top.component.html",
  styleUrls: ['./nav-top.component.css']
})
export class NavTopComponent implements OnInit{
  loaded: boolean;
  course: Course[];

  constructor(private modalService: BsModalService,
              private courseService: CourseService,
              private cdr: ChangeDetectorRef,
              private router: Router) {

  }

  ngOnInit(): void {
    this.loaded = true;
    this.courseService.getSubjects().subscribe((data) => {
      this.course = data as Course[];
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

  public onCoursesClickHandler(event: any){
    let files = event.target;
  }
}
