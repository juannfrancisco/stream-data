/*
 * Copyright 2010-2016 Magno Labs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cl.magno.concentrador.streamdata.core.command;

import cl.magno.stream.core.model.flow.Flow;

/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 04-07-2016 20:36:51
 */
public abstract class CommandExecution {
	
	private Flow flujo;
	
	public abstract void execute();
	
	/**
	 * 
	 */
	public CommandExecution(){
		this.flujo = null;
	}
	
	/**
	 * 
	 * @param flujo
	 */
	public CommandExecution( Flow flujo ){
		this.setFlujo(flujo);
	}
	
	
	/**
	 * @return the flujo
	 */
	public Flow getFlujo() {
		return flujo;
	}
	/**
	 * @param flujo the flujo to set
	 */
	public void setFlujo(Flow flujo) {
		this.flujo = flujo;
	}

}
