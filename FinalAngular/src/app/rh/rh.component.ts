import {RH} from '../model/rh';
import {RhService} from '../services/rh.service';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-rh',
  templateUrl: './rh.component.html',
  styleUrls: ['./rh.component.css']
})
export class RhComponent implements OnInit {

  listeRh: Array<RH>;

  constructor(private rhService: RhService) {}

  ngOnInit() {
    this.list();
  }
  private list() {
this.rhService.list().subscribe(result => {
      this.listeRh = result;
      console.log(result);
    }, error => {
      console.log(error);
    });
  }
}
