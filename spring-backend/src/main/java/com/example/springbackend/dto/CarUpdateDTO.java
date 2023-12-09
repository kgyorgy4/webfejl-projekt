package com.example.springbackend.dto;

import com.example.springbackend.model.Employee;

public class CarUpdateDTO {
    private Long id;
    private String rendszam;
    private String szin;

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    private Long employee_id;

    @Override
    public String toString() {
        return "CarUpdateDTO{" +
                "id=" + id +
                ", rendszam='" + rendszam + '\'' +
                ", szin='" + szin + '\'' +
                ", employee_id=" + employee_id +
                '}';
    }

    public CarUpdateDTO(Long id, String rendszam, String szin, Long employee_id) {
        this.id = id;
        this.rendszam = rendszam;
        this.szin = szin;
        this.employee_id = employee_id;
    }

    public CarUpdateDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


}
