package simulator.model;

import simulator.misc.Vector2D;

public class StationaryBody extends Body{
	
	public StationaryBody(String id, String gid, Vector2D position, Vector2D velocity, double mass) {
		super(id, gid, position, position, new Vector2D(0, 0), mass);
	}
	
	@Override
	public void advance(double t) {
		// Stationary body does not move, so there is nothing to do here
	}
}
