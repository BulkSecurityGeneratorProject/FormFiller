import { IBranch } from 'app/shared/model/branch.model';

export interface IBank {
    id?: number;
    bankName?: string;
    branches?: IBranch[];
}

export class Bank implements IBank {
    constructor(public id?: number, public bankName?: string, public branches?: IBranch[]) {}
}
