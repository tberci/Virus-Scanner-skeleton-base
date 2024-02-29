package state;



import virus_scanner.BasicVirusScanner;


public abstract class ScannerState {
		
	
	 	protected BasicVirusScanner scanner;

	    public ScannerState(BasicVirusScanner scanner) {
	        this.scanner = scanner;
	    }
	
	 	public abstract void turnOn();
	 	public abstract void turnOff();
	 	public abstract void Scanning();
	 	public abstract void ScanningFinished();
}
