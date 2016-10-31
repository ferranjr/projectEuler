package com.ferranjr.cakeinterviews

object Algorithms {

  /**
    * Given an arrayOfInts, find the highestProduct you can get from three of the integers.
    * The input arrayOfInts will always have at least three integers.
    */
  def highestProduct( arr: Array[Int] ): Int = {

    // Force Brute => O(n^3) : Too Bad
    // for ( i <- arr.indices )
    //   for( j <- arr.indices )
    //     for( k <- arr.indices )

    // We need, at minimum of O(n) to go through all of the intes we have at least once

    // Greedy approach, we keep could track of :
    //  - Highest 2,  Lowest 2, lowest and highest
    //  - or, alternatively, highestProduct2, lowestProduct2, lowest and highest

    // We're going to start at the 3rd item (at index 2)
    // so pre-populate highests and lowests based on the first 2 items.
    // we could also start these as null and check below if they're set
    // but this is arguably cleaner
    var highest = Math.max( arr(0), arr(1))
    var lowest  = Math.min( arr(0), arr(1))

    var highestProductOf2 = arr(0) * arr(1)
    var lowestProductOf2  = arr(0) * arr(1)


    // except this one--we pre-populate it for the first /3/ items.
    // this means in our first pass it'll check against itself, which is fine.
    var highestProductOf3 = arr(0) * arr(1) * arr(2)

    // We go through the array starting at index 2
    for( i <- 2 until arr.length){
      val current = arr(i)

      // do we have a new highest product of 3?
      // it's either the current highest,
      // or the current times the highest product of two
      // or the current times the lowest product of two
      highestProductOf3 = Math.max(
        Math.max( highestProductOf3, current * highestProductOf2),
        current * lowestProductOf2)

      // do we have a new highest product of two?
      highestProductOf2 = Math.max(Math.max(
        highestProductOf2,
        current * highest),
        current * lowest)

      // do we have a new lowest product of two?
      lowestProductOf2 = Math.min(Math.min(
        lowestProductOf2,
        current * highest),
        current * lowest)

      // do we have a new highest?
      highest = Math.max(highest, current)

      // do we have a new lowest?
      lowest = Math.min(lowest, current)
    }

    highestProductOf3
  }
}
