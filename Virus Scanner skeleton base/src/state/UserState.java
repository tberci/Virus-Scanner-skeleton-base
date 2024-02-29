package state;

import virus_scanner.BasicVirusScanner;
import virus_scanner.User;

public abstract class UserState {
	
	protected User user;

    public UserState(User user) {
        this.user = user;
    }
	
	public abstract void premiumOn();
    public abstract void premiumOff();
}
