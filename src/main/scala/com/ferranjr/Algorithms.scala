package com.ferranjr

import scala.collection.immutable.HashSet

object Algorithms {

  /**
   * Schibsted Algorithm test
   * ~~~~~~
   * Find in a constant time, if there exists two pairs into an array that add the given number
   *
   *    My final solution during test
   *    var stored:HashSet[Int] = HashSet()
   *    for(x <- xs){
   *      if(stored.contains(expected - x))
   *        return true
   *      else
   *        stored = stored + x
   *    }
   *    false
   */
  def findIfPairsAdds(xs: Seq[Int], expected: Int): Boolean = {
    xs.foldLeft(HashSet.empty[Int]){
      case (acc, el) =>
        if(acc.contains(expected - el)) return true
        else acc + el
    }
    false
  }

  /**
   * Schibsted Puzzle
   * ~~~~~~
   * Given 25 horses, having had them racing 5 times, how many more races we will need to
   * know which are the 3 top horses knowing
   *
   *
   *   a1 > a2 > a3 > a4 > a5
   *   b1 > b2 > b3 > b4 > b5
   *   c1 > c2 > c3 > c4 > c5
   *   d1 > d2 > d3 > d4 > d5
   *   e1 > e2 > e3 > e4 > e5
   *
   * STEP 1 .
   *   Run all the first ones... which will allow us to discard lots of them
   * STEP 2 .
   *   Discard all the candidates that for sure are slower than the top 3
   * STEP 3 .
   *   Run the remaining
   *
   * It should be 7 races to get the right answer
   *
   *
   */


  /**
   * All permutations of a Seq
   * ~~~~~~
   * given seq like Seq(1,2,3)
   * we expect all permutations
   *  Seq(
   *    Seq(1,2,3),
   *    Seq(1,3,2),
   *    Seq(2,1,3),
   *    Seq(2,3,1),
   *    Seq(3,1,2),
   *    Seq(3,2,1)
   *  )
   *
   */
  def getAllPermutations[A : Equiv](xs: Seq[A]):Seq[Seq[A]] = {
    xs.foldLeft[Seq[Seq[A]]](Seq(Seq())){
      case (acc, el) =>
        for{
          x <- xs
          perms <- getAllPermutations(xs.filterNot(_ == x))
        }
          yield x +: perms
    }
  }
}
