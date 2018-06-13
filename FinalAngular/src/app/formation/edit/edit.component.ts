import { Formation } from './../../model/formation';
import { FormationService } from './../../services/formation.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  formation: Formation | any = {};

  constructor(private formationService: FormationService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const numero = params.id;
      if (!!numero) {
        this.formationService.findById(params.id).subscribe(result => {
          this.formation = result;
          console.log(this.formation);
        });
      }
    });
  }

  public save() {
    console.log(this.formation);
    if (!!this.formation.id) {
      this.formationService.update(this.formation).subscribe(result => {
        this.home();
      });
    } else {
      this.formationService.save(this.formation).subscribe(result => {
        this.home();
      });
    }
  }

  public home() {
    this.router.navigate(['/formation']);
  }

  public return() {
    this.home();
  }
}
