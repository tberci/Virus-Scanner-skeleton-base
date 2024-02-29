package virus_scanner;

import java.util.List;

import scan_strategy.DeepScan;
import scan_strategy.FastScan;
import scan_strategy.IntelligentScan;
import scan_strategy.ScanStrategy;
import state.OffState;
import state.OnState;
import state.ScannerState;
import state.ScanningState;


public class BasicVirusScanner implements VirusScanner{
    private static BasicVirusScanner instance;
    private ScanStrategy scanStrategy;
    private boolean protection = false ;
    private ScannerState state;
    	
    // Privát konstruktor a példányosítás megakadályozásához kívülrõl
    private BasicVirusScanner() {
    	this.setState(new OffState(this));
    	this.setScanStrategy(new FastScan());
    }

	// Singleton példány lekérdezése vagy létrehozása
    public static synchronized  BasicVirusScanner getInstance() {
        if (instance == null) {
            instance = new BasicVirusScanner();
        }
        return instance;
    }
    @Override
    public void setScanStrategy(ScanStrategy scanStrategy) {
        this.scanStrategy = scanStrategy;
    }

	public ScanStrategy getScanStrategy() {
		if (this.state instanceof OnState || this.state instanceof ScanningState) {
			return scanStrategy;
		}else {
			
			return null ;
		}
	
	}

	@Override
	public void performFullScan(List<Virus> viruses) {
		if (this.state instanceof OnState) {
	        this.getState().Scanning();
	        scanStrategy.performScan(viruses, this);
	       

		}else {
	        System.out.println("The virus scanner is off");
	    }
		
	}

	public ScannerState getState() {
		return state;
	}

	public void setState(ScannerState state) {
			this.state = state;
		}

	
	public String printStrategy() {
	        if (this.getScanStrategy() instanceof FastScan) {
	            return "Fast Scan";
	        } else if(this.getScanStrategy() instanceof DeepScan) {
	            return "Deep scan";
	        }else if(this.getScanStrategy() instanceof IntelligentScan) {
	        	return "Intelligent scan";
	        }
			return "defeault";
	    }
	    
	public String printState() {
        if (this.getState() instanceof OnState) {
            return "On";
        }else if (this.getState() instanceof ScannerState) {
        	return "Scanning";
        }else {
        	return "Off";
        }
        	
    }
	@Override
	public void setProtection(boolean protection) {
		this.protection = protection;
	}

	public boolean getProtection() {
		return protection;
	}

	
	 
    
}