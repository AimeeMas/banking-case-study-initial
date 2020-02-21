package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double balance;

    private Long clientId;

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id) &&
                Objects.equals(name, loan.name) &&
                Objects.equals(balance, loan.balance) &&
                Objects.equals(clientId, loan.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBalance(), getClientId());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", clientId=" + clientId +
                '}';
    }

    public static AutoLoanBuilder builder(){

        return new AutoLoanBuilder();
    }

    public static final class AutoLoanBuilder{

        private Loan loan;

        private AutoLoanBuilder(){

            loan = new Loan();
        }

        public AutoLoanBuilder withClientId(Long clientId){
            loan.setClientId(clientId);
            return this;
        }

        public AutoLoanBuilder withName(String name){
            loan.setName(name);
            return this;
        }

        public AutoLoanBuilder withBalance(Double balance){
            loan.setBalance(balance);
            return this;
        }

        public Loan build(){
            return loan;
        }
    }
}
