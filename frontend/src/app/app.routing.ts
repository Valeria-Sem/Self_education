import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from "./components/home/home.component";
import {NotFoundComponent} from "./notFound/notFound.component";
import {AboutComponent} from "./components/about/about.component";
import {GroupsComponent} from "./components/admin/groups/groups.component";
import {StudentPageComponent} from "./components/admin/studentPage/studentPage.component";
import {RegistrationComponent} from "./components/admin/studReg/registration.component";

const appRoutes: Routes = [
  {path: '', component: HomeComponent}
  , {path: 'about', component: AboutComponent}
  , {path: 'groups', component: GroupsComponent}
  , {path: 'groups/studentPage/:id', component: StudentPageComponent}
  , {path: 'registration', component: RegistrationComponent}
  // , {path: 'orgReg', component: OrganisationRegComponent}
  // , {path: 'films', component: FilmsComponent, canActivate: [RoleGuard], data: {role: Role.CUSTOMER}}
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

