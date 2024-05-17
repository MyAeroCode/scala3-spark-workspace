package chapter001

import chapter001.{msg}
import org.scalatest.funspec.AnyFunSpec

class MainSpec extends AnyFunSpec {
  describe("hello") {
    assert(msg == "Hello, World!")
  }
}
