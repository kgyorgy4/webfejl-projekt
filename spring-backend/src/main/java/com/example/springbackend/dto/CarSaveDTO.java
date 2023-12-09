package com.example.springbackend.dto;

public class CarSaveDTO {

    private String rendszam;
    private String szin;

    private Long employee_id;

    public CarSaveDTO(String rendszam, String szin, Long employee_id) {
        this.rendszam = rendszam;
        this.szin = szin;
        this.employee_id = employee_id;
    }

    public CarSaveDTO() {
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

    public Long getTulaj_id() {
        return employee_id;
    }

    public void setTulaj_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "CarSaveDTO{" +
                "rendszam='" + rendszam + '\'' +
                ", szin='" + szin + '\'' +
                ", employee_id=" + employee_id +
                '}';
    }
}
