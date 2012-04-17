/**
 * This file is part of Machine of Peano [ http://mosser.github.com/PeanoMachine/ ]
 *
 * Copyright (C) 2012-  SINTEF ICT
 * Contact: Sebastien Mosser <sebastien.mosser@sintef.no>
 *
 * Module: net.modelbased.tools4se.peano.machine
 *
 * Machine of Peano is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Machine of Peano is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General
 * Public License along with Machine of Peano. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package net.modelbased.tools4se.peano.machine



class Faulty extends MachineOFPeano {
  def isZero(n: Int): Boolean = { throw new RuntimeException("Not yet Implemented") }
  def pred(n: Int): Int = { throw new RuntimeException("Not yet Implemented") }
  def succ(n: Int): Int = { throw new RuntimeException("Not yet Implemented") }
  def add(a: Int, b: Int): Int = { throw new RuntimeException("Not yet Implemented") }
  def mult(a: Int, b: Int): Int = { throw new RuntimeException("Not yet Implemented") }
}

class Recursive extends MachineOFPeano {
  
  def isZero(n: Int): Boolean = (0 == n) 
  
  def pred(n: Int): Int = { require(n > 0,"Out of domain!"); (n - 1) }
  
  def succ(n: Int): Int = { require(n >= 0, "Out of domain!");  (n + 1) }
  
  def add(a: Int, b: Int): Int = { 
    require(a >= 0, "Out of domain!")
    require(b >= 0, "Out of domain!")
    if (isZero(b)) a else add(succ(a),pred(b))
  }
  
  def mult(a: Int, b: Int): Int = {
    require(a >= 0, "Out of domain!")
    require(b >= 0, "Out of domain!")
    if (isZero(b)) 0 else add(a, mult(a, pred(b)))
  }
  
}

