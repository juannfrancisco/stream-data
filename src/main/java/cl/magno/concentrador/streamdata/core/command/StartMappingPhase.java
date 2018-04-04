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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cl.magno.concentrador.streamdata.core.phase.mapping.MappingStage;


/**
 * Kuvasz Solutions 
 * @author Juan Francisco Maldonado León
 * @since 04-07-2016 20:43:33
 */
public class StartMappingPhase  extends CommandExecution{

	@Override
	public void execute() {
		
		ExecutorService ex = Executors.newFixedThreadPool(1);
		MappingStage mapping = new MappingStage(this.getFlujo());
		mapping.setnThreadsMapping(2);
		ex.execute(mapping);
		ex.shutdown();
		
	}

}
