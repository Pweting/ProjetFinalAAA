import { FormationService } from './../services/formation.service';
import { Formation } from './../model/formation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css']
})
export class FormationComponent implements OnInit {

  listeFormation: Array<Formation>;
  f: Formation;

  constructor(private formationService: FormationService) { }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.formationService.list().subscribe(result => {
      this.listeFormation = result;
      console.log(result);
    }, error => {
      console.log(error);
    });
  }

  public delete(value: number) {
    this.formationService.delete(value).subscribe(result => {
      this.list();
    }, error => {
      console.log(error);
    });
  }
}
