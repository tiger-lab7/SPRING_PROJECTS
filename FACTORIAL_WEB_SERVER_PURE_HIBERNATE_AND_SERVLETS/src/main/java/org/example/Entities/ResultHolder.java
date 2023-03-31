package org.example.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Map;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultHolder {
    @Id
    long id;
    @Column(name="results")
    @ElementCollection
    Map<Long, BigInteger> resultMap;
}
