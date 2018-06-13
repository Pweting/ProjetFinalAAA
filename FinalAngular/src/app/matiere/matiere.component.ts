import { Matiere } from '../model/matiere';
import { MatiereService } from '../services/matiere.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css']
})
export class MatiereComponent implements OnInit {

   listeMatiere: Array<Matiere>;
  m: Matiere;
  constructor(private matiereService: MatiereService) { }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.matiereService.list().subscribe(result => {
      this.listeMatiere = result;
      console.log(result);
    }, error => {
      console.log(error);
    });
  }

  public delete(value: number) {
    this.matiereService.delete(value).subscribe(result => {
      this.list();
    }, error => {
      console.log(error);
    });
  }
}
