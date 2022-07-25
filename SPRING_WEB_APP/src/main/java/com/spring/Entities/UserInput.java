package com.spring.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_input_messages")
@NoArgsConstructor
@Getter
@Setter
public class UserInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String message;
}
