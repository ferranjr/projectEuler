package com.ferranjr.projectEuler

import org.scalatest.{FlatSpec, Matchers}


class Problem1to10Spec extends FlatSpec with Matchers {

  "sumMultiplesThreeOrFiveBelow" should "be 23 for natural numbers below 10" in {
    Problem1.sumMultiplesThreeOrFiveBelowNumber(10) should ===(23)
  }

  it should "be 233168 for natural numbers below 100" in {
    Problem1.sumMultiplesThreeOrFiveBelowNumber(1000) should ===(233168)
  }

  it should "be 233333166668 for naturals below 1000000" in {
    Problem1.sumMultiplesThreeOrFiveBelowNumber(1000000) should === (233333166668L)
  }


  "sumEvenNumbersFibonacciLess4M" should "be 4613732" in {
    Problem2.sumEvenNumbersFibonacciLess4M should===(4613732)
  }

  "largestPrimeFactor" should "calculate correctly" in {
    Problem3.largestPrimeFactor(13195) should === (29)
  }
  it should "work for the long 600851475143L" in {
    Problem3.largestPrimeFactor(600851475143L) should === (6857)
  }

  "isPalindrome" should "validate 9009 as palindrome" in {
    Problem4.isPalindrome(9009) should === (true)
  }
  it should "be false if is non palindrome like 3456" in {
    Problem4.isPalindrome(3456) should === (false)
  }
  it should "be false if is not even an odd number of chars" in {
    Problem4.isPalindrome(40104) should === (false)
  }

  "Smallest Multiple" should "be 2520 for range 1 to 10" in {
    Problem5.smallestMultipleImproved( 1, 10 ) should === (2520)
  }
  it should "be 232792560 for range 1 to 20" in {
    Problem5.smallestMultipleImproved( 1, 20 ) should === (232792560)
  }

  "Sum Square Difference" should "be 2640 for 1 to 10" in {
    Problem6.sumSquareDifference(1, 10) should === (2640)
  }
  it should "be 25164150 for 1 to 100" in {
    Problem6.sumSquareDifference(1, 100) should === (25164150)
  }

  "getTheNthPrime" should "be 13 for the 6th prime" in {
    Problem7.getTheNthPrime(6) should === (13)
  }
  it should "be 104743 for the 10001st prime" in {
    Problem7.getTheNthPrime(10001) should === (104743)
  }

  "greatestProductOfAdjacents" should "be 5832 for 4 adjacents" in {
    Problem8.greatestProductOfAdjacents(Problem8.sequence)(4) should === (5832)
  }
  it should "be 23514624000 for 13 adjacents" in {
    Problem8.greatestProductOfAdjacents(Problem8.sequence)(13) should === (23514624000L)
  }

  "findSpecialPythagoreanTriplet" should "be 31875000" in {
    Problem9.findProductSpecialPythagoreanTriplet.head should === (31875000)
  }

  "findSumOfPrimesUpTo" should "be 17 for primes below 10" in {
    Problem10.findSumOfPrimesUpTo(10) should === (17)
  }
  it should "be 142913828922 for primes below 2000000" in {
    Problem10.findSumOfPrimesUpTo(2000000) should === (142913828922L)
  }
}
