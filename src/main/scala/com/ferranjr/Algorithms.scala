package com.ferranjr

import scala.collection.immutable.HashSet
import scala.util.Try

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
   *
   *   b1 > b2 > b3 > b4 > b5
   *
   *   c1 > c2 > c3 > c4 > c5
   *
   *   d1 > d2 > d3 > d4 > d5
   *
   *   e1 > e2 > e3 > e4 > e5
   *
   * STEP 1 .
   *   Run all the first ones... which will allow us to discard lots of them
   *
   *   a1 > a2 > a3 > a4 > a5
   *    v
   *   b1 > b2 > b3 > b4 > b5
   *    v
   *   c1 > c2 > c3 > c4 > c5
   *    v
   *   d1 > d2 > d3 > d4 > d5
   *    v
   *   e1 > e2 > e3 > e4 > e5
   *
   * STEP 2 .
   *   Discard all the candidates that for sure are slower than the top 3
   *
   *   a1 > a2 > a3
   *    v
   *   b1 > b2
   *    v
   *   c1
   *
   *
   * STEP 3 .
   *   Run the remaining, a part from the first. and the first two will become the 2nd and 3rd at the top
   *
   *   a2, a3, b1, b2, c1
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

  /**
   * Shil has a string, , consisting of  lowercase English letters. In one operation, he can delete any pair of
   * adjacent letters with same value. For example, string "" would become either "" or "" after operation.
   * Shil wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it
   * can be performed. Help Shil out by finding and printing 's non-reducible form!
   *
   * Note: If the final string is empty, print .
   *
   */
  def deleteAdjacentCharPairs(in: List[Char]): List[Char] = {

    def helper(acc: List[Char]): List[Char] = {

      val res =
        acc match {
          case c1 :: c2 :: xs =>
            if( c1 == c2 )
              helper(xs)
            else
              c1 :: helper( c2 :: xs)
          case xs =>
            xs
        }

      if(res.length == acc.length)
        res
      else
        helper(res)
    }

    helper(in)
  }


  /**
    * Longest Perimeter for non-degenerated Triangle created with 3 of the given sticks
    *
    * > in:
    *   5
    *   1 1 1 3 3
    *
    * > out:
    *   3 3 1
    *
    */
  def longestPerimeterTriangle(in: List[Int]): Option[(Int, Int, Int)] = {

    in.sorted(Ordering.Int.reverse) match {
      case a :: b :: c :: xs
        if a < (b + c) =>
        Some((a, b, c))

      case a :: b :: c :: xs
        if xs.nonEmpty =>
        longestPerimeterTriangle( b :: c :: xs )

      case _ =>
        None
    }
  }


  /**
    * Write code to figure out whether or not a given string is a palindrome
    */
  def isPalindrome(in: String) : Boolean = {

    // STEP. 1 . straight forward solution
    // issue, cost of revers is N and compare is also N
    // cost total 2N so... basically N
    //    in.reverse == in

    // STEP 2 . more thoughtful solution
    // although reduces cost to N/2 in bigO will still be N
    if( in.nonEmpty ) {
      val half = in.length / 2

      // cost is N / 2 so  N
      (0 to half).foreach { i =>
        val a = in.charAt(i)
        val b = in.charAt(in.length - 1 - i)

        if(a != b) return false
      }
      true
    }
    else
      false
  }
}
