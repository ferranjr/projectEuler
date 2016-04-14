package com.ferranjr



object IdeaCheatSheet {

  trait Foo {
    def hello(name: String):String
    def sayIt:Unit
  }

  class Bar extends Foo {
    def sayIt: Unit = ???
    def hello(name: String): String = ???
  }
}
