import { Component } from '@angular/core';
import {MenuDataService} from './services/menu-data.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';
  menus : any;
  constructor(private menuData : MenuDataService){
    this.menuData.menus().subscribe((data)=>{
      console.warn("data", data);
      this.menus = data;
    })
  }

  opened = false;

  toggleSidebar(){
    this.opened = !this.opened;
  }
}
