import { Moment } from 'moment';
import { IAddress } from 'app/shared/model/address.model';
import { ISibaAccountForm } from 'app/shared/model/siba-account-form.model';

export interface ICustomer {
    id?: number;
    lastName?: string;
    nationalId?: string;
    identificationNumber?: string;
    fatherName?: string;
    plainAddress?: string;
    birth?: Moment;
    birthPlace?: string;
    address?: IAddress;
    sibaAccountForms?: ISibaAccountForm[];
}

export class Customer implements ICustomer {
    constructor(
        public id?: number,
        public lastName?: string,
        public nationalId?: string,
        public identificationNumber?: string,
        public fatherName?: string,
        public plainAddress?: string,
        public birth?: Moment,
        public birthPlace?: string,
        public address?: IAddress,
        public sibaAccountForms?: ISibaAccountForm[]
    ) {}
}
