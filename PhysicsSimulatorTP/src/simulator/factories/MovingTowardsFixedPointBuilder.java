package simulator.factories;

import org.json.JSONArray;
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
		//if input is null
		if(data == null) 
		{
			throw new IllegalArgumentException("Invalid input: parameter cannot be null.");
		}
		
		Vector2D c = new Vector2D();
		if(	data.has("c")) {
			//we find it in the array
			JSONArray arrayC =data.getJSONArray("c");
		
			//we get the values of x and y
			c = new Vector2D (arrayC.getDouble(0), arrayC.getDouble(1));
		}
		
		//default value
		double g=9.81;
		//if theres a g given we take that one
		if(data.has("g"))
		{		
			g=data.getDouble("g");
		}
        return new MovingTowardsFixedPoint(c, g);
	}
	
	
}
