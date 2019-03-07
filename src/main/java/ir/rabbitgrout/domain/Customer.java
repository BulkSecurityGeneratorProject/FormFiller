package ir.rabbitgrout.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "plain_address")
    private String plainAddress;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "birth_place")
    private String birthPlace;

    @OneToOne
    @JoinColumn(unique = true)
    private Address address;

    /**
     * A relationship
     */
    @ApiModelProperty(value = "A relationship")
    @OneToMany(mappedBy = "customer")
    private Set<SibaAccountForm> sibaAccountForms = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public Customer nationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public Customer identificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Customer fatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPlainAddress() {
        return plainAddress;
    }

    public Customer plainAddress(String plainAddress) {
        this.plainAddress = plainAddress;
        return this;
    }

    public void setPlainAddress(String plainAddress) {
        this.plainAddress = plainAddress;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Customer birth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Customer birthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
        return this;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Address getAddress() {
        return address;
    }

    public Customer address(Address address) {
        this.address = address;
        return this;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<SibaAccountForm> getSibaAccountForms() {
        return sibaAccountForms;
    }

    public Customer sibaAccountForms(Set<SibaAccountForm> sibaAccountForms) {
        this.sibaAccountForms = sibaAccountForms;
        return this;
    }

    public Customer addSibaAccountForm(SibaAccountForm sibaAccountForm) {
        this.sibaAccountForms.add(sibaAccountForm);
        sibaAccountForm.setCustomer(this);
        return this;
    }

    public Customer removeSibaAccountForm(SibaAccountForm sibaAccountForm) {
        this.sibaAccountForms.remove(sibaAccountForm);
        sibaAccountForm.setCustomer(null);
        return this;
    }

    public void setSibaAccountForms(Set<SibaAccountForm> sibaAccountForms) {
        this.sibaAccountForms = sibaAccountForms;
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
        Customer customer = (Customer) o;
        if (customer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", lastName='" + getLastName() + "'" +
            ", nationalId='" + getNationalId() + "'" +
            ", identificationNumber='" + getIdentificationNumber() + "'" +
            ", fatherName='" + getFatherName() + "'" +
            ", plainAddress='" + getPlainAddress() + "'" +
            ", birth='" + getBirth() + "'" +
            ", birthPlace='" + getBirthPlace() + "'" +
            "}";
    }
}
