import { MaterielService } from './../services/materiel.service';
import { Component, OnInit } from '@angular/core';
import { Materiel } from '../model/materiel';

@Component({
  selector: 'app-materiel',
  templateUrl: './materiel.component.html',
  styleUrls: ['./materiel.component.css']
})
export class MaterielComponent implements OnInit {

  listeMateriel: Array<Materiel>;

  constructor(private materielService: MaterielService) { }

  ngOnInit() {
    this.list();
  }

  private list() {
    this.materielService.list().subscribe(result => {
      this.listeMateriel = result;
      console.log(result);
    }, error => {
      console.log(error);
    });
  }

  public delete(value: number) {
    this.materielService.delete(value).subscribe(result => {
      this.list();
    }, error => {
      console.log(error);
    });
  }
}
