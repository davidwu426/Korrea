import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';

import { SignupComponent } from '../component/signup/signup.component';
import { SigninComponent } from 'src/component/signin/signin.component';
import { ResourceComponent } from 'src/component/resource/resource.component';
import { NavbarComponent } from 'src/component/navbar/navbar.component';
import { LandingComponent } from 'src/component/landing/landing.component'
import { RouterGuardService } from 'src/services/router-guard/router-guard.service';

const appRoutes : Routes = [
    // {path : '', canActivate :[RouterGuardService], children : [
    // {path : 'resources', component : ResourceComponent}]},
    // {path : 'signup', component : SignupComponent},
    // {path : 'signin', component : SigninComponent},
    // {path : 'login', component: LandingComponent},


    // {path : "landing", canActivate : [RouterGuardService], children:[
    //     {path : 'navbar', component : NavbarComponent, children:[
    //         {path : 'resources', component : ResourceComponent}
    //     ]}
    // ]}
    {path: 'resources', component: ResourceComponent},
    {path: 'signin', component: SigninComponent},
    {path: 'nav', component: NavbarComponent},


];

@NgModule({
    declarations : [],
    imports : [ RouterModule.forRoot(appRoutes)],
    exports : [RouterModule],
})

export class RoutingModule{ }