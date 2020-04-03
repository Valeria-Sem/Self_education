import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from "./components/home/home.component";
import {NotFoundComponent} from "./notFound/notFound.component";
import {AboutComponent} from "./components/about/about.component";

const appRoutes: Routes = [
  {path: '', component: HomeComponent}
  , {path: 'about', component: AboutComponent}
  // , {path: 'userReg', component: UserRegComponent}
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

