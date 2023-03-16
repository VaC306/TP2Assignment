package simulator.model;


import simulator.misc.Vector2D;

public class MovingBody extends Body{
	
	public MovingBody(String id, String gid, Vector2D position, Vector2D velocity, double mass) {
		super(id, gid, position, velocity, mass);
	}
	
	@Override
    public void advance(double dt) {
	
	Vector2D a;
		// If mass is 0, do not move the body. Move it with a = 0,0
        if (getMass() == 0) {
            a = new Vector2D();
        }
        else
        {
        	// Compute acceleration
            a = getForce().scale(1 / getMass());
        }
        
        // Compute new position and velocity
        Vector2D newPos = getPosition().plus(getVelocity().scale(dt)).plus(a.scale(0.5 * dt * dt));
        Vector2D newVel = getVelocity().plus(a.scale(dt));

        // Update position and velocity
        setPosition(newPos);
        setVelocity(newVel);
        
    }
		
	private void setPosition(Vector2D newPos) {
		this.position = newPos;
	}
	
	private void setVelocity(Vector2D newVel) {
		this.velocity = newVel;
	}
		
}
