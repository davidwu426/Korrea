import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResourceService {

  constructor(
    private http : HttpClient
  ) { }

  API_URL = 'localhost:8080/resources';
  
  getResources(){
    return this.http.get(this.API_URL)
  }

  sayHelloHome(){
    this.http.get('http://localhost:8080').toPromise().then(data=>{
      console.log(data);
    }).catch(error=>{
      console.log(error);
    });
  }
}
