package org.hiber.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Ticket {
    @Id
    char[] ticket_no;
    char[] book_ref;
    char[] passenger_id;
    String passenger_name;
    String contact_data;
}
