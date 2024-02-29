package virus_scanner;

import state.UserPremiumOff;
import state.UserPremiumOn;
import state.UserState;

public class User {
		private UserState state;

	    public User() {
	       this.setState(new UserPremiumOff(this));
	    }


		public UserState getState() {
			return state;
		}

		public void setState(UserState state) {
			this.state = state;
		}

	
		    public String printStatus() {
		        if (this.getState() instanceof UserPremiumOn) {
		            return "Premium";
		        } else {
		            return "Free";
		        }
		    }
		
	    
	    
}
