import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CasosService } from '../casos.service';

@Component({
  selector: 'app-casos',
  templateUrl: './casos.component.html',
  styleUrls: ['./casos.component.scss']
})
export class CasosComponent implements OnInit {

  adnForm = new FormGroup({
    part_one: new FormControl('ATGCGA', [Validators.required, Validators.pattern("[A|C|G|T]{6}")]),
    part_two: new FormControl('CAGTGC', [Validators.required, Validators.pattern("[A|C|G|T]{6}")]),
    part_three: new FormControl('TTATGT', [Validators.required, Validators.pattern("[A|C|G|T]{6}")]),
    part_four: new FormControl('AGAAGG', [Validators.required, Validators.pattern("[A|C|G|T]{6}")]),
    part_five: new FormControl('CCCCTA', [Validators.required, Validators.pattern("[A|C|G|T]{6}")]),
    part_six: new FormControl('TCACTG', [Validators.required, Validators.pattern("[A|C|G|T]{6}")]),
    // tipo: new FormControl('', Validators.required),
  });
  ccadena: any = { adn: [], cadenaAdn: [], malformaciones: [], tieneMalformacion: Boolean };
  datos: any;

  constructor(public _casos: CasosService) {

  }

  ngOnInit(): void {
    this._casos.casos().subscribe((data: any) => {
        if (data.data && data.data.length > 0) {
          console.log(data.data);
          this.datos =data.data;
        }
      }
      );

  }

  crearCaso() {
    this._casos.crear_cadena(this.adnForm.value)
      .subscribe((data: any) => {
        if (data.data && data.data.length > 0) {
          this.ccadena = data.data[data.data.length -1];
          this.datos =data.data;
        }
      }
      );
  }


  cargarObjetoActual(item: any){
  this.ccadena = item;
  let   element: HTMLElement;
  element = document.getElementById('12') as HTMLElement;
  }

  get  part_one() { return this.adnForm.get('part_one'); }
  get  part_two() { return this.adnForm.get('part_two'); }
  get  part_three() { return this.adnForm.get('part_three'); }
  get  part_four() { return this.adnForm.get('part_four'); }
  get  part_five() { return this.adnForm.get('part_five'); }
  get  part_six() { return this.adnForm.get('part_six'); }

}
