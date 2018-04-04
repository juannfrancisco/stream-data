/**
 * 
 */
package cl.magno.concentrador.streamdata.core.notify;

import java.util.Map;

import cl.magno.concentrador.streamdata.core.notify.type.CommandStartExtract;
import cl.magno.concentrador.streamdata.core.notify.type.CommandStartMapping;
import cl.magno.concentrador.streamdata.core.notify.type.CommandStartSending;

/**
 * @author jmaldonado
 *
 */
public enum TYPE_NOTIFY {
	
	
	START_MAPPING  {
		@Override
		public void execute(Map<String, Object> data) {
			new CommandStartMapping().execute(data);
		}
	},
	START_EXTRACT {
		@Override
		public void execute(Map<String, Object> data) {
			new CommandStartExtract().execute(data);
		}
	},
	START_SENDING{
		@Override
		public void execute(Map<String, Object> data) {
			new CommandStartSending().execute(data);
		}
	};
	
	
	public abstract void execute(Map<String, Object> data);

}
