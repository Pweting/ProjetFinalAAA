import { Module } from './module';
import { Materiel } from './materiel';

export class Salle extends Materiel {

    constructor(code?: number, cout?: number, private _nbPersonnes?: number, private _modules?: Array<Module>) {
        super(code, cout);
    }

    public get nbPersonnes(): number {
        return this._nbPersonnes;
    }
    public set nbPersonnes(value: number) {
        this._nbPersonnes = value;
    }
    public get modules(): Array<Module> {
        return this._modules;
    }
    public set modules(value: Array<Module>) {
        this._modules = value;
    }
}
