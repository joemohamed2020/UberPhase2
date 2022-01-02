package com.example.uber.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class FavoriteAreas  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String driverName;
    @Column(nullable = false)
    private String Area;

    public FavoriteAreas(String driverName, String area) {
        this.driverName = driverName;
        Area = area;
    }
}
