package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
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
        
        //we add each group
        for (Object g: groups) {
            String groupId = g.toString();
            ps.addGroup(groupId);
        }
        
        if(jsonInput.has("laws")) {
			//laws array
			JSONArray laws= jsonInput.getJSONArray("laws");	
		
			//we add the laws
			for(int i=0;i<laws.length();++i) {

				//id and info for the factory
				ps.setForceLaws(laws.getJSONObject(i).getString("id"), fl.createInstance(laws.getJSONObject(i).getJSONObject("laws")));
			}
		}
		
		JSONArray bodies = jsonInput.getJSONArray("bodies");
		
		for(int i=0; i < bodies.length();i++) {
			
			ps.addBody(fb.createInstance(bodies.getJSONObject(i)));
		}
	}
	
	public void run(int n, OutputStream out)
	{
		PrintStream p = new PrintStream(out);

	    // Add initial state
		p.println("{");
		p.println("\"states\": [");

		p.print(ps.getState());

	    // Run simulation
	    for(int i = 0; i < n; i++) 
	    {
			ps.advance();
			p.print(", ");
			p.print(ps.getState());
		}
	    // Write output to stream
	    p.println("]");
	    p.println("}");
	 }
}
