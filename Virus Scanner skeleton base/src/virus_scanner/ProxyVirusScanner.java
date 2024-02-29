package virus_scanner;

import java.util.List;

import scan_strategy.IntelligentScan;
import scan_strategy.ScanStrategy;
import state.UserPremiumOn;

public class ProxyVirusScanner implements VirusScanner {
	
    
	private BasicVirusScanner basicScanner;
	private User user;
	
  
   
    
    public ProxyVirusScanner(BasicVirusScanner service, User user) {
    	this.basicScanner = service;
    	this.user = user;

    }
    
    public boolean checkMemberShip() {
    	
        if (this.user.getState() instanceof UserPremiumOn ) {
 
            return true;

        } else  {
        	
        	System.out.println("Real time protection is off.");
        	return false;
        }
		
    }
  
    // A Valós Idejû Védelem aktiválása
    private void activateRealTimeProtection() {
        System.out.println("Real time protection activated");
        this.setProtection(true);
       
    }
  
	
	
	private void handleNonPremiumMemberScan(List<Virus> viruses) {
	    this.setProtection(false);

	    if (basicScanner.getScanStrategy() instanceof IntelligentScan) {
	        System.out.println("Free members can't acces this function.");
	       
	    }else {
	    	basicScanner.performFullScan(viruses);
	    }
	}
	
	
	private void handlePremiumMemberScan(List<Virus> viruses) {
	 
	    activateRealTimeProtection();
	    if (basicScanner.getScanStrategy() instanceof IntelligentScan) {
            basicScanner.performFullScan(viruses);
        } else {
            
            basicScanner.performFullScan(viruses);
        }
	}


	@Override
	public void performFullScan(List<Virus> viruses) {
	    
	 
	    if (checkMemberShip()) {   
	    	
	    	handlePremiumMemberScan(viruses);
	        
	    } else {
	        handleNonPremiumMemberScan(viruses);
	    }
	}
	
	@Override
	public void setProtection(boolean protection) {
		basicScanner.setProtection(protection);
	}


	@Override
	public void setScanStrategy(ScanStrategy scanStrategy) {
		this.basicScanner.setScanStrategy(scanStrategy);
		
	}

}
