package com.example.uber.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
@Getter
@Setter
@Entity

public class DriverData extends Person {
        String licence;
        String nationalId;
        int status;
        public DriverData(String userName, String password, String email, String phoneNumber, String licence, String nationalId,int status) {
                super(userName, password, email, phoneNumber);
                this.licence = licence;
                this.nationalId = nationalId;
                this.status=status;

        }

        public DriverData() {
        }
}
