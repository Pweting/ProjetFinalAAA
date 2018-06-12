import { Module } from './module';
import { Materiel } from './materiel';

export class Salle extends Materiel {

    constructor(code?: number, cout?: number, private _nbPersonne?: number, private _modules?: Array<Module>) {
        super(code, cout);
    }

    public get nbPersonne(): number {
        return this._nbPersonne;
    }
    public set nbPersonne(value: number) {
        this._nbPersonne = value;
    }
    public get modules(): Array<Module> {
        return this._modules;
    }
    public set modules(value: Array<Module>) {
        this._modules = value;
    }
}
