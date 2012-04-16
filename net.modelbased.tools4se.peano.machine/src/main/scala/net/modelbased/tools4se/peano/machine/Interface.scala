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

abstract trait AxiomsOfPeano {

  def isZero(n: Integer): Boolean
  def pred(n: Integer): Integer
  def succ(n: Integer): Integer
 
}

abstract trait OperationsOfPeano extends AxiomsOfPeano {
  def add(a: Integer, b: Integer): Integer
  def mult(a: Integer, b: Integer): Integer
}

trait MachineOFPeano extends AxiomsOfPeano with OperationsOfPeano

