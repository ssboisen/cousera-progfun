package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c < 0 || r < 0) throw new IllegalArgumentException()
    if(c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def balanceIter (char: Char, chars : List[Char], count : Int) : Boolean =
      if(count < 0) {
        false
      }
      else  {
        	(char, chars.isEmpty) match {
        		case ('(', false) => balanceIter(chars.head, chars.tail, count + 1)
        		case ('(', true) => false
        		case (')', false) => balanceIter(chars.head, chars.tail, count - 1)
        		case (')', true) => count - 1 == 0
        		case (_, false) => balanceIter(chars.head, chars.tail, count)
        		case _ => count == 0
        	}
      }
    if (chars.isEmpty) true else balanceIter(chars.head, chars.tail, 0)
  }
    

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if(money == 0) 1 
    else if (money < 0) 0 
    else if(coins.isEmpty && money > 0) 0 
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
}
