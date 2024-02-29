package state;

import virus_scanner.User;

public class UserPremiumOn extends UserState {

	public UserPremiumOn(User user) {
		super(user);
		
	}

	@Override
	public void premiumOn() {
		System.out.println("User already has premium access");
		
	}

	@Override
	public void premiumOff() {
		user.setState(new UserPremiumOff(user));
	}

}
