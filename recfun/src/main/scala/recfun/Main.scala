package recfun

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
      if(c == 0 || r == c) 1
      else pascal(c, r-1) +
            pascal(c-1, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def checkParenBalance(chars: List[Char], openParen: Int): Boolean = {
        if(chars.isEmpty) {
          openParen == 0                            // arrived at end of string? then openParen must be 0 if balanced
        } else {
          val headChar = chars.head
          val open = if(headChar == '(') openParen + 1    // '(' --> increment openParen by 1
          else if (headChar == ')') openParen -1          // ')' --> decrement openParen by 1
          else openParen                                  // else do nothing
          if (open < 0 ) false                      // if '(' occurrence < ')' occurrence
          else checkParenBalance(chars.tail, open)
        }
      }
      checkParenBalance(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money <= 0) 0
      def sortedCountChange(money: Int, sortedCoins: List[Int]): Int = {
        if (sortedCoins.isEmpty || money - sortedCoins.head < 0) 0 //coins empty or if coins[0] is
        else if (money - sortedCoins.head == 0) 1
        else sortedCountChange(money, sortedCoins.tail) + sortedCountChange(money - sortedCoins.head, sortedCoins)
      }
      sortedCountChange(money, coins.sorted) //sort input coins array
    }
  }
