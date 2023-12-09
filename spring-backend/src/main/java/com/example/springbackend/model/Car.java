package com.example.springbackend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "RENDSZAM",unique = true)
    private String rendszam;
    @Column(name = "SZIN")
    private String szin;


    private Long employee_id;


    public Car() {
    }

    public Car(String rendszam, String szin, Long tulaj_id) {
        this.rendszam=rendszam;
        this.szin=szin;
        this.employee_id=employee_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", rendszam='" + rendszam + '\'' +
                ", szin='" + szin + '\'' +
                ", employee_id=" + employee_id +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Car(int id, String rendszam, String szin, Long employee_id) {
        this.id = id;
        this.rendszam = rendszam;
        this.szin = szin;
        this.employee_id = employee_id;
    }










}