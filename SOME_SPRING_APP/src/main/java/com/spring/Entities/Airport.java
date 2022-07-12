package com.spring.Entities;

import lombok.*;
import org.springframework.data.geo.Point;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airports")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Airport {
    @Id
    @Column(name = "airport_code")
    private String airportCode;
    @Column(name = "airport_name")
    private String airportName;
    @Column(name = "city")
    private String city;
    /*@Column(name = "coordinates")
    private Point coordinates;*/
    @Column(name = "timezone")
    private String timeZone;
}
