
import {CompetencePK} from './competencePK';
import {Niveau} from './niveau';


export class Competence {


  constructor(private _niveau: Niveau, private _competencePK: CompetencePK) {

  }
  public get niveau(): Niveau {
    return this._niveau;
  }
  public set niveau(_niveau: Niveau) {
    this._niveau = _niveau;
  }
  public get competencePK(): CompetencePK {
    return this._competencePK;
  }
  public set competencePK(_competencePK: CompetencePK) {
    this._competencePK = _competencePK;
  }

}
