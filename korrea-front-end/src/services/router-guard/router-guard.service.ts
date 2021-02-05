import { Injectable } from '@angular/core';
import { UserService } from '../user/user.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterGuardService {

  constructor(private userService : UserService, private router : Router) { }

  canActivate(){
    if(!this.userService.isAuthenticated()){
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
