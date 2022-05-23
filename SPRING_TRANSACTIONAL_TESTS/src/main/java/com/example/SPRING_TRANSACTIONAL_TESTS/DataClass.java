package com.example.SPRING_TRANSACTIONAL_TESTS;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "user_data")
@NoArgsConstructor
public class DataClass {


    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "user")
    @Getter
    @Setter
    private String name;

    @Column(name = "add_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Instant addTime;


    public DataClass(String name, Instant addTime) {
        this.name = name;
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "DataClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}
