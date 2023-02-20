package simulator.model;

import java.util.ArrayList;
import java.util.List;
import simulator.misc.Vector2D;

import org.json.JSONArray;
import org.json.JSONObject;

public class BodiesGroup {
	
	private String id;
	private ForceLaws forceLaws;
	List<Body> bodies;
	
	 BodiesGroup(String id, ForceLaws forceLaws) {
	        if (id == null || forceLaws == null || id.trim().length() == 0) {
	            throw new IllegalArgumentException("Invalid arguments");
	        }
	        this.id = id;
	        this.forceLaws = forceLaws;
	        this.bodies = new ArrayList<>();
	    }
	
	public String getId()
	{
		return this.id;
	}
	
	void setForceLaws(ForceLaws fl)
	{
		if (fl == null) 
		{
			throw new IllegalArgumentException("Invalid force laws");
	    }
	    this.forceLaws = fl;
	}
	
	void addBody(Body b)
	{
		if (b == null || bodies.contains(b) || bodies.stream().anyMatch(body -> body.equals(b))) {
            throw new IllegalArgumentException("Invalid body");
        }
        this.bodies.add(b);
	}
	
	void advance(double dt)
	{
		if (dt <= 0) {
            throw new IllegalArgumentException("Invalid time step");
        }
        for (Body body : bodies) {
            body.resetForce();
        }
        forceLaws.apply(bodies);
        for (Body body : bodies) {
            body.advance(dt); //ver
        }
	}
	
	public JSONObject getState()
	{
		 JSONObject state = new JSONObject();
	        state.put("id", id);
	        JSONArray bodiesJson = new JSONArray();
	        for (Body body : bodies) {
	            bodiesJson.put(body.getState());
	        }
	        state.put("bodies", bodiesJson);
	        return state;
	}
	
	@Override
	public String toString() 
	{
		return "";
	}
	
}
