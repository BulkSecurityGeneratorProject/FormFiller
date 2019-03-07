export interface IAddress {
    id?: number;
    country?: string;
    province?: string;
    city?: string;
}

export class Address implements IAddress {
    constructor(public id?: number, public country?: string, public province?: string, public city?: string) {}
}
