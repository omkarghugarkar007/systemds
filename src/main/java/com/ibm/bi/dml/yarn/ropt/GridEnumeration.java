/**
 * (C) Copyright IBM Corp. 2010, 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.ibm.bi.dml.yarn.ropt;

import java.util.ArrayList;

import com.ibm.bi.dml.hops.HopsException;
import com.ibm.bi.dml.runtime.DMLRuntimeException;
import com.ibm.bi.dml.runtime.controlprogram.ProgramBlock;

public abstract class GridEnumeration 
{
	
	protected ArrayList<ProgramBlock> _prog = null;
	protected long  _min = -1;
	protected long  _max = -1;

	public GridEnumeration( ArrayList<ProgramBlock> prog, long min, long max ) 
		throws DMLRuntimeException
	{
		if( min > max )
			throw new DMLRuntimeException("Invalid parameters: min=" + min + ", max=" + max);
		
		_prog = prog;
		_min = min;
		_max = max;
	}
	
	/**
	 * 
	 * @return
	 * @throws HopsException 
	 * @throws DMLException
	 */
	public abstract ArrayList<Long> enumerateGridPoints() 
		throws DMLRuntimeException, HopsException; 
}
