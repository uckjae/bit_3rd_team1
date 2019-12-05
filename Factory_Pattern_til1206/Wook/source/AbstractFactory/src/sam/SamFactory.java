package sam;

import abs.BikeFactory;
import abs.Body;
import abs.Wheel;

public class SamFactory implements BikeFactory{

	@Override
	public Body createBody() {
		// TODO Auto-generated method stub
		return new SamBody();
	}

	@Override
	public Wheel createWheel() {
		// TODO Auto-generated method stub
		return new SamWheel();
	}

}
