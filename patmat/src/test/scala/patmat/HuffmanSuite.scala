package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("charCount") {
    val data = times(List('a', 'a', 'b', 'a'))
    assert(data === List(('a', 3), ('b', 1)), "charCount")
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 2), Leaf('t', 2), Leaf('x', 3))
    assert(combine(leaflist) === List(Leaf('x', 3), Fork(Leaf('e', 2), Leaf('t', 2), List('e', 't'), 4)))
  }

  test("until of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val untilList = until(singleton, combine)(leaflist)
    assert(untilList === List(Fork(Leaf('x', 4), Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), List('e', 't', 'x'), 7)))
  }

  test("Test the secret") {
    val secret = decodedSecret
    assert(secret === string2Chars("huffmanestcool"))
  }

  test("decode") {
    new TestTrees {
      val secret = decode(t1, List(0, 1))
      assert(secret === string2Chars("ab"))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and encode of secret is identity") {
    new TestTrees {
      assert(decode(frenchCode, encode(frenchCode)("huffmanestcool".toList)) === "huffmanestcool".toList)
    }
  }

  test("decode and quickEncode of secret is identity") {
    new TestTrees {
      assert(decode(frenchCode, quickEncode(frenchCode)("huffmanestcool".toList)) === "huffmanestcool".toList)
    }
  }
}
