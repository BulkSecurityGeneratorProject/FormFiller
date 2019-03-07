package ir.rabbitgrout.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A SibaAccountForm.
 */
@Entity
@Table(name = "siba_account_form")
public class SibaAccountForm implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "register_date")
    private LocalDate registerDate;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "registration_place")
    private String registrationPlace;

    @Column(name = "registration_capital")
    private String registrationCapital;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "long_time")
    private String longTime;

    @Column(name = "board_management_long")
    private String boardManagementLong;

    @Column(name = "phone_number_1")
    private String phoneNumber1;

    @Column(name = "phone_number_2")
    private String phoneNumber2;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "plain_address")
    private String plainAddress;

    @Column(name = "account_registration_purpose")
    private String accountRegistrationPurpose;

    @Column(name = "full_name_1")
    private String fullName1;

    @Column(name = "full_name_2")
    private String fullName2;

    @Column(name = "full_name_3")
    private String fullName3;

    @Column(name = "full_name_4")
    private String fullName4;

    @Column(name = "full_name_5")
    private String fullName5;

    @Column(name = "full_name_6")
    private String fullName6;

    @Column(name = "customer_number_1")
    private String customerNumber1;

    @Column(name = "customer_number_2")
    private String customerNumber2;

    @Column(name = "customer_number_3")
    private String customerNumber3;

    @Column(name = "customer_number_4")
    private String customerNumber4;

    @Column(name = "customer_number_5")
    private String customerNumber5;

    @Column(name = "customer_number_6")
    private String customerNumber6;

    @Column(name = "sending_bill_cycle")
    private String sendingBillCycle;

    @Column(name = "how_to_send_bill")
    private String howToSendBill;

    @Column(name = "other_services")
    private String otherServices;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "letter_number")
    private String letterNumber;

    @Column(name = "letter_date")
    private String letterDate;

    @Column(name = "letter_organization")
    private String letterOrganization;

    @ManyToOne
    @JsonIgnoreProperties("sibaAccountForms")
    private Customer customer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public SibaAccountForm registerDate(LocalDate registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public SibaAccountForm registrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationPlace() {
        return registrationPlace;
    }

    public SibaAccountForm registrationPlace(String registrationPlace) {
        this.registrationPlace = registrationPlace;
        return this;
    }

    public void setRegistrationPlace(String registrationPlace) {
        this.registrationPlace = registrationPlace;
    }

    public String getRegistrationCapital() {
        return registrationCapital;
    }

    public SibaAccountForm registrationCapital(String registrationCapital) {
        this.registrationCapital = registrationCapital;
        return this;
    }

    public void setRegistrationCapital(String registrationCapital) {
        this.registrationCapital = registrationCapital;
    }

    public String getActivityType() {
        return activityType;
    }

    public SibaAccountForm activityType(String activityType) {
        this.activityType = activityType;
        return this;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getLongTime() {
        return longTime;
    }

    public SibaAccountForm longTime(String longTime) {
        this.longTime = longTime;
        return this;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }

    public String getBoardManagementLong() {
        return boardManagementLong;
    }

    public SibaAccountForm boardManagementLong(String boardManagementLong) {
        this.boardManagementLong = boardManagementLong;
        return this;
    }

    public void setBoardManagementLong(String boardManagementLong) {
        this.boardManagementLong = boardManagementLong;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public SibaAccountForm phoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
        return this;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public SibaAccountForm phoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
        return this;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public SibaAccountForm faxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
        return this;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public SibaAccountForm zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public SibaAccountForm emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPlainAddress() {
        return plainAddress;
    }

    public SibaAccountForm plainAddress(String plainAddress) {
        this.plainAddress = plainAddress;
        return this;
    }

    public void setPlainAddress(String plainAddress) {
        this.plainAddress = plainAddress;
    }

    public String getAccountRegistrationPurpose() {
        return accountRegistrationPurpose;
    }

    public SibaAccountForm accountRegistrationPurpose(String accountRegistrationPurpose) {
        this.accountRegistrationPurpose = accountRegistrationPurpose;
        return this;
    }

    public void setAccountRegistrationPurpose(String accountRegistrationPurpose) {
        this.accountRegistrationPurpose = accountRegistrationPurpose;
    }

    public String getFullName1() {
        return fullName1;
    }

    public SibaAccountForm fullName1(String fullName1) {
        this.fullName1 = fullName1;
        return this;
    }

    public void setFullName1(String fullName1) {
        this.fullName1 = fullName1;
    }

    public String getFullName2() {
        return fullName2;
    }

    public SibaAccountForm fullName2(String fullName2) {
        this.fullName2 = fullName2;
        return this;
    }

    public void setFullName2(String fullName2) {
        this.fullName2 = fullName2;
    }

    public String getFullName3() {
        return fullName3;
    }

    public SibaAccountForm fullName3(String fullName3) {
        this.fullName3 = fullName3;
        return this;
    }

    public void setFullName3(String fullName3) {
        this.fullName3 = fullName3;
    }

    public String getFullName4() {
        return fullName4;
    }

    public SibaAccountForm fullName4(String fullName4) {
        this.fullName4 = fullName4;
        return this;
    }

    public void setFullName4(String fullName4) {
        this.fullName4 = fullName4;
    }

    public String getFullName5() {
        return fullName5;
    }

    public SibaAccountForm fullName5(String fullName5) {
        this.fullName5 = fullName5;
        return this;
    }

    public void setFullName5(String fullName5) {
        this.fullName5 = fullName5;
    }

    public String getFullName6() {
        return fullName6;
    }

    public SibaAccountForm fullName6(String fullName6) {
        this.fullName6 = fullName6;
        return this;
    }

    public void setFullName6(String fullName6) {
        this.fullName6 = fullName6;
    }

    public String getCustomerNumber1() {
        return customerNumber1;
    }

    public SibaAccountForm customerNumber1(String customerNumber1) {
        this.customerNumber1 = customerNumber1;
        return this;
    }

    public void setCustomerNumber1(String customerNumber1) {
        this.customerNumber1 = customerNumber1;
    }

    public String getCustomerNumber2() {
        return customerNumber2;
    }

    public SibaAccountForm customerNumber2(String customerNumber2) {
        this.customerNumber2 = customerNumber2;
        return this;
    }

    public void setCustomerNumber2(String customerNumber2) {
        this.customerNumber2 = customerNumber2;
    }

    public String getCustomerNumber3() {
        return customerNumber3;
    }

    public SibaAccountForm customerNumber3(String customerNumber3) {
        this.customerNumber3 = customerNumber3;
        return this;
    }

    public void setCustomerNumber3(String customerNumber3) {
        this.customerNumber3 = customerNumber3;
    }

    public String getCustomerNumber4() {
        return customerNumber4;
    }

    public SibaAccountForm customerNumber4(String customerNumber4) {
        this.customerNumber4 = customerNumber4;
        return this;
    }

    public void setCustomerNumber4(String customerNumber4) {
        this.customerNumber4 = customerNumber4;
    }

    public String getCustomerNumber5() {
        return customerNumber5;
    }

    public SibaAccountForm customerNumber5(String customerNumber5) {
        this.customerNumber5 = customerNumber5;
        return this;
    }

    public void setCustomerNumber5(String customerNumber5) {
        this.customerNumber5 = customerNumber5;
    }

    public String getCustomerNumber6() {
        return customerNumber6;
    }

    public SibaAccountForm customerNumber6(String customerNumber6) {
        this.customerNumber6 = customerNumber6;
        return this;
    }

    public void setCustomerNumber6(String customerNumber6) {
        this.customerNumber6 = customerNumber6;
    }

    public String getSendingBillCycle() {
        return sendingBillCycle;
    }

    public SibaAccountForm sendingBillCycle(String sendingBillCycle) {
        this.sendingBillCycle = sendingBillCycle;
        return this;
    }

    public void setSendingBillCycle(String sendingBillCycle) {
        this.sendingBillCycle = sendingBillCycle;
    }

    public String getHowToSendBill() {
        return howToSendBill;
    }

    public SibaAccountForm howToSendBill(String howToSendBill) {
        this.howToSendBill = howToSendBill;
        return this;
    }

    public void setHowToSendBill(String howToSendBill) {
        this.howToSendBill = howToSendBill;
    }

    public String getOtherServices() {
        return otherServices;
    }

    public SibaAccountForm otherServices(String otherServices) {
        this.otherServices = otherServices;
        return this;
    }

    public void setOtherServices(String otherServices) {
        this.otherServices = otherServices;
    }

    public String getAccountType() {
        return accountType;
    }

    public SibaAccountForm accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getLetterNumber() {
        return letterNumber;
    }

    public SibaAccountForm letterNumber(String letterNumber) {
        this.letterNumber = letterNumber;
        return this;
    }

    public void setLetterNumber(String letterNumber) {
        this.letterNumber = letterNumber;
    }

    public String getLetterDate() {
        return letterDate;
    }

    public SibaAccountForm letterDate(String letterDate) {
        this.letterDate = letterDate;
        return this;
    }

    public void setLetterDate(String letterDate) {
        this.letterDate = letterDate;
    }

    public String getLetterOrganization() {
        return letterOrganization;
    }

    public SibaAccountForm letterOrganization(String letterOrganization) {
        this.letterOrganization = letterOrganization;
        return this;
    }

    public void setLetterOrganization(String letterOrganization) {
        this.letterOrganization = letterOrganization;
    }

    public Customer getCustomer() {
        return customer;
    }

    public SibaAccountForm customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SibaAccountForm sibaAccountForm = (SibaAccountForm) o;
        if (sibaAccountForm.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sibaAccountForm.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SibaAccountForm{" +
            "id=" + getId() +
            ", registerDate='" + getRegisterDate() + "'" +
            ", registrationNumber='" + getRegistrationNumber() + "'" +
            ", registrationPlace='" + getRegistrationPlace() + "'" +
            ", registrationCapital='" + getRegistrationCapital() + "'" +
            ", activityType='" + getActivityType() + "'" +
            ", longTime='" + getLongTime() + "'" +
            ", boardManagementLong='" + getBoardManagementLong() + "'" +
            ", phoneNumber1='" + getPhoneNumber1() + "'" +
            ", phoneNumber2='" + getPhoneNumber2() + "'" +
            ", faxNumber='" + getFaxNumber() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            ", plainAddress='" + getPlainAddress() + "'" +
            ", accountRegistrationPurpose='" + getAccountRegistrationPurpose() + "'" +
            ", fullName1='" + getFullName1() + "'" +
            ", fullName2='" + getFullName2() + "'" +
            ", fullName3='" + getFullName3() + "'" +
            ", fullName4='" + getFullName4() + "'" +
            ", fullName5='" + getFullName5() + "'" +
            ", fullName6='" + getFullName6() + "'" +
            ", customerNumber1='" + getCustomerNumber1() + "'" +
            ", customerNumber2='" + getCustomerNumber2() + "'" +
            ", customerNumber3='" + getCustomerNumber3() + "'" +
            ", customerNumber4='" + getCustomerNumber4() + "'" +
            ", customerNumber5='" + getCustomerNumber5() + "'" +
            ", customerNumber6='" + getCustomerNumber6() + "'" +
            ", sendingBillCycle='" + getSendingBillCycle() + "'" +
            ", howToSendBill='" + getHowToSendBill() + "'" +
            ", otherServices='" + getOtherServices() + "'" +
            ", accountType='" + getAccountType() + "'" +
            ", letterNumber='" + getLetterNumber() + "'" +
            ", letterDate='" + getLetterDate() + "'" +
            ", letterOrganization='" + getLetterOrganization() + "'" +
            "}";
    }
}
