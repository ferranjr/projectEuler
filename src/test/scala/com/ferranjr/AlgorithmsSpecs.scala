package com.ferranjr

import org.scalatest.{FlatSpec, Matchers}


class AlgorithmsSpecs extends FlatSpec with Matchers {

  "findIfPairsAdds" should "return true if exists a valid pair" in {
    val testArray     = Seq(1,2,3,4,5,6,7)
    val testExpected  = 11

    Algorithms.findIfPairsAdds(testArray, testExpected) should ===(true)
  }

  it should "return true if exist by adding two numbers that are equal" in {
    val testArray     = Seq(1,2,5,6,5)
    val testExpected  = 10

    Algorithms.findIfPairsAdds(testArray, testExpected) should ===(true)
  }

  it should "return false if doesn't exist" in {
    val testArray     = Seq(1,2,3,4,5,6,7)
    val testExpected  = 20

    Algorithms.findIfPairsAdds(testArray, testExpected) should ===(false)
  }

  it should "return false for an empty array" in {
    val testArray    = Seq.empty[Int]
    val testExpected = 10

    Algorithms.findIfPairsAdds(testArray, testExpected) should ===(false)
  }


  "getAllPermutations" should "give all permutations for given sequence" in {
    val testSeq = Seq(1,2,3)
    val testExpected = Seq(
        Seq(1,2,3),
        Seq(1,3,2),
        Seq(2,1,3),
        Seq(2,3,1),
        Seq(3,1,2),
        Seq(3,2,1)
      )

    val result = Algorithms.getAllPermutations(testSeq)
    result should ===(testExpected)

    result.length should ===(testExpected.length)
  }

  it should "give same seq if only one element" in {
    Algorithms.getAllPermutations(Seq(1)) should ===(Seq(Seq(1)))
  }

  it should "work for a string" in {
    val testSeq = "abc"
    val testExpected = Seq(
      Seq('a','b','c'),
      Seq('a','c','b'),
      Seq('b','a','c'),
      Seq('b','c','a'),
      Seq('c','a','b'),
      Seq('c','b','a')
    )

    Algorithms.getAllPermutations(testSeq) should ===(testExpected)
  }

  it should "give empty result for empty seq" in {
    Algorithms.getAllPermutations(Seq.empty[Int]) should ===(Seq(Seq()))
  }

  "deleteCharPairs" should "work as expected" in {

    Algorithms.deleteAdjacentCharPairs("aabbccdde".toList)    should ===(List('e'))
    Algorithms.deleteAdjacentCharPairs("abbadccdfer".toList)  should ===(List('f','e','r'))
    Algorithms.deleteAdjacentCharPairs("aabbccdd".toList)     should ===(List.empty[Char])

  }


  "LongestPerimeterTriange" should "return -1 when no possible" in {

    Algorithms.longestPerimeterTriangle(List(1, 2, 3)) should ===(None)
  }

  it should "return the 3 sides when possible" in {

    Algorithms.longestPerimeterTriangle(List(1,1,1,3,3)) should ===(Some( (3, 3, 1) ))
  }

  it should "work for non straight forward cases" in {

    Algorithms.longestPerimeterTriangle(List(3, 9, 2, 15, 3)) should ===(Some( 3, 3, 2 ))
  }


  "isPalindrome" should "be true for palindrome" in {

    val palindromeString = "abba"
    Algorithms.isPalindrome(palindromeString) should ===(true)
  }

  it should "be false for non palindrom" in {

    val nonPalindrome = "12345"
    Algorithms.isPalindrome(nonPalindrome) should ===(false)
  }

  it should "be false for empty string" in {

    Algorithms.isPalindrome("") should ===(false)
  }

  "reverseWords" should "return olleH dlroW for Hello World" in {

    Algorithms.reverseWords("Hello World") should ===("olleH dlroW".toCharArray)
  }

  "getMaxProfit" should "return 6 given the example" in {

    val stockPricesYesterday = List( 10, 7, 5, 8, 11, 9 )

    Algorithms.getMaxProfit(stockPricesYesterday) shouldBe Some(6)
  }

  it should "return 0 if never change value" in {

    val stockPricesYesterday = List.fill(5)(10)

    Algorithms.getMaxProfit(stockPricesYesterday) shouldBe Some(0)

  }

  it should "work if only goes up at the beginning and then drops" in {
    val stockPricesYesterday = List( 10, 12, 9, 8, 7, 6 )

    Algorithms.getMaxProfit(stockPricesYesterday) shouldBe Some(2)
  }

  it should "no possible answer due it shouldn't have bought" in {
    val stockPricesYesterday = List( 10, 9, 8, 7, 6, 5 )

    Algorithms.getMaxProfit(stockPricesYesterday) shouldBe None
  }

  it should "return None for empty list" in {
    val stockPricesYesterday = List.empty[Int]

    Algorithms.getMaxProfit(stockPricesYesterday) shouldBe None
  }

  "getProductsOfAllIntsExceptAtIndex" should "work as per example" in {
    Algorithms
      .getProductsOfAllIntsExceptAtIndex( List(1,7,3,4) ).toList shouldBe List(7*3*4, 1*3*4, 1*7*4, 1*7*3)
  }
}
