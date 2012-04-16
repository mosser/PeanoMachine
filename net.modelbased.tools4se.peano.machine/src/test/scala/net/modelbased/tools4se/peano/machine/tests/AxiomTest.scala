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
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

import net.modelbased.tools4se.peano.machine._

@RunWith(classOf[JUnitRunner])
class AxiomTest extends SpecificationWithJUnit {
  "Specifications for the Axioms of Peano".title
  //val mop: MachineOFPeano = new Faulty()
  val mop: MachineOFPeano = new Recursive()
  "isZero?" should {
    "return true when receiving 0 as input" in  { mop.isZero(0) must beTrue  }
    "return false when receiving 1 as input" in { mop.isZero(1) must beFalse }
  }
  "succ" should {
    "return 1 when receiving 0 as input" in { mop.succ(0) must_== 1 }
    "reject a negative input" in { 
      mop.succ(-1) must throwAn[IllegalArgumentException](message = "Out of domain!") 
    }
  }
  "pred" should {
    "return 0 when receiving 1 as input" in { mop.pred(1) must_== 0 }
    "reject 0 as imput" in { 
      mop.pred(0) must throwAn[IllegalArgumentException](message = "Out of domain!") 
    }
    "reject a negative input" in { 
      mop.pred(-1) must throwAn[IllegalArgumentException](message = "Out of domain!") 
    }
  } 
}