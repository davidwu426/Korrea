import { Component, OnInit, OnChanges} from '@angular/core';
import { MatSidenav} from '@angular/material/sidenav';
import { UserService } from 'src/services/user/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  open : boolean = false;
  toggle : string = ">"
  isAuthenticated
  constructor(private userService : UserService, private router : Router) { }

  ngOnInit() {
    this.isAuthenticated = this.userService.isAuthenticated();
    console.log(this.isAuthenticated);
    if(this.isAuthenticated){
      this.router.navigateByUrl('resources');
    }else{
      this.router.navigateByUrl('signin');
    }
  }

  toggleNavBar(sidenav : MatSidenav){
    sidenav.toggle();
    if(this.toggle ==='>'){
      this.toggle = "<";
    }else{
      this.toggle = ">";
    }
  }

}
