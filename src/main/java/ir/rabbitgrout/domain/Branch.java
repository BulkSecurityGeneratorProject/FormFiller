package ir.rabbitgrout.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Branch.
 */
@Entity
@Table(name = "branch")
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @NotNull
    @Column(name = "branch_plain_address", nullable = false)
    private String branchPlainAddress;

    @NotNull
    @Column(name = "branch_number", nullable = false)
    private String branchNumber;

    @ManyToOne
    @JsonIgnoreProperties("branches")
    private Bank bank;

    @OneToOne
    @JoinColumn(unique = true)
    private Address address;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public Branch branchName(String branchName) {
        this.branchName = branchName;
        return this;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchPlainAddress() {
        return branchPlainAddress;
    }

    public Branch branchPlainAddress(String branchPlainAddress) {
        this.branchPlainAddress = branchPlainAddress;
        return this;
    }

    public void setBranchPlainAddress(String branchPlainAddress) {
        this.branchPlainAddress = branchPlainAddress;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public Branch branchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
        return this;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public Branch bank(Bank bank) {
        this.bank = bank;
        return this;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Address getAddress() {
        return address;
    }

    public Branch address(Address address) {
        this.address = address;
        return this;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        Branch branch = (Branch) o;
        if (branch.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), branch.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Branch{" +
            "id=" + getId() +
            ", branchName='" + getBranchName() + "'" +
            ", branchPlainAddress='" + getBranchPlainAddress() + "'" +
            ", branchNumber='" + getBranchNumber() + "'" +
            "}";
    }
}
