export class Materiel {

    constructor(private _code?: number, private _cout?: number, private _type?: string) {

    }

    public get code(): number {
        return this._code;
    }
    public set code(value: number) {
        this._code = value;
    }
    public get cout(): number {
        return this._cout;
    }
    public set cout(value: number) {
        this._cout = value;
    }
    public get type(): string {
        return this._type;
    }
    public set type(value: string) {
        this._type = value;
    }
}
