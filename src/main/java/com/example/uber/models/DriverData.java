package com.example.uber.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
@Getter
@Setter
@Entity

public class DriverData extends Person {
        private String licence;
        private String nationalId;
        private int AVGRate;
        public DriverData(String userName, String password, String email, String phoneNumber, String licence, String nationalId,int status) {
                super(userName, password, email, phoneNumber,false,status);
                this.licence = licence;
                this.nationalId = nationalId;

        }

        public DriverData() {
        }
}
