package simulator.model;

import simulator.misc.Vector2D;

public class StationaryBody extends Body{

	public StationaryBody(String id, String gid, Vector2D velocity, Vector2D force, Vector2D position, double mass) {
		super(id, gid, velocity, force, position, mass);
		
	}

	@Override
	void advance(double dt) {
		
		
	}

}
