package todo

import scala.io.StdIn
import scala.util.{Try, Success, Failure}

object IOHelper:


  def promptUser(): Try[Unit] = Try {
    println("\n(Commands: a \"task\", d 1, u 1, h, q, v)")
    print("Yo: ")
  }


end IOHelper  
