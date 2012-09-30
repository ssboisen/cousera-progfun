package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("'(if (zero? x) max (/ 1 x))' is balanced.") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("'I told him ...' is balanced.") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("':-)' is unbalanced.") {
    assert(!balance(":-)".toList))
  }

  test("Counting is not enough.") {
    assert(!balance("())(".toList))
  }
  
  test("No Brackets at all is also balanced 1") {
    assert(balance("".toList))
  }

  test("No Brackets at all is also balanced 2") {
    assert(balance("This is a test without brackets".toList))
  }

  test("Counting is not enough 1.") {
    assert(!balance("Test (is) ( a test()".toList))
  }

  test("Counting is not enough 2.") {
    assert(balance("()()".toList))
  }

  test("Counting is not enough 3.") {
    assert(balance("()()(())".toList))
  }

  test("Counting is not enough 4.") {
    assert(balance("(())((()))".toList))
  }

  test("Counting is not enough 5.") {
    assert(!balance(")()()".toList))
  }

  test("Counting is not enough 6.") {
    assert(!balance("()(())()())".toList))
  } 

  test("Counting is not enough 7.") {
    assert(!balance(")()()(".toList))
  } 

  test("Counting is not enough 8.") {
    assert(!balance("(()))()(".toList))
  }

  test("Counting is not enough 9.") {
    assert(!balance("))((".toList))
  }

  test("Counting is not enough 10.") {
    assert(balance("()()(())".toList))
  }

  test("Counting is not enough 11.") {
    assert(!balance(")))(((".toList))
  }

  test("Counting is not enough 12.") {
    assert(!balance("()))()()".toList))
  }

  test("Counting is not enough 13.") {
    assert(!balance("()()(()))(".toList))
  }

  test("Counting is not enough 14.") {
    assert(balance("(((())))".toList))
  }

  test("Counting is not enough 15.") {
    assert(!balance("()()()())()(".toList))
  }

  test("Counting is not enough 16.") {
    assert(balance("()()(())".toList))
  }

  test("Counting is not enough 17.") {
    assert(balance("((((()()()))))".toList))
  }

  test("Counting is not enough 18.") {
    assert(!balance("(((((()()())()".toList))
  }

  test("Counting is not enough 19.") {
    assert(balance("()".toList))
  }

  test("Counting is not enough 20.") {
    assert(balance("()(())".toList))
  }

  test("Spaces in the text should also work.") {
    assert(balance("Who would give brackets like this? But even then it works and not sucks! ()(())".toList))
  }

  test("Pretty heavy use of brackets 1.") {
    assert(balance("(())()((()))()(())(())(())()()()((()))(())()()(((())))".toList))
  }

  test("Pretty heavy use of brackets 2.") {
    assert(balance("()()(())(())()()()(((()()(())(()()))))(())()()(((())))()()()()()()".toList))
  }

  test("Odd numbered bracket count is alwaya a fail 1.") {
    assert(!balance("()(".toList))
  }

  test("Odd numbered bracket count is alwaya a fail 2.") {
    assert(!balance("()()(())(())()())".toList))
  }
}
