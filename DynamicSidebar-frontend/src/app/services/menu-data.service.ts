import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MenuDataService {
  url = "http://localhost:8080/menu";
  constructor(private http : HttpClient) { }
  menus(){
    return this.http.get(this.url);
  }
}
