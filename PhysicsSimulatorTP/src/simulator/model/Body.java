package simulator.model;
import org.json.JSONObject;
import simulator.misc.Vector2D;

public abstract class Body{
	
	protected String id;
	protected String gid;
	protected Vector2D velocity;
	protected Vector2D force;
	protected Vector2D position;
	protected double mass;
	
	public Body(String id, String gid, Vector2D velocity, Vector2D force, Vector2D position, double mass)
	{
	super();
	 if (id == null || gid == null || velocity == null || position == null) {
         throw new IllegalArgumentException("Invalid input: parameters cannot be null.");
     }
     if (id.trim().length() == 0 || gid.trim().length() == 0) {
         throw new IllegalArgumentException("Invalid input: identifier or group identifier cannot be empty.");
     }
     if (mass <= 0) {
         throw new IllegalArgumentException("Invalid input: mass must be positive.");
     }
		
	this.id = id;
    this.gid = gid;
    this.velocity = velocity;
    this.position = position;
    this.mass = mass;
    this.force = new Vector2D(0, 0);
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
	
	public void resetForce() {
        this.force = new Vector2D(0, 0);
    }
	
	abstract void advance (double dt);
	
	 public JSONObject getState() {
	        JSONObject obj = new JSONObject();
	        obj.put("id", this.id);
	        obj.put("m", this.mass);
	        obj.put("p", this.position.toJSONArray()); //ver esta funcvion
	        obj.put("v", this.velocity.toJSONArray());
	        obj.put("f", this.force.toJSONArray());
	        return obj;
	    }
	
	public String toString()
	{
		return getState().toString();
	}
	
}
