package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingBody;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws>{
	
	public MovingTowardsFixedPointBuilder() 
	{
		super("mtfp", "b");
	}
	
	public MovingTowardsFixedPointBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
	protected MovingTowardsFixedPoint createInstance(JSONObject data) {
		 Vector2D c = new Vector2D(data.getJSONArray("c").getDouble(0), data.getJSONArray("c").getDouble(1));
		 double g = data.getDouble("g");
        return new MovingTowardsFixedPoint(c, g);
	}
	
	
}
