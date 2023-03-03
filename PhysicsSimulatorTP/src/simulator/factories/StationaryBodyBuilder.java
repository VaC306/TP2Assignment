package simulator.factories;

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
        String id = info.getString("id");
        String gid = info.getString("gid");
        double mass = info.getDouble("mass");
        Vector2D position = new Vector2D(info.getJSONArray("position").getDouble(0), info.getJSONArray("position").getDouble(1));
        return new StationaryBody(id, gid, position, mass);
    }
}
