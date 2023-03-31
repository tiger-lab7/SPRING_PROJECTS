package org.example.Models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.Entities.ResultHolder;

import java.math.BigInteger;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CashedFactorialCounter {
    private final EntityManager em;
    NavigableMap<Long, BigInteger> resultMap;
    private ResultHolder resultHolder;


    public CashedFactorialCounter(EntityManagerFactory emf) {
        em = emf.createEntityManager();
        resultHolder = new ResultHolder(1L, new TreeMap<>());
        resultHolder = em.merge(resultHolder);
        resultMap = new TreeMap<>(resultHolder.getResultMap());
    }


    public BigInteger getFactorial(long n) {
        if (resultMap.containsKey(n)) return resultMap.get(n);

        try {
            long existKey = resultMap.floorKey(n);
            BigInteger result = factorialCounter(n, existKey + 1, resultMap.get(existKey));
            resultMap.put(n, result);
            return result;

        } catch (NullPointerException ignored) {
        }

        BigInteger result = factorialCounter(n, 1, BigInteger.ONE);
        resultMap.put(n, result);
        return result;
    }


    private BigInteger factorialCounter(long endNumber, long startNumber, BigInteger startResult) {
        BigInteger result = new BigInteger(startResult.toByteArray());
        for (; startNumber < endNumber + 1; startNumber++)
            result = result.multiply(BigInteger.valueOf(startNumber));
        return result;
    }

    public void persistResultsMap() {
        resultHolder.setResultMap(resultMap);

        em.getTransaction().begin();
        em.persist(resultHolder);
        em.getTransaction().commit();
    }
}
