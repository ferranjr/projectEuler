package com.ferranjr.hootsuite

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.HashSet


class InterviewSpecs extends FlatSpec with Matchers {

  import com.ferranjr.hootsuite.Interview._

  "arrayHasSum" should "return true when it is" in {

    arrayHasSum(List(2, 3, 4, 5, 5, 1), 3) shouldBe true
  }

  it should "return false when it is not " in {

    arrayHasSum(List(2, 3, 4, 5, 5, 1), 19) shouldBe false
  }

}
