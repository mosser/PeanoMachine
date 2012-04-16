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
package net.modelbased.tools4se.peano.machine.tests

import org.specs2.mutable._
import org.specs2.matcher.DataTables
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

import net.modelbased.tools4se.peano.machine._

@RunWith(classOf[JUnitRunner])
class OperationTest extends SpecificationWithJUnit with DataTables {

  "Specifications for the Axioms of Peano".title
  
  //val mop: MachineOFPeano = new Faulty()
  val mop: MachineOFPeano = new Recursive()
  
  "add" should {
    "reject a negative input [a]" in { 
      mop.add(-1,0) must throwAn[IllegalArgumentException] 
    }
    "reject a negative input [b]" in { 
      mop.add(0,-1) must throwAn[IllegalArgumentException] 
    }
    "implement integer addition" in {
      "a" | "b" | "r" |
       0  !  0  !  0  |
       0  !  1  !  1  |
       1  !  0  !  1  |
       1  !  1  !  2  |> { (a, b, r) => mop.add(a,b) must_== r}
     }
  }
  
  "mult" should {
    "reject a negative input [a]" in { 
      mop.mult(-1,0) must throwAn[IllegalArgumentException] 
    }
    "reject a negative input [b]" in { 
      mop.mult(0,-1) must throwAn[IllegalArgumentException] 
    }
    "implement integer multiplication" in {
      "a" | "b" | "r" |
       0  !  0  !  0  |
       0  !  1  !  0  |
       1  !  0  !  0  |
       1  !  1  !  1  |> { (a, b, r) => mop.mult(a,b) must_== r}
     }
  }
}