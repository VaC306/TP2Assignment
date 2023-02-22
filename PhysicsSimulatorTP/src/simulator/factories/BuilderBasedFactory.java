package simulator.factories;

import java.util.ArrayList;
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
	
	/*
	public class BodyBuilder implements Builder<Body> {
	    @Override
	    public Body createInstance(JSONObject info) {
	        String id = info.getString("id");
	        double mass = info.getDouble("mass");
	        Vector2D position = new Vector2D(info.getJSONArray("pos").getDouble(0), info.getJSONArray("pos").getDouble(1));
	        Vector2D velocity = new Vector2D(info.getJSONArray("vel").getDouble(0), info.getJSONArray("vel").getDouble(1));
	        Vector2D acceleration = new Vector2D(info.getJSONArray("acc").getDouble(0), info.getJSONArray("acc").getDouble(1));
	        return new Body(id, mass, position, velocity, acceleration);
	    }
	}
	*/
	
	
	@Override
	public List<JSONObject> getInfo() {
	    List<JSONObject> infoList = new ArrayList<>();
	    for (Builder<T> builder : builders) {
	        infoList.add(builder.getInfo());
	    }
	    return infoList;
	}
	
	void addBuilder(Builder<T> b)
	{
		
	}

}
