package simulator.factories;

import org.json.JSONObject;

import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<NewtonUniversalGravitation>{

	public NewtonUniversalGravitationBuilder(String typeTag, String desc) {
		super(typeTag, desc);
	}

	@Override
	protected NewtonUniversalGravitation createInstance(JSONObject data) {
		return null;
	}

}
