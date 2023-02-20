package simulator.model;

import simulator.misc.Vector2D;

public class MovingBody extends Body{

	public MovingBody(String id, String gid, Vector2D velocity, Vector2D force, Vector2D position, double mass) {
		super(id, gid, velocity, force, position, mass);
	}
	
	@Override
    public void advance(double dt) {
        // If mass is 0, do not move the body
        if (getMass() == 0) {
            return;
        }

        // Compute acceleration
        Vector2D a = getForce().scale(1 / getMass());

        // Compute new position and velocity
        Vector2D newPos = getPosition().plus(getVelocity().scale(dt)).plus(a.scale(0.5 * dt * dt));
        Vector2D newVel = getVelocity().plus(a.scale(dt));

        // Update position and velocity
        setPosition(newPos);
        setVelocity(newVel);

        // Reset force
        resetForce();
    }

	private void setPosition(Vector2D newPos) {
		this.position = newPos;
		
	}
	
	private void setVelocity(Vector2D newVel) {
		this.velocity = newVel;
		
	}

}
