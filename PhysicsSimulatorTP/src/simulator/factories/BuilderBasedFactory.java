package simulator.factories;

import java.util.List;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MovingTowardsFixedPoint;
import simulator.model.NewtonUniversalGravitation;

public class BuilderBasedFactory<T> implements Factory{
	
	List<Builder<T>> builders;
	
	public BuilderBasedFactory()
	{
		
	}
	
	public BuilderBasedFactory(List<Builder<T>> builders)
	{
		 this.builders = builders;
	}
	
	@Override
	public T createInstance(JSONObject info){
	    String type = info.getString("type");
	    JSONObject data = info.getJSONObject("data");

	    switch (type) {
	        case "Body":
	            String id = data.getString("id");
	            double mass = data.getDouble("mass");
	            JSONObject posData = data.getJSONObject("pos");
	            Vector2D position = new Vector2D(posData.getDouble("x"), posData.getDouble("y"));
	            JSONObject velData = data.getJSONObject("vel");
	            Vector2D velocity = new Vector2D(velData.getDouble("x"), velData.getDouble("y"));
	            JSONObject forceData = data.getJSONObject("force");
	            Vector2D force = new Vector2D(forceData.getDouble("x"), forceData.getDouble("y"));
	            return (T) new Body(id, mass, position, velocity, force);
	        case "MovingTowardsFixedPoint":
	            JSONObject cData = data.getJSONObject("c");
	            Vector2D c = new Vector2D(cData.getDouble("x"), cData.getDouble("y"));
	            double g = data.getDouble("g");
	            return (T) new MovingTowardsFixedPoint(c, g);
	        case "NewtonUniversalGravitation":
	            double G = data.getDouble("G");
	            return (T) new NewtonUniversalGravitation(G);
	        default:
	            throw new IllegalArgumentException("Invalid object type: " + type);
	    }
	}

	@Override
	public List getInfo() {
		
		return null;
	}
	
	void addBuilder(Builder<T> b)
	{
		
	}

}
