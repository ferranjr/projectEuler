package com.ferranjr.hootsuite

import scala.annotation.tailrec

object Interview {

  def arrayHasSum(nums: List[Int], sum: Int ): Boolean = {
    nums.foldLeft( Set.empty[Int] ){
      case (acc, i) =>
        if( acc.contains( sum - i ) )
          return true
        else
          acc + i
    }

    false
  }


  /**
    * Write a function that takes in a List[(String,String)] representing (source, destination) flight segments and returns a List[String] that contains the itinerary that the segments represent.
    *
    * E.g. itinerary(List("YYZ"->"NYC", "YVR"->"SFO", "SFO"->"YYZ"))
    * res0: List[String] = List(YVR, SFO, YYZ, NYC)
    *
    * def itinerary( xs: List[(String, String)] ): List[String]
    */
  def itinerary( xs: Map[String, String] ): List[String] = {

    @tailrec
    def traverse(cur: String, m: Map[String, String], acc: List[String]): List[String] = {
      m.get(cur) match {
        case None =>
          acc
        case Some(snd) =>
          traverse(snd, m - cur, acc :+ snd)
      }
    }

    xs.find { case (origin, _) =>
      !xs.values.toList.contains(origin)
    }.fold(List.empty[String]){
      case (fst, _) =>
        traverse(fst, xs, fst :: Nil)
    }
  }

}
