package cl.magno.concentrador.model;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class TrxObject implements Serializable
{ 
	private static final long serialVersionUID = -5618821853731823752L;
	private transient static final Logger LOGGER = Logger.getLogger( TrxObject.class );
	private Long oid = 0l;
	private String name = "";
	private Map<String,Object> core = null; 
	 
	private static Gson gsrv = new Gson();
	
	private String strCore = null;

	public Long getOid() 
	{
		return oid;
	}

	public void setOid(Long oid) 
	{
		this.oid = oid;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Map<String, Object> getCore() 
	{
		if (core == null) {
			core = new LinkedHashMap<String, Object>();
		}
		
		return core;
	}
 
	public Map<String, Object> getCoreNotNull() 
	{
		Map<String, Object> noNull = new LinkedHashMap<String, Object>();
		
		for ( Entry<String, Object> en : core.entrySet() ) 
		{
			if (en.getValue()!=null && !en.getValue().toString().equals("") ) 
			{
				noNull.put(en.getKey(),en.getValue());
			}			
		}
		return noNull;
	}

	public void setCore(Map<String, Object> core) 
	{
		this.core = core;
	}
	
	/**
	 * @param name
	 * @return
	 */
	
	
	@SuppressWarnings("unchecked")
	public Object getAttribute(String name)
	{
		if (this.getStrCore()!=null) { 
			Map<String,Object> m = gsrv.fromJson(this.getStrCore(), Map.class);
			Object o = m.get(name);
			m.clear();  
			return o;
		}
		return this.getCore().get(name);
	}
	
	/**
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAttributeString(String name)
	{
		try
		{
			Map<String,Object> m = null; 
			if (this.getStrCore()!=null) { 
				m = gsrv.fromJson(this.getStrCore(), Map.class);  
			} else
			{
				m = this.getCore();
			}
			Object result = m.get(name);
			return result != null ? result.toString() : "";
		}
		catch (Exception e)
		{ 
			return "";
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Integer getAttributeInteger(String name)
	{
		try
		{
			Map<String,Object> m = null; 
			if (this.getStrCore()!=null) { 
				m = gsrv.fromJson(this.getStrCore(), Map.class);  
			} else
			{
				m = this.getCore();
			}
			Object result = m.get(name);
			return (result != null && !result.equals("")) ? Integer.parseInt( result.toString() ) : 0;
		}
		catch (Exception e)
		{
			LOGGER.error( "ERROR AL CONVERTIR EL ATRIBUTO " + name + " A INTEGER", e );
			return 0;
		}
	}

	/**
	 * @param atrabuteName
	 * @param result
	 */
	public void setAttribute(String atrabuteName, Object result) 
	{ 
		this.getCore().put(atrabuteName, result);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String map = "";
		try 
		{
			map = this.getCore().toString();
		}
		catch (Exception e) 
		{
			LOGGER.error( "ERROR AL CONVERTIR A STRING EL OBJETO TRX OBJECT" );
		}
		return map;
	}

	public String getStrCore() {
		return strCore;
	}

	public void setStrCore(String strCore) {
		this.strCore = strCore;
	}
}
