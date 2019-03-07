import { Moment } from 'moment';
import { ICustomer } from 'app/shared/model/customer.model';

export interface ISibaAccountForm {
    id?: number;
    registerDate?: Moment;
    registrationNumber?: string;
    registrationPlace?: string;
    registrationCapital?: string;
    activityType?: string;
    longTime?: string;
    boardManagementLong?: string;
    phoneNumber1?: string;
    phoneNumber2?: string;
    faxNumber?: string;
    zipCode?: string;
    emailAddress?: string;
    plainAddress?: string;
    accountRegistrationPurpose?: string;
    fullName1?: string;
    fullName2?: string;
    fullName3?: string;
    fullName4?: string;
    fullName5?: string;
    fullName6?: string;
    customerNumber1?: string;
    customerNumber2?: string;
    customerNumber3?: string;
    customerNumber4?: string;
    customerNumber5?: string;
    customerNumber6?: string;
    sendingBillCycle?: string;
    howToSendBill?: string;
    otherServices?: string;
    accountType?: string;
    letterNumber?: string;
    letterDate?: string;
    letterOrganization?: string;
    customer?: ICustomer;
}

export class SibaAccountForm implements ISibaAccountForm {
    constructor(
        public id?: number,
        public registerDate?: Moment,
        public registrationNumber?: string,
        public registrationPlace?: string,
        public registrationCapital?: string,
        public activityType?: string,
        public longTime?: string,
        public boardManagementLong?: string,
        public phoneNumber1?: string,
        public phoneNumber2?: string,
        public faxNumber?: string,
        public zipCode?: string,
        public emailAddress?: string,
        public plainAddress?: string,
        public accountRegistrationPurpose?: string,
        public fullName1?: string,
        public fullName2?: string,
        public fullName3?: string,
        public fullName4?: string,
        public fullName5?: string,
        public fullName6?: string,
        public customerNumber1?: string,
        public customerNumber2?: string,
        public customerNumber3?: string,
        public customerNumber4?: string,
        public customerNumber5?: string,
        public customerNumber6?: string,
        public sendingBillCycle?: string,
        public howToSendBill?: string,
        public otherServices?: string,
        public accountType?: string,
        public letterNumber?: string,
        public letterDate?: string,
        public letterOrganization?: string,
        public customer?: ICustomer
    ) {}
}
