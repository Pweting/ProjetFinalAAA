export class Adresse {
  constructor(private _num: number, private _cp: number, private _rue: string,
    private _ville?: string, private _pays?: string) {

  }

  public get rue(): string {
    return this._rue;
  }
  public set rue(_rue: string) {
    this._rue = _rue;
  }

  public get ville(): string {
    return this._ville;
  }
  public set ville(_ville: string) {
    this._ville = _ville;
  }
  public get pays(): string {
    return this._pays;
  }
  public set pays(_pays: string) {
    this._pays = _pays;
  }

  public get num(): number {
    return this._num;
  }
  public set num(_num: number) {
    this._num = _num;
  }
  public get cp(): number {
    return this._cp;
  }
  public set cp(_cp: number) {
    this._cp = _cp;
  }
}
