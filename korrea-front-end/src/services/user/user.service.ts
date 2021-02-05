import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/interfaces/user';
import { SignIn} from 'src/interfaces/SignIn';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  API_URL = 'http://localhost:8080/';
  constructor(private http : HttpClient) { }

  register(username, email, password){
    const newUser : User = {
      username : username,
      email : email,
      password : password
    }
    return this.http.post(`${this.API_URL}register`,newUser);
  }

  signIn(username, password){
    const newSign : SignIn = {
      username : username,
      password : password
    }
    return this.http.post(`${this.API_URL}authenticate`,newSign);
  }

  sayHelloHome(){
    return this.http.get('http://localhost:8080')
  }

  isAuthenticated(){
    let jwt = localStorage.getItem('jwt');
    if(!jwt){
      return false;
    }else{
      return true;
    }
  }
}
