import abs.BikeFactory;
import abs.Body;
import abs.Wheel;
import gt.GtFactory;
import sam.SamFactory;

public class Main {

	public static void main(String[] args) {
		BikeFactory factory = new SamFactory();
		Body body = factory.createBody();
		Wheel wheel = factory.createWheel();
		
		factory = new GtFactory();
		body = factory.createBody();
		wheel = factory.createWheel();
	}

}
