package com.ferranjr

import scala.collection.immutable.HashSet

object Algorithms {

  /**
   * Schibsted test
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
  def findIfPairsAdds(xs: Array[Int], expected: Int): Boolean = {
    xs.foldLeft(HashSet.empty[Int]){
      case (acc, el) =>
        if(acc.contains(expected - el)) return true
        else acc + el
    }
    false
  }
}
