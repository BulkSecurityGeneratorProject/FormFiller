package ir.rabbitgrout.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Bank.
 */
@Entity
@Table(name = "bank")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "bank_name", nullable = false)
    private String bankName;

    /**
     * A relationship
     */
    @ApiModelProperty(value = "A relationship")
    @OneToMany(mappedBy = "bank")
    private Set<Branch> branches = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public Bank bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public Bank branches(Set<Branch> branches) {
        this.branches = branches;
        return this;
    }

    public Bank addBranch(Branch branch) {
        this.branches.add(branch);
        branch.setBank(this);
        return this;
    }

    public Bank removeBranch(Branch branch) {
        this.branches.remove(branch);
        branch.setBank(null);
        return this;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
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
        Bank bank = (Bank) o;
        if (bank.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bank.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Bank{" +
            "id=" + getId() +
            ", bankName='" + getBankName() + "'" +
            "}";
    }
}
