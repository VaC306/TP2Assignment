package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.MovingBody;
import simulator.model.StationaryBody;

public class MovingBodyBuilder extends Builder<MovingBody>{
	
	public MovingBodyBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
    public MovingBody createInstance(JSONObject info) {
        String id = info.getString("id");
        String gid = info.getString("gid");
        double mass = info.getDouble("mass");
        Vector2D velocity = new Vector2D(info.getJSONArray("velocity").getDouble(0), info.getJSONArray("velocity").getDouble(1));
        Vector2D position = new Vector2D(info.getJSONArray("position").getDouble(0), info.getJSONArray("position").getDouble(1));
        Vector2D force = new Vector2D(info.getJSONArray("force").getDouble(0), info.getJSONArray("force").getDouble(1));
        return new MovingBody(id, gid, velocity, position, force, mass);
    }
	
}
