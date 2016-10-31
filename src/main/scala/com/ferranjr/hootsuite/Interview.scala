package com.ferranjr.hootsuite

import scala.collection.immutable.HashSet


object Interview {

  def arrayHasSum(nums: List[Int], sum: Int ): Boolean = {

    //
    nums.foldLeft( HashSet.empty[Int] ){
      case (acc, i) =>
        if( acc.contains( sum - i ) )
          return true
        else
          acc + i
    }

    false

  }


}
