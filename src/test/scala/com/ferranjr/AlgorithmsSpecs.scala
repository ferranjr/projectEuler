package com.ferranjr

import org.scalatest.{Matchers, FlatSpec}


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

}
