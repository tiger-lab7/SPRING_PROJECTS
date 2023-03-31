package com.spring.FACTORIAL_WEB_COUNTER.Models;

import com.spring.FACTORIAL_WEB_COUNTER.Entities.FactorialResultsHolder;
import com.spring.FACTORIAL_WEB_COUNTER.Entities.FactorialResultsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.NavigableMap;
import java.util.TreeMap;

@Component
@Scope("singleton")

public class CashedFactorialCounter {

    @Autowired
    FactorialResultsRepository factorialResultsRepository;

    NavigableMap<Long, BigInteger> resultMap;
    FactorialResultsHolder resultsHolder;

    @Transactional
    public void init() {
        resultsHolder = factorialResultsRepository.findById(1L).orElse(new FactorialResultsHolder(1L, new TreeMap<>()));
        resultMap = new TreeMap<>(resultsHolder.getFactorials());
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

    @Transactional
    public void persistFactorialResults() {
        factorialResultsRepository.save(new FactorialResultsHolder(1L, resultMap));
    }
}
