import {Formateur} from './formateur';
import {Matiere} from './matiere';
export class CompetencePK {
  constructor(private _formateur: Formateur, private _matiere: Matiere) {

  }
  public get matiere(): Matiere {
    return this._matiere;
  }
  public set matiere(_matiere: Matiere) {
    this._matiere = _matiere;
  }


  public get formateur(): Formateur {
    return this._formateur;
  }
  public set formateur(_formateur: Formateur) {
    this._formateur = _formateur;
  }
}
