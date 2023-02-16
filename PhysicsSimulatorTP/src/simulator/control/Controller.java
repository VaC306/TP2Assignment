package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.ForceLaws;
import simulator.model.PhysicsSimulator;

public class Controller {
	
	public Controller(PhysicsSimulator ps, Factory<ForceLaws> fl, Factory<Body> fb) {
		
	}
	
	public void loadData(InputStream in)
	{
		JSONObject jsonInupt = new JSONObject(new JSONTokener(in));
		//addGroup
		
	}
	
	public void run(int n, OutputStream out)
	{
		
	}
	
}