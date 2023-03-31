package com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "singers")
@Setter
@Getter
@ToString
public class Singer {
    @Id
    int id;

    String firstName;
    String lastName;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    //Date birthDate;

    int version;
}
