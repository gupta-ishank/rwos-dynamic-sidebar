import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MenuDataService } from './service/menu-data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';
  menuData : any = [];
  dropdownData: any = [];
  uiToogler = {
    menuSelected: "",
    button: "Create"
  }
  constructor(private menuDataService : MenuDataService){
    this.refreshMenuData();
  }

  opened = false;

  toggleSidebar(){
    this.opened = !this.opened;
  }

  allMenuData={
    name:"",
    description:"",
    route:"",
    pid:"",
    permission:"",
    parent_Id:""
   } 

  SubmitData(){
    if(this.uiToogler.button === "Create"){
      const promise = this.menuDataService.postMenu(this.allMenuData).subscribe((data)=>{
        console.log(data);
        this.refreshMenuData();
      });
      // promise.then((data)=>{
      //   console.log(data);
      //   this.refreshMenuData();
      // });
    }else{
      const promise = this.menuDataService.updateMenu(this.allMenuData).subscribe((data)=>{
        console.log(data);
        this.refreshMenuData();
      });
      // promise.then((data)=>{
      //   console.log(data);
      //   this.refreshMenuData();
      // });
    }
    // console.log("submitted", this.allMenuData);
  }

  // showData(qdata:any){
  //   // this.data.nameValue = new FormControl(data.name) ;
  //   // document.getElementById('name')?.setAttribute('value', data.name);
  //   // this.data.nameValue = "rahul";
  //   this.data.name = qdata.name;
  //   // window.location.reload();
  //   console.log(this.data);
  // }

  updateData(data: any){
    this.uiToogler.button = "Update"
    this.allMenuData = data;
  }

  refreshMenuData(){
    this.menuDataService.getMenu().subscribe(data=>{
      // console.log(data);
      this.menuData = data;
      this.dropdownData = data;
    })
  }

  HandleDelete(){
    this.menuDataService.deleteMenu(this.allMenuData).subscribe((data)=>{
      this.refreshMenuData();
    });
  }

}
