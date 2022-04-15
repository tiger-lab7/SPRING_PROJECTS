package org.example.simple.service;

import javax.persistence.*;

public class DBService {


}

@Entity
@Table(name="cats")
class Cat {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    String name;
}
