package simulator.model;
import org.json.JSONObject;

import simulator.misc.Vector2D;

public abstract class Body {
	
	protected String id;
	protected String gid;
	protected Vector2D velocity;
	protected Vector2D force;
	protected Vector2D position;
	protected double mass;
	
	public Body(String id, String gid, Vector2D velocity, Vector2D force, Vector2D position, double mass) 
	{
		super();
		this.id = id;
		this.gid = gid;
		this.velocity = velocity;
		this.force = force;
		this.position = position;
		this.mass = mass;
	}
	
	if((this.id || this.gid || this.velocity || this.force || this.position || this.mass) == null)
	{
		//throw IllegalArgumentException;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String getgId()
	{
		return this.gid;
	}
	
	public Vector2D getVelocity()
	{
		return this.velocity;
	}
	
	public Vector2D getPosition()
	{
		return this.position;
	}
	
	public Vector2D getForce()
	{
		return this.force;
	}
	
	public double getMass()
	{
		return this.mass;
	}
	
	
	void addForce(Vector2D f)
	{
		this.force.plus(f);
	}
	
	void resetForce()
	{
		//ponerlo a 0, 0
	}
	
	abstract advance (double dt)
	{
		//move the body for dt seconds
	}
	
	public JSONObject getState()
	{
		
	}
	
	public String toString()
	{
		return getState().toString();
	}
	
}

