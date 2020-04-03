import { BrowserModule } from "@angular/platform-browser";
import {APP_INITIALIZER, NgModule} from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from "ngx-bootstrap/modal";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AccordionModule } from 'ngx-bootstrap/accordion';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { NgAisModule } from 'angular-instantsearch';
import {initApp} from "./services/app.initializer";

import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {routing} from "./app.routing";
import {NavTopComponent} from "./components/nav-top/nav-top.component";
import {NavSideComponent} from "./components/nav-side/nav-side.component";
import {HomeComponent} from "./components/home/home.component";
import {CarouselComponent} from "./components/carousel/carousel.component";
import {NotFoundComponent} from "./notFound/notFound.component";
import {AboutComponent} from "./components/about/about.component";
import {RoleGuard} from "./services/role-guard.service";
import {UserService} from "./services/user.service";


// const appRoutes: Routes = [
//   {path: "", component: HomeComponent},
//   {path: "home", component: HomeComponent},
//   {path: "billing-details/:id", component: BillingDetailsViewComponent},
//   {path: "**", component: NotFoundComponent}
// ];

@NgModule({
  declarations: [
    AppComponent,
    NavTopComponent,
    NavSideComponent,
    HomeComponent,
    CarouselComponent,
    NotFoundComponent,
    AboutComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
//    LayoutModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    routing,
    BrowserAnimationsModule,
    AccordionModule.forRoot(),
    CarouselModule.forRoot(),
    NgAisModule.forRoot(),
    ReactiveFormsModule
  ],
  providers: [RoleGuard,
    UserService,
    {
      provide: APP_INITIALIZER,
      useFactory: initApp,
      deps: [UserService],
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
