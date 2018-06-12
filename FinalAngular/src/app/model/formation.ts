import { Module } from './module';
import { Stagiaire } from './stagiaire';
export class Formation {

    constructor(private _id?: number, private _dateDebut?: Date, private _dateFin?: Date,
        private _modules?: Array<Module>, private _stagiaires?: Array<Stagiaire>) {

    }

    public get id(): number {
        return this._id;
    }

    public set id(value: number) {
        this._id = value;
    }

    public get dateDebut(): Date {
        return this._dateDebut;
    }

    public set dateDebut(value: Date) {
        this._dateDebut = value;
    }
}
