package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws{

	 private final double G;

	    public NewtonUniversalGravitation(double G) {
	        if (G <= 0) {
	            throw new IllegalArgumentException("Gravitational constant must be positive");
	        }
	        this.G = G;
	    }

	    @Override
	    public void apply(List<Body> bodies) {
	    	//hacer el bucle for each en vez
	        for (int i = 0; i < bodies.size(); i++) {
	    	//for(Body body: bodies)
	            Body bi = bodies.get(i);
	            for (int j = i + 1; j < bodies.size(); j++) {
	                Body bj = bodies.get(j);
	                Vector2D dij = bj.getPosition().minus(bi.getPosition());
	                
	                if(Math.pow(dij.magnitude(), 2) < 0)
	    	    		throw new IllegalArgumentException("dij has to be greater thar 0"); //verse que poner en esta excepcion
	                else
	                {
	                	double fi = G * bi.getMass() * bj.getMass() / Math.pow(dij.magnitude(), 2);
		                Vector2D fij = dij.direction().scale(fi);
		                bi.addForce(fij);
		                bj.addForce(fij.scale(-1));
	                }
	            }
	        }
	    }
	    
	    @Override
	    public String toString() {
	        return "Newton's Universal Gravitation Law (G = " + G + ")\n";
	    }
}
