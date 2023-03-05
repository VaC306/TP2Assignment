package simulator.factories;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T>{
	
	private Map <String,Builder<T>> builders;
	private List <JSONObject> buildersInfo;
	
	public BuilderBasedFactory()
	{
		//create HashMap and linked list
		builders = new HashMap<> ();
		buildersInfo = new LinkedList<>();
	}
	
	public BuilderBasedFactory(List<Builder<T>> builders)
	{
		//creation of hashmaps y lista
		this();
		// add builder for each builder
		for(Builder<T> b: builders) 
		{	
			addBuilder(b);
		}
	}
	
	@Override
	public T createInstance(JSONObject info){
	    
	  	if (info == null) 
	  	{
	  		throw new IllegalArgumentException("Invalid parameters");
	  	}
	  		
	  	//builder no tiene type, no se puede construir
	  	if(!builders.containsKey(info.getString("type")) ) 
	  	{		
	  		throw new IllegalArgumentException("Invalid value for createInstance: " + info.toString());	
	  	}

	  	JSONObject data;

	  	if(info.has("data")) 
	  	{
	  		data = info.getJSONObject("data");
	  	}
	  	else 
	  	{		
	  		data=new JSONObject();
	  	}
	  	
	  	return builders.get(info.getString("type")).createInstance(data);
	    
	}
	
	
	@Override
	public List<JSONObject> getInfo() {
		return Collections.unmodifiableList(buildersInfo);
	}
	
	void addBuilder(Builder<T> b)
	{
		builders.put(b.getTypeTag(), b); //we save the constructor type
		buildersInfo.add(b.getInfo()); // add b.getInfo () to buildersInfo
	}

}
