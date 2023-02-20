package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws{

	 private Vector2D c;
	 private double g;

	 public MovingTowardsFixedPoint(Vector2D c, double g) {
		 if (c == null || g <= 0) {
			 throw new IllegalArgumentException("Invalid parameters for MovingTowardsFixedPoint");
	     }
	     this.c = c;
	     this.g = g;
	    }

	    @Override
	    public void apply(List<Body> bodies) {
	        for (Body b : bodies) {
	            Vector2D direction = c.minus(b.getPosition()).direction();
	            double magnitude = b.getMass() * g;
	            Vector2D force = direction.scale(magnitude);
	            b.addForce(force);
	        }
	    }

}
