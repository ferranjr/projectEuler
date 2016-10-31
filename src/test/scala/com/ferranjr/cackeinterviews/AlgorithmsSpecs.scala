package com.ferranjr.cackeinterviews

import org.scalatest.{FlatSpec, Matchers}


class AlgorithmsSpecs extends FlatSpec with Matchers {

  import com.ferranjr.cakeinterviews.Algorithms._


  "highestProduct" should "work for [1, 4, 5, 6 , 10]" in {
    highestProduct( Array( 1, 4, 5, 6 , 10 ) ) shouldBe 300
  }

  it should "Work even for max product with negative numbers [-4, -10, 3, 1, 1, 2, 3, 5]" in {
    highestProduct(Array( -4, -10, 3, 1, 1, 2, 3, 5)) shouldBe 200
  }
}
