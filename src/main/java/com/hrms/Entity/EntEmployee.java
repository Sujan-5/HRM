package com.hrms.Entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "hrm")
public class EntEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ID", updatable = false, nullable = false)
    @Column(name="ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "Contact", nullable = false)
    private String contact;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SUPERVISOR_NAME", nullable = false)
    private String supervisorname;

    @Column(name = "SALARY", nullable = false)
    private int salary;

    @Column(name = "PANCARD", nullable = false)
    private int pancard;

    @Column(name = "Citizenship", nullable = false)
    private String citizen;

    private String citizentype;

    @Lob
    private byte[] data;




//    public EntEmployee(String citizen, String citizentype, byte[] data) {
//        this.citizen = citizen;
//        this.citizentype = citizentype;
//        this.data = data;
//    }


    public EntEmployee(){
        super();
    }

    public EntEmployee(String citizen, String citizentype, byte[] bytes) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSupervisorname() {
        return supervisorname;
    }

    public void setSupervisorname(String supervisorname) {
        this.supervisorname = supervisorname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPancard() {
        return pancard;
    }

    public void setPancard(int pancard) {
        this.pancard = pancard;
    }

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    public String getCitizentype() {
        return citizentype;
    }

    public void setCitizentype(String citizentype) {
        this.citizentype = citizentype;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EntEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", supervisorname='" + supervisorname + '\'' +
                ", salary=" + salary +
                ", pancard=" + pancard +
                ", citizen='" + citizen + '\'' +
                ", citizentype='" + citizentype + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "EntEmployee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
////                ", contact='" + contact + '\'' +
//                ", email='" + email + '\'' +
//                ", supervisorname='" + supervisorname + '\'' +
//                ", salary='" + salary + '\'' +
//                ", pancard='" + pancard + '\'' +
//                ", citizen='" + citizen + '\'' +
//                '}';
//    }
}
