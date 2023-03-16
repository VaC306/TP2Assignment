package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws>{
	
	public NewtonUniversalGravitationBuilder() 
	{
		super("nlug", "a");
	}
	
	public NewtonUniversalGravitationBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
	protected NewtonUniversalGravitation createInstance(JSONObject data) {
		
		//default value
		double G=6.67E-11;
		
		if(data.has("G"))
		{
			G = data.getDouble("G");
		}
		
		return new NewtonUniversalGravitation(G);
	}

}
