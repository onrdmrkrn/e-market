package com.kitapyurdu.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CommunicateInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int communicateInformationId;
    private String adress;
    private String telephonNumber;
    private String birthDay;


    public CommunicateInformation() {
    }

    public CommunicateInformation(int communicateInformationId, String adress, String telephonNumber, String birthDay) {
        this.communicateInformationId = communicateInformationId;
        this.adress = adress;
        this.telephonNumber = telephonNumber;
        this.birthDay = birthDay;
    }

    public int getCommunicateInformationId() {
        return communicateInformationId;
    }

    public void setCommunicateInformationId(int communicateInformationId) {
        this.communicateInformationId = communicateInformationId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephonNumber() {
        return telephonNumber;
    }

    public void setTelephonNumber(String telephonNumber) {
        this.telephonNumber = telephonNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
