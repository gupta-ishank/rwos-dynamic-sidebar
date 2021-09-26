import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MenuDataService {
  base_url="http://localhost:8085/menu";
  constructor(private http : HttpClient) { }

  getMenu(){
    return this.http.get(this.base_url);
  }

  postMenu(dataToPost: any){
    const data = {
      name: dataToPost.name,
      description: dataToPost.description,
      route: dataToPost.route,
      pid: dataToPost.pid,
      permission: dataToPost.permission
    }
    const header = {
      'content-type': 'application/json'
    }
    const body = JSON.stringify(data);
    // console.log(data);
    let api_url=this.base_url;
    if(dataToPost.parent_Id != "" || dataToPost.parent_Id != undefined){
      api_url = this.base_url + "/" + dataToPost.parent_Id; 
    }
    return this.http.post(api_url, body, {'headers':header});
    console.log("posted")
  }

  updateMenu(dataToUpdate:any){
    const data = {
      name: dataToUpdate.name,
      description: dataToUpdate.description,
      route: dataToUpdate.route,
      pid: dataToUpdate.pid,
      permission: dataToUpdate.permission
    }
    const api_url = this.base_url + "/" + dataToUpdate.mid; 
    const header = {
      'content-type': 'application/json'
    }
    const body = JSON.stringify(data);
    return this.http.put(api_url, body, {'headers':header})
  }

  deleteMenu(dataToDelete : any){
    const api_url = this.base_url + "/" + dataToDelete.mid;
    return this.http.delete(api_url);
  }
}
