import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {NavigationEnd, Router} from "@angular/router";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {BsModalService} from "ngx-bootstrap";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{



  constructor(private modalService: BsModalService,
              private cdr: ChangeDetectorRef,
              private router: Router) {

  }

  // itemsPerSlide = 2;
  // singleSlideOffset = true;
  // noWrap = true;
  //
  // slides = [
  //   {image: 'assets/img/edu.svg.png'},
  //   {image: 'assets/img/edu_rus.svg.png'}
  // ];


  ngOnInit(): void {
    // this.loaded = true;
    // this.subjectService.getSubjects().subscribe((data) => {
    //   this.subject = data as Subject[];
    //   this.cdr.detectChanges();
    // });
  }

  // onHidden(): void {
  //   console.log('Dropdown is hidden');
  // }
  //
  // onShown(): void {
  //   console.log('Dropdown is shown');
  //
  // }
  //
  // isOpenChange(): void {
  //   console.log('Dropdown state is changed');
  // }
  //
  // public onCategoriesClickHandler(event: any){
  //   let files = event.target;
  // }

    // this.router.events.subscribe(evt => {
    //   if(!(evt instanceof NavigationEnd)){
    //     return;
    //   }
    //   window.scrollTo(0,0)
    // })

}
