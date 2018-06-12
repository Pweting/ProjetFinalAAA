
import {Adresse} from './adresse';
export class RH {
  private _telephone: string;
  private _email: string;
  private _login: string;
  private _mdp: string;
  private _enable: boolean;

  constructor(private _nom: string, private _prenom: string, private _adresse: Adresse, private _id?: number) {
  }
  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this.id = value;
  }
  public get prenom(): string {
    return this._prenom;
  }

  public set prenom(value: string) {
    this._prenom = value;
  }

  public get nom(): string {
    return this._nom;
  }

  public set nom(value: string) {
    this._nom = value;
  }
  public get adresse(): Adresse {
    return this._adresse;
  }

  public set adresse(value: Adresse) {
    this._adresse = value;
  }
    public get telephone(): string {
    return this._telephone;
  }

  public set telephone(value: string) {
    this._telephone = value;
  }
    public get email(): string {
    return this._email;
  }

  public set email(value: string) {
    this._email = value;
  }
    public get login(): string {
    return this._login;
  }

  public set login(value: string) {
    this._login = value;
  }
    public get mdp(): string {
    return this._mdp;
  }

  public set mdp(value: string) {
    this._mdp = value;
  }
      public get enable(): boolean {
    return this._enable;
  }

  public set enable(value: boolean) {
    this._enable = value;
  }
}
