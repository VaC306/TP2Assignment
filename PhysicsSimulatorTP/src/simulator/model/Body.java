package simulator.model;
import org.json.JSONArray;
import org.json.JSONObject;
import simulator.misc.Vector2D;

public abstract class Body{
	
	protected String id;
	protected String gid;
	protected Vector2D velocity;
	protected Vector2D force;
	protected Vector2D position;
	protected double mass;
	
	Body(String id, String gid, Vector2D position, Vector2D velocity, double mass)
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
    this.force = new Vector2D();
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
	
	void addForce(Vector2D fuerza) {
		this.force = force.plus(fuerza);
	}
	
	public void resetForce() {
        this.force = new Vector2D();
    }
	
	abstract void advance (double dt);
	
	 public JSONObject getState() 
	 {

		JSONObject body = new JSONObject();
			
		JSONArray b1 = new JSONArray();
		b1.put(position.getX());
		b1.put(position.getY());
		body.put("p", b1);
			
		JSONArray b2 = new JSONArray();
		b2.put(velocity.getX());
		b2.put(velocity.getY());
		body.put("v", b2);
			
		JSONArray b3 = new JSONArray();
		b3.put(force.getX());
		b3.put(force.getY());
		body.put("f", b3);
			
		body.put("id", this.id);
		body.put("m", this.mass);		
			
		return body;
	 }
	
	
	public String toString()
	{
		return getState().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) 
	    {
	        return false;
	    }
	    Body other = (Body) obj;
	    return id.equals(other.id);
	}
	
	@Override
	public int hashCode() {
	    int result = 17; // arbitrary prime number
	    result = 31 * result + id.hashCode();
	    result = 31 * result + gid.hashCode();
	    return result;
	}
}

