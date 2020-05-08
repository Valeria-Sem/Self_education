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
import {NotFoundComponent} from "./components/notFound/notFound.component";
import {AboutComponent} from "./components/about/about.component";
import {RoleGuard} from "./services/role-guard.service";
import {UserService} from "./services/user.service";
import {GroupsComponent} from "./components/admin/groups/groups.component";
import {AdminCoursesComponent} from "./components/admin/admin-cours/admin-courses.component";
import {AlertModule, TabsModule} from "ngx-bootstrap";
import {StudentPageComponent} from "./components/admin/studentPage/studentPage.component";
import {RegistrationComponent} from "./components/admin/studReg/registration.component";
import {ConstructorComponent} from "./components/admin/groups/constructor/constructor.component";
import {PlusComponent} from "./components/courses/C++/c.component";
import {SharpComponent} from "./components/courses/C#/sharp.component";
import {JavaComponent} from "./components/courses/Java/java.component";
import {PythonComponent} from "./components/courses/Python/python.component";
import {JSComponent} from "./components/courses/JS/js.component";
import {PHPComponent} from "./components/courses/PHP/php.component";
import {StudentComponent} from "./components/student/student.component";
import {SubPageComponent} from "./components/student/subs/sub.page.component";
import {LecturesComponent} from "./components/lectures&tests/lectures/lectures.component";
import {SafePipe} from "./components/lectures&tests/lectures/SafePipe";
import {TestComponent} from "./components/lectures&tests/tests/test.component";
import {MapToIterable} from "./components/lectures&tests/tests/MapToIterable";

@NgModule({
  declarations: [
    AppComponent,
    NavTopComponent,
    NavSideComponent,
    HomeComponent,
    CarouselComponent,
    NotFoundComponent,
    AboutComponent,
    GroupsComponent,
    AdminCoursesComponent,
    StudentPageComponent,
    RegistrationComponent,
    ConstructorComponent,
    PlusComponent,
    SharpComponent,
    JavaComponent,
    PythonComponent,
    JSComponent,
    PHPComponent,
    StudentComponent,
    SubPageComponent,
    TestComponent,
    LecturesComponent,
    SafePipe,
    MapToIterable,
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
    ReactiveFormsModule,
    AlertModule.forRoot(),
    TabsModule.forRoot()
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
