package simulator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator {
	
	private double timePerStep;
    private ForceLaws defaultForceLaws;
    private Map<String, BodiesGroup> groups;
    private double currentTime;
	
    public PhysicsSimulator(double timePerStep, ForceLaws defaultForceLaws) {
        if (timePerStep <= 0) {
            throw new IllegalArgumentException("Time per step must be positive.");
        }
        if (defaultForceLaws == null) {
            throw new IllegalArgumentException("Default force laws cannot be null.");
        }
        this.timePerStep = timePerStep;
        this.defaultForceLaws = defaultForceLaws;
        this.groups = new HashMap<>();
        this.currentTime = 0.0;
    }
	
    public void advance() {
        if (timePerStep < 0) {
            throw new IllegalArgumentException("Time per step cannot be negative.");
        }
        for (BodiesGroup group : groups.values()) {
            group.advance(timePerStep);
        }
        currentTime += timePerStep;
    }
	
    public void addGroup(String id) {
        if (groups.containsKey(id)) {
            throw new IllegalArgumentException("Group " + id + " already exists.");
        }
        groups.put(id, new BodiesGroup(id, defaultForceLaws));
    }
	
	public void addBody(Body b)
	{
		BodiesGroup group = groups.get(b.getgId());
        if (group == null) {
            throw new IllegalArgumentException("Group " + b.getgId() + " does not exist.");
        }
        group.addBody(b);
	}
	
	public void setForceLaws(String id, ForceLaws fl)
	{
		 BodiesGroup group = groups.get(id);
	        if (group == null) {
	            throw new IllegalArgumentException("Group " + id + " does not exist.");
	        }
	        group.setForceLaws(fl);
	}
	
	public JSONObject getState() {
        JSONObject state = new JSONObject();
        state.put("time", currentTime);
        List<String> groupIds = new ArrayList<>(groups.keySet());
        JSONArray groupsArray = new JSONArray();
        for (String groupId : groupIds) {
            BodiesGroup group = groups.get(groupId);
            groupsArray.put(group.getState());
        }
        state.put("groups", groupsArray);
        return state;
    }
	
	@Override
    public String toString() {
        return getState().toString();
    }
	
	public void setDeltaTime(double dt)
	{
		this.timePerStep = dt;
	}
	
}
