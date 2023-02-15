package simulator.model;

import java.util.List;
import simulator.misc.Vector2D;
import org.json.JSONObject;

public class BodiesGroup extends Body{
	
	private String id;
	private ForceLaws force;
	List<Body> lb;
	
	public BodiesGroup()
	{
		super(id, id, position, force, position, mass); //verse esto
		//rellenar
	}
	
	public String getId()
	{
		return this.id;
	}
	
	void setForceLaws(ForceLaws fl)
	{
		this.force = fl;
	}
	
	void addBody(Body b)
	{
		
	}
	
	@Override
	void advance(double dt)
	{
		for(Body b: lb) //llamar al resetForce de cada body
		{
			b.resetForce();
		}
		//rellenar
	}
	
	public JSONObject getState()
	{
		return null;
		//rellenar
	}
	
	public String toString() 
	{
		return "";
	}
	
}
