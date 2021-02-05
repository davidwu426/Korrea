import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/services/user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
  signInForm : FormGroup

  constructor(private userService : UserService, private router : Router) { }

  ngOnInit() {
    this.signInForm = new FormGroup({
      username : new FormControl('',[
        Validators.required
      ]),
      password : new FormControl('',[ 
        Validators.required
      ])
    })
  }

  signIn(){
    this.userService.signIn(this.signInForm.value.username, this.signInForm.value.password).subscribe(
      res => {
        localStorage.setItem('jwt',res['token']);
        console.log(localStorage.getItem('jwt'));
        this.router.navigateByUrl('nav');
      },
      err => {console.log(`${err}error`) },
      () => {}
    )
  }

  getUsername(){
    return this.signInForm.get('username');
  }

  getPassword(){
    return this.signInForm.get('password');
  }
}
