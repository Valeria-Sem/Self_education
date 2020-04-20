import {Component, OnInit} from "@angular/core";

@Component({
  selector: "app-course.main.page",
  templateUrl: "./course.main.page.component.html",
  styleUrls: ['./course.main.page.component.css']
})
export class CourseMainPageComponent implements OnInit{
  isSharp: boolean = false;
  isPlus: boolean = false;
  isJava: boolean = false;
  isPython: boolean = false;
  isJS: boolean = false;
  isPHP: boolean = false;

  ngOnInit(): void {
    this.isSharp = true;
  }
}
