package com.kitapyurdu.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int profileId;
    @OneToOne
    private CommunicateInformation communicateInformation;


    public Profile() {
    }

    public Profile(int profileId, CommunicateInformation communicateInformation) {
        this.profileId = profileId;
        this.communicateInformation = communicateInformation;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public CommunicateInformation getCommunicateInformation() {
        return communicateInformation;
    }

    public void setCommunicateInformation(CommunicateInformation communicateInformation) {
        this.communicateInformation = communicateInformation;
    }
}
