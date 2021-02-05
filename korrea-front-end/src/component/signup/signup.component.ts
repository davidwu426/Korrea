import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { timeStamp } from 'console';
import { UserService } from 'src/services/user/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(private userService : UserService) { }
  signupForm : FormGroup;
  ngOnInit() {
    this.signupForm = new FormGroup({
      email : new FormControl('',[
        Validators.required,
        Validators.email
      ]),
      username : new FormControl('',[
        Validators.required,
        Validators.minLength(6)
      ]),
      password : new FormControl('',[
        Validators.required
      ]),
      passwordVerifier : new FormControl('',[
        Validators.required,
      ])
    })
  }

  onSubmit(){
    this.userService.register(
      this.signupForm.value.username,
      this.signupForm.value.email,
      this.signupForm.value.password
    ).subscribe(data=>{
      console.log(data);
    })
    // this.userService.sayHelloHome().subscribe(data=>{
    //   console.log(data);
    // })
  }

  getUsername(){
    return this.signupForm.get('username');
  }
  getEmail(){
    return this.signupForm.get('email');
  }
  getPassword(){
    return this.signupForm.get('password');
  }


}
