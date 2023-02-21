package simulator.model;

import java.util.List;

public class NoForce implements ForceLaws{

	@Override
	public void apply(List<Body> bs) {
		//This method should be empty
	}
	
	public String toString() {
	    return "No Force\n";
	}
}
