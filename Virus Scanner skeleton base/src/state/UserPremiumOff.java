package state;

import virus_scanner.User;

public class UserPremiumOff extends UserState {

	public UserPremiumOff(User user) {
		super(user);
		
	}

	@Override
	public void premiumOn() {
		user.setState(new UserPremiumOn(user));
		
	}

	@Override
	public void premiumOff() {
		System.out.println("User is not eligible for premium services");
		
	}

}
