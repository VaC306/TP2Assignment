package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.StationaryBody;

public class StationaryBodyBuilder extends Builder<Body> {
	
	
	public StationaryBodyBuilder () 
	{
		super("st_body", "a");
	}
	
	public StationaryBodyBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
    public StationaryBody createInstance(JSONObject info) {
		//make sure the input is valid
		if(info == null || !info.has("id")|| !info.has("gid")|| !info.has("p") || !info.has("m")) {
					
			throw new IllegalArgumentException("Invalid input");
		}
			
		JSONArray arrayp = info.getJSONArray("p");

		if(arrayp.length()!=2  ) 
		{		
			throw new IllegalArgumentException();
		}

		//creation of thge Vector2D
		Vector2D p = new Vector2D (arrayp.getDouble(0), arrayp.getDouble(1));
				
		return new StationaryBody(info.getString("id"), info.getString("gid"), p, info.getDouble("m") );
		}
  }

