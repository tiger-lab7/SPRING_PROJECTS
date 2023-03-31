package com.spring.test_project.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Ticket {
    @Id
    String ticket_no;
    char[] book_ref;
    char[] passenger_id;
    @Column(name = "passenger_name")
    String passengerName;
    char[] contact_data;
}
