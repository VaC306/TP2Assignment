package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.StationaryBody;

public class StationaryBodyBuilder extends Builder<StationaryBody> {
	
	
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
        Vector2D velocity = new Vector2D(info.getJSONArray("velocity").getDouble(0), info.getJSONArray("velocity").getDouble(1));
        Vector2D position = new Vector2D(info.getJSONArray("position").getDouble(0), info.getJSONArray("position").getDouble(1));
        return new StationaryBody(id, gid, velocity, position, mass);
    }
}
