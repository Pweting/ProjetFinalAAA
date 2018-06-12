import {Competence} from './competence';
import {Module} from './module';
export class Matiere {

  private _id: number;
  private _module: Array<Module>;
  private _formateur: Array<Competence>;


  constructor(private _prerequis: string, private _titre: string,
    private _contenu: string, private _objectif: string, private _duree: number) {}

  public get prerequis(): string {
    return this._prerequis;
  }
  public set prerequis(_prerequis: string) {
    this._prerequis = _prerequis;
  }

  public get titre(): string {
    return this._titre;
  }
  public set titre(_titre: string) {
    this._titre = _titre;
  }
  public get contenu(): string {
    return this._contenu;
  }
  public set contenu(_contenu: string) {
    this._contenu = _contenu;
  }

  public get objectif(): string {
    return this._objectif;
  }
  public set objetif(_objectif: string) {
    this._objectif = _objectif;
  }

  public get id(): number {
    return this._id;
  }
  public set id(_id: number) {
    this._id = _id;
  }
  public get duree(): number {
    return this._duree;
  }
  public set duree(_duree: number) {
    this._duree = _duree;
  }
}
