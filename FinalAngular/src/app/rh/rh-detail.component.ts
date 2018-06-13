import { RH } from '../model/rh';
import { RhService } from '../services/rh.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-rh-detail',
  templateUrl: './rh-detail.component.html',
  styleUrls: ['./rh-detail.component.css']
})
export class RhDetailComponent implements OnInit {

  rh: RH | any = {'adresse':{'cp':'','num':'','rue': '', 'ville':'', 'pays': ''}};

  constructor(private rhService: RhService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const numero = params.id;
      if (!!numero) {
        this.rhService.findById(params.id).subscribe(result => {
          this.rh = result;
          console.log(this.rh);
        });
      }
    });
  }

  public saveFormateur() {
    console.log(this.rh);
    this.rh.type="formateur";
    if (!!this.rh.id) {
        this.rhService.saveFormateur(this.rh).subscribe(result => {
          this.home();
      });
    } else {
      this.rhService.createFormateur(this.rh).subscribe(result => {
        this.home();
      });
    }
  }

  public home() {
    this.router.navigate(['/rh']);
  }

  public reset() {
    this.home();
  }
}