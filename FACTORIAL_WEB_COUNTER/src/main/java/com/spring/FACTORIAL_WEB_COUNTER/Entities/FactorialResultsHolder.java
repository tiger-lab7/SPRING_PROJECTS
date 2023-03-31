package com.spring.FACTORIAL_WEB_COUNTER.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigInteger;
import java.util.SortedMap;

@Entity
@Table(name="factorials")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FactorialResultsHolder {
    @Id
    long id;
    @ElementCollection(fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.SAVE_UPDATE)
    SortedMap<Long, BigInteger> factorials;
}
