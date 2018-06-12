import { Module } from './module';
import { Materiel } from './materiel';

export class VideoProjecteur extends Materiel {

    constructor(code?: number, cout?: number, private _module?: Module) {
        super(code, cout);
    }

    public get module(): Module {
        return this._module;
    }
    public set Module(value: Module) {
        this._module = value;
    }
}
