package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "CreditCard")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;
    private String name;
    private Double balance;

    private Long clientId;

    public Credit() {
    }

    public Credit(String number, String name, Double balance){
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return number;
    }

    public void setCreditCardNumber(String number) {
        this.number = number;
    }

    public String getClientName() {
        return name;
    }

    public void setClientName(String name) {
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
        if (!(o instanceof Credit)) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) &&
                Objects.equals(clientId, credit.clientId) &&
                Objects.equals(number, credit.number) &&
                Objects.equals(name, credit.name) &&
                Objects.equals(balance, credit.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, balance, clientId);
    }

    public static CreditBuilder builder(){

        return new CreditBuilder();
    }

    public static final class CreditBuilder{

        private Credit credit;

        private CreditBuilder(){

            credit = new Credit();
        }

        public CreditBuilder withCreditCardNumber(String number){

            credit.setCreditCardNumber(number);
            return this;
        }

        public CreditBuilder withClientName(String name){

            credit.setClientName(name);
            return this;
        }

        public CreditBuilder withBalance(Double balance){

            credit.setBalance(balance);
            return this;
        }

        public CreditBuilder withClientId(Long clientId){

            credit.setClientId(clientId);
            return this;
        }
    }
}
