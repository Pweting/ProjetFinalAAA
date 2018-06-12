import {Adresse} from './adresse';
import {Formation} from './formation';
import {Ordinateur} from './ordinateur';
import {RH} from './rh';
export class Stagiaire extends RH {

  private _formation: Formation;

  constructor(nom: string, prenom: string, adresse: Adresse, private _ordinateur: Ordinateur, id?: number) {
    super(nom, prenom, adresse, id);
  }
  public set ordinateur(value: Ordinateur) {
    this._ordinateur = value;
  }

  public get ordinateur(): Ordinateur {
    return this._ordinateur;
  }
    public set formation(value: Formation) {
    this._formation = value;
  }

  public get formation(): Formation {
    return this._formation;
  }
}