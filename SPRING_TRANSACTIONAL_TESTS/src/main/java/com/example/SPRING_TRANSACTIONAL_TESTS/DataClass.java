package com.example.SPRING_TRANSACTIONAL_TESTS;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_data")
@NoArgsConstructor
@ToString
public class DataClass {

    @Id
    @Setter
    @Getter
    private Long id;


    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date currentTimeStamp;


    public DataClass(Long id, String name, Date currentTimeStamp) {
        this.id = id;
        this.name = name;
        this.currentTimeStamp = currentTimeStamp;
    }
}
