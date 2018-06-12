
import { Adresse } from './adresse';
export class RH {
  
  constructor( private _nom: string, private _prenom: string, private _adresse: Adresse, private _id?: number) {
  }
   public get id(): number {
    return this._id;
  }

  public set id(id: number) {
    this.id = id;
  }
  public get prenom(): string {
    return this._prenom;
  }

  public set prenom(_prenom: string) {
    this._prenom = _prenom;
  }

  public get nom(): string {
    return this._nom;
  }

  public set nom(_nom: string) {
    this._nom = _nom;
  }
   public get adresse(): Adresse {
    return this._adresse;
  }

  public set adresse(_adresse: Adresse) {
    this._adresse = _adresse;
  }
}
