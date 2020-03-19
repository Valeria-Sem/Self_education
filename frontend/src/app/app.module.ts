import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from "ngx-bootstrap/modal";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {RouterModule, Routes} from "@angular/router";
import {routing} from "./app.routing";
import {NavTopComponent} from "./components/nav-top/nav-top.component";
import {NavSideComponent} from "./components/nav-side/nav-side.component";
import {HomeComponent} from "./components/home/home.component";


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
    HomeComponent
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
    routing
 //   RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
