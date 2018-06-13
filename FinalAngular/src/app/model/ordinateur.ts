import { Materiel } from './materiel';

export class Ordinateur extends Materiel {

    constructor(code: number, cout?: number, private _processeur?: string, private _hdd?: number,
         private _ram?: number, private _anneeAchat?: Date) {
        super(code, cout);
    }
    public get processeur(): string {
        return this._processeur;
    }
    public set processeur(value: string) {
        this._processeur = value;
    }
    public get hdd(): number {
        return this._hdd;
    }
    public set hdd(value: number) {
        this._hdd = value;
    }
    public get ram(): number {
        return this._ram;
    }
    public set ram(value: number) {
        this._ram = value;
    }
    public get anneeAchat(): Date {
        return this._anneeAchat;
    }
    public set anneeAchat(value: Date) {
        this._anneeAchat = value;
    }
}
