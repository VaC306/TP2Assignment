package simulator.factories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MovingBody;
import simulator.model.MovingTowardsFixedPoint;
import simulator.model.NewtonUniversalGravitation;

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
	  		throw new IllegalArgumentException("Invalid value for createInstance:null");
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
	    
	   /*switch (type) {
	        case "Body":
	            String id = data.getString("id");
	            String gid = data.getString("gid");
	            double mass = data.getDouble("mass");
	            JSONObject posData = data.getJSONObject("position");
	            Vector2D position = new Vector2D(posData.getDouble("x"), posData.getDouble("y"));
	            JSONObject velData = data.getJSONObject("velocity");
	            Vector2D velocity = new Vector2D(velData.getDouble("x"), velData.getDouble("y"));
	            JSONObject forceData = data.getJSONObject("force");
	            Vector2D force = new Vector2D(forceData.getDouble("x"), forceData.getDouble("y"));
	            return (T) new Body(id, gid , velocity, force, position, mass);
	        case "MovingBody":
	        	String idb = data.getString("id");
	            String gidb = data.getString("gid");
	            double massb = data.getDouble("mass");
	            JSONObject posDatab = data.getJSONObject("position");
	            Vector2D positionb = new Vector2D(posData.getDouble("x"), posData.getDouble("y"));
	            JSONObject velDatab = data.getJSONObject("velocity");
	            Vector2D velocityb = new Vector2D(velData.getDouble("x"), velData.getDouble("y"));
	            JSONObject forceDatab = data.getJSONObject("force");
	            Vector2D forceb = new Vector2D(forceData.getDouble("x"), forceData.getDouble("y"));
	            return (T) new MovingBody(id, gid , velocity, force, position, mass);
	        case "MovingTowardsFixedPoint":
	            JSONObject cData = data.getJSONObject("c");
	            Vector2D c = new Vector2D(cData.getDouble("x"), cData.getDouble("y"));
	            double g = data.getDouble("g");
	            return (T) new MovingTowardsFixedPoint(c, g);
	        case "NewtonUniversalGravitation":
	            double G = data.getDouble("G");
	            return (T) new NewtonUniversalGravitation(G);
	        default:
	            throw new IllegalArgumentException("Invalid object type: " + type);
	    }*/
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
