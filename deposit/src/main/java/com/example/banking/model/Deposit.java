package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "Deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;
    private String name;
    private Double balance;
    private Double initialBalance;

    private Long clientId;

    public Deposit() {
    }

    public Deposit(String number, String name, Double balance, Double initialBalance) {

        this.number = number;
        this.name = name;
        this.balance = balance;
        this.initialBalance = initialBalance;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
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
        if (!(o instanceof Deposit)) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(id, deposit.id) &&
                Objects.equals(number, deposit.number) &&
                Objects.equals(name, deposit.name) &&
                Objects.equals(balance, deposit.balance) &&
                Objects.equals(initialBalance, deposit.initialBalance) &&
                Objects.equals(clientId, deposit.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, balance, initialBalance, clientId);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", initialBalance=" + initialBalance +
                ", clientId=" + clientId +
                '}';
    }

    public static DepositBuilder builder() {
        return new DepositBuilder();
    }

    private static final class DepositBuilder{

        private Deposit deposit;

        private DepositBuilder(){

            deposit = new Deposit();
        }

    public DepositBuilder withCreditCardNumber(String number){

        deposit.setNumber(number);
            return this;
        }

        public DepositBuilder withClientName(String name){

            deposit.setName(name);
            return this;
        }

        public DepositBuilder withBalance(Double balance){

            deposit.setBalance(balance);
            return this;
        }

        public DepositBuilder withClientId(Long clientId){

            deposit.setClientId(clientId);
            return this;
        }
    }
}
