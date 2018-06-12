import {Adresse} from './adresse';
import { RH } from './rh';
export class Gestionnaire extends RH {
  constructor(nom: string, prenom: string, adresse: Adresse, id?: number) {
    super(nom, prenom, adresse, id);
  }
}