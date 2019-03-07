import { IBank } from 'app/shared/model/bank.model';
import { IAddress } from 'app/shared/model/address.model';

export interface IBranch {
    id?: number;
    branchName?: string;
    branchPlainAddress?: string;
    branchNumber?: string;
    bank?: IBank;
    address?: IAddress;
}

export class Branch implements IBranch {
    constructor(
        public id?: number,
        public branchName?: string,
        public branchPlainAddress?: string,
        public branchNumber?: string,
        public bank?: IBank,
        public address?: IAddress
    ) {}
}
