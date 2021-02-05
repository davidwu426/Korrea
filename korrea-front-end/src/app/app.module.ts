import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

import { NavbarComponent } from 'src/component/navbar/navbar.component';
import { HeaderComponent } from 'src/component/header/header.component';
import { SignupComponent } from 'src/component/signup/signup.component';
import { SigninComponent } from 'src/component/signin/signin.component';
import { LandingComponent } from 'src/component/landing/landing.component';
import { ResourceComponent } from 'src/component/resource/resource.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { AngularMaterialModule } from '../angularMaterial/angularMaterialModule';

//routig
import { RoutingModule } from 'src/routing/routing.module';


import { ResourceService } from 'src/services/resource/resource.service';
import { UserService } from 'src/services/user/user.service';
import { TokenInterceptorService } from 'src/services/interceptors/token-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    SignupComponent,
    SigninComponent,
    ResourceComponent,
    LandingComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NoopAnimationsModule,
    AngularMaterialModule,
    RoutingModule,
    
  ],
  providers: [ResourceService, 
    UserService,
  {
    provide : HTTP_INTERCEPTORS,
    useClass : TokenInterceptorService,
    multi : true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
