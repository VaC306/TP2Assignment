package simulator.model;

import java.util.List;

import org.json.JSONObject;

public class BodiesGroup {
	
	private String id;
	private ForceLaws force;
	List<Body> lb;
	
	public BodiesGroup()
	{
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
	
	void advance(double dt)
	{
		
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
