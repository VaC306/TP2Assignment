package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MovingBody;
import simulator.model.StationaryBody;

public class MovingBodyBuilder extends Builder<Body>{
	
	public MovingBodyBuilder() {
		
		super("mv_body", "a");
	}

	public MovingBodyBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
    public MovingBody createInstance(JSONObject info) {
		//info is valid and has everything we need
		if(info == null || !info.has("id") || !info.has("gid") || !info.has("p") || !info.has("v") ||  !info.has("m")) 
		{	
			throw new IllegalArgumentException();
		}
				
		//se localizan los arrays
		JSONArray arrayp = info.getJSONArray("p");
		JSONArray arrayv = info.getJSONArray("v");
				
		//make sure its 2D vectors
		if(arrayp.length()!=2 || arrayv.length()!=2 ) 
		{			
			throw new IllegalArgumentException();
		}

		//creation  of vector
		Vector2D p = new Vector2D (arrayp.getDouble(0), arrayp.getDouble(1));
		Vector2D v =  new Vector2D (arrayv.getDouble(0), arrayv.getDouble(1));
				
						
		return new MovingBody(info.getString("id"), info.getString("gid"), p, v, info.getDouble("m") );
    }
	
}
