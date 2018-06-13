import { Router, ActivatedRoute } from '@angular/router';
import { MaterielService } from './../../services/materiel.service';
import { Materiel } from './../../model/materiel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-materiel',
  templateUrl: './edit-materiel.component.html',
  styleUrls: ['./edit-materiel.component.css']
})
export class EditMaterielComponent implements OnInit {

  materiel: Materiel | any = {};

  constructor(private materielService: MaterielService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const numero = params.id;
      if (!!numero) {
        this.materielService.findById(params.id).subscribe(result => {
          this.materiel = result;
          console.log(this.materiel);
        });
      }
    });
  }

  public save() {
    console.log(this.materiel);
    if (!!this.materiel) {
        this.materielService.save(this.materiel).subscribe(result => {
          this.home();
      });
    } else {
      this.materielService.update(this.materiel).subscribe(result => {
        this.home();
      });
    }
  }

  public home() {
    this.router.navigate(['/materiel']);
  }

  public reset() {
    this.home();
  }
}
