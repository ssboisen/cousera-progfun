package objsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GoogleVsAppleSuite extends FunSuite {
  test("googletweets") {
    GoogleVsApple.trending.foreach(tweet => println(tweet.toString())) 
  }
}
