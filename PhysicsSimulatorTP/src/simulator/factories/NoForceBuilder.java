package simulator.factories;

import org.json.JSONObject;

import simulator.model.NoForce;

public class NoForceBuilder extends Builder<NoForce>{

	public NoForceBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
	protected NoForce createInstance(JSONObject data) {
		return null;
	}

}
