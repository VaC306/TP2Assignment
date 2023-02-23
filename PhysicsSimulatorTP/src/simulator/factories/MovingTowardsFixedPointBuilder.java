package simulator.factories;

import org.json.JSONObject;

import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<MovingTowardsFixedPoint>{

	public MovingTowardsFixedPointBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
	protected MovingTowardsFixedPoint createInstance(JSONObject data) {
		return null;
	}
	
	
}
