package simulator.model;

public class PhysicsSimulator {
	
	private double RealTimePerStep;
	private ForceLaws DefaultForceLaws;
	
	public PhysicsSimulator(double realTimePerStep, ForceLaws defaultForceLaws) {
		super();
		RealTimePerStep = realTimePerStep;
		DefaultForceLaws = defaultForceLaws;
	}
	
	public void advance()
	{
		
	}
	
	public void addGroup(String id)
	{
		
	}
	
	public void addBody(Body b)
	{
		
	}
	
	public void setForceLaws(String id, ForceLaws fl)
	{
		
	}
	
	public JSONObject getState()
	{
		
	}
	
}
