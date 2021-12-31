package com.example.uber.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BendingRide {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USERDATA_USER_NAME", nullable=false)
    UserData userData;
    String source;
    String destination;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="DRIVERDATA_USER_NAME", nullable=true)
    DriverData driverData;

}
