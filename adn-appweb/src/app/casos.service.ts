import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { curr_version, url_app } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CasosService {
  url_adn : String = '/adn';
  public current_user = "61353e03f4f12db25f1252da";

  constructor(public http: HttpClient) {

  }

  casos(){
    return this.http.get((url_app + curr_version + this.url_adn + '/casos'));
  }

  crear_cadena(data: any){
    return this.http.post((url_app + curr_version + this.url_adn + '/crear'),data);
  }



}
