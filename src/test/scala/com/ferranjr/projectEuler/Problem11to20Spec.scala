package com.ferranjr.projectEuler

import org.scalatest.{Matchers, FlatSpec}

class Problem11to20Spec extends FlatSpec with Matchers {

  "getMaxProduct" should "be 70600674 for the given grid" in {
    Problem11.getMaxProduct(Problem11.grid) should ===(70600674)
  }

}
