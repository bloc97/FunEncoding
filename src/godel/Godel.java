/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package godel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bowen
 */
public class Godel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //BigInteger i = new BigInteger("15567");
        //i = i.pow(255);
        //System.out.println(i);
        int numPrimes = 5;
        int bound = numPrimes * (int)Math.ceil(Math.log(numPrimes) + Math.log(Math.log(numPrimes)));
        List<Integer> primes = sieveOfEratosthenes(bound);
        System.out.println(bound);
        System.out.println(primes);
        System.out.println(primes.size());
        System.out.println(sieveOfEratosthenesNPrimes(numPrimes));
    }
    public static List<Integer> sieveOfEratosthenes(int searchBound) {
        final int n = searchBound;
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
    public static List<Integer> sieveOfEratosthenesNPrimes(int numPrimes) {
        int bound = numPrimes * (int)Math.ceil(Math.log(numPrimes) + Math.log(Math.log(numPrimes)));
        BitSet notPrime = new BitSet();
        List<Integer> primeNumbers = new ArrayList<>();
        for (int p = 2;; p++) {
            if (primeNumbers.size() >= numPrimes) {
                return primeNumbers;
            }
            if (!notPrime.get(p)) {
                for (int i = p * 2; i <= bound; i += p) {
                    notPrime.set(i);
                    //prime[i] = false;
                }
                primeNumbers.add(p);
            }
        }
        //return primeNumbers;
    }
}
