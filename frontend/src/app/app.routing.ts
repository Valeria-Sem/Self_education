import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from "./components/home/home.component";
import {NotFoundComponent} from "./components/notFound/notFound.component";
import {AboutComponent} from "./components/about/about.component";
import {GroupsComponent} from "./components/admin/groups/groups.component";
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
import {CourseMainPageComponent} from "./components/lectures&tests/course.main.page.component";

const appRoutes: Routes = [
  {path: '', component: HomeComponent}
  , {path: 'about', component: AboutComponent}
  , {path: 'groups', component: GroupsComponent}
  , {path: 'groups/studentPage/:id', component: StudentPageComponent}
  , {path: 'registration', component: RegistrationComponent}
  , {path: 'constructor', component: ConstructorComponent}
  , {path: 'c++', component: PlusComponent}
  , {path: 'c#', component: SharpComponent}
  , {path: 'java', component: JavaComponent}
  , {path: 'python', component: PythonComponent}
  , {path: 'javascript', component: JSComponent}
  , {path: 'php', component: PHPComponent}
  , {path: 'profile', component: StudentComponent}
  , {path: 'sub', component: SubPageComponent}
  , {path: 'course/:id', component: CourseMainPageComponent}
  // , {path: 'app', component: AppsComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  // , {path: 'games', component: GamesComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  // , {path: 'music', component: MusicComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  // , {path: 'sites', component: SitesComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
  // , {path: 'profile', component: UserComponent}
  // , {path: 'sub', component: SubComponent}
  // , {path: 'constructor', component: ConstructorComponent, canActivate: [RoleGuard], data: {role: Role.ORGANISATION}}
  , {path: '**', component: NotFoundComponent}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

