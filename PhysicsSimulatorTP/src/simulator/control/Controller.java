package simulator.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.ForceLaws;
import simulator.model.PhysicsSimulator;

public class Controller {
	
	private PhysicsSimulator ps;
	private Factory<ForceLaws> fl;
	private Factory<Body> fb;
	
	public Controller(PhysicsSimulator ps, Factory<ForceLaws> fl, Factory<Body> fb) {
		this.ps = ps;
		this.fl = fl;
		this.fb = fb;
	}
	
	public void loadData(InputStream in)
	{
		JSONObject jsonInput = new JSONObject(new JSONTokener(in));

        // Add groups
        JSONArray groups = jsonInput.getJSONArray("groups");
        for (int i = 0; i < groups.length(); i++) {
            String groupId = groups.getString(i);
            ps.addGroup(groupId);
        }
	}
	
	public void run(int n, OutputStream out)
	{
		 JSONObject result = new JSONObject();
	        JSONArray states = new JSONArray();

	        // Add initial state
	        states.put(ps.getState());

	        // Run simulation
	        for (int i = 0; i < n; i++) {
	            ps.advance();
	            states.put(ps.getState());
	        }

	        result.put("states", states);

	        // Write output to stream
	        try {
				out.write(result.toString(2).getBytes());
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
}
