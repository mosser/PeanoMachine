package net.modelbased.tools4se.peano.client

import net.modelbased.tools4se.peano.machine._


trait Factorial extends MachineOFPeano {
  def fac(n: Int): Int = {
    if (isZero(n)) 1 else mult(n, fac(pred(n)))
  }
}

object Main extends App {
  
  val machine = new Recursive() with Factorial

  println("5! = " + machine.fac(5))
  
}
