import {Matiere} from '../../model/matiere';
import {MatiereService} from '../../services/matiere.service';
import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-edit-matiere',
  templateUrl: './edit-matiere.component.html',
  styleUrls: ['./edit-matiere.component.css']
})
export class EditMatiereComponent implements OnInit {

  matiere: Matiere | any = {};

  constructor(private matiereService: MatiereService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      const numero = params.id;
      if (!!numero) {
        this.matiereService.findById(params.id).subscribe(result => {
          this.matiere = result;
          console.log(this.matiere);
        });
      }
    });
  }

  public save() {
    console.log(this.matiere);
    if (!!this.matiere.id) {
      this.matiereService.update(this.matiere).subscribe(result => {
        this.home();
      });
    } else {
      this.matiereService.save(this.matiere).subscribe(result => {
        this.home();
      });
    }
  }

  public home() {
    this.router.navigate(['/matiere']);
  }

  public return() {
    this.home();
  }
}
