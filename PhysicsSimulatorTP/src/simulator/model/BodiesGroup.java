package simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class BodiesGroup {
	
	private String id;
	private ForceLaws forceLaws;
	List<Body> bodies;
	
	 BodiesGroup(String id, ForceLaws forceLaws) 
	 {
		 if (id == null || forceLaws == null || id.trim().length() == 0) 
		 {
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
	
	void addBody(Body body)
	{
		if (body == null) //creo que borrar esto
		{
            throw new IllegalArgumentException("Invalid null body");
        }
//		if (bodies.contains(body))
		for(Body b: bodies ) 
		{
			if(b.equals(body)) //usar contains or equal
				throw new IllegalArgumentException("Invalid body: Body's id is already in use");
		}
        this.bodies.add(body);
	}
	
	void advance(double dt)
	{
		if (dt <= 0) {
            throw new IllegalArgumentException("Invalid time step");
        }
        for (Body body : bodies) 
        {
            body.resetForce();
        }
        
        forceLaws.apply(bodies);
                
        for (Body body : bodies) 
        	
        {
            body.advance(dt);
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
		return getState().toString();
	}
	
}
