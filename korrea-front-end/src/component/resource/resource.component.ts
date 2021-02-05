import { Component, OnInit } from '@angular/core';
import { Resource } from 'src/interfaces/resources';
import { ResourceService } from 'src/services/resource/resource.service';

@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.scss']
})

export class ResourceComponent implements OnInit {

  resourceData  = [
    {resourceCode : 1100, resourceName : "Wood"},
    {resourceCode : 1200, resourceName : "Steel"},
    {resourceCode : 1300, resourceName : "Fire"},
    {resourceCode : 1400, resourceName : "Electric"},
    {resourceCode : 1500, resourceName : "Sand"},
    {resourceCode : 1600, resourceName : "Paper"},

  ]
  displayedColumns : string[] = ["resourceName", "resourceCode",]
  dataSource = this.resourceData;
  constructor(
    private resourceService : ResourceService
  ) { }

  ngOnInit() {
    // this.resourceService.getResources().subscribe(data=>{
    //   console.log(data);
    // })
    this.resourceService.sayHelloHome();
  }

  search(event){
    this.dataSource = this.resourceData.filter(data=> data.resourceName.indexOf(event.target.value) !== -1);
  }

}
