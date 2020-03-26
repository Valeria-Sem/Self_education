import {ChangeDetectorRef, Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {BsModalService} from "ngx-bootstrap";

@Component({
  selector: "app-nav-side",
  templateUrl: "./nav-side.component.html",
  styleUrls: ['./nav-side.component.css']
})

export class NavSideComponent implements OnInit{
  loaded: boolean;

  constructor(private modalService: BsModalService,
              private cdr: ChangeDetectorRef,
              private router: Router) {

  }

  ngOnInit(): void {
    this.loaded = true;
  }


}
