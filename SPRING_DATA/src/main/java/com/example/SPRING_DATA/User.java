package com.example.SPRING_DATA;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@ToString
public class User {

    @Id
    @Getter
    @Setter
    private Long id;

    @Column(name = "names", length = 30, nullable = false)
    @Getter
    @Setter
    private String name;
}
