package virus_scanner;

public class Virus {


	private boolean isDetectable;
	private boolean canAlterVirusScanner;
	
	public Virus( boolean isDetectable,  boolean canAlterVirusScanner) {
		super();
		
		this.isDetectable = isDetectable;
		this.canAlterVirusScanner = canAlterVirusScanner;
	}

	public boolean isDetectable() {
		return isDetectable;
	}
	public void setDetectable(boolean isDetectable) {
		this.isDetectable = isDetectable;
	}

	public boolean CanAlterVirusScanner() {
		return canAlterVirusScanner;
	}

	public void setCanAlterVirusScanner(boolean canAlterVirusScanner) {
		this.canAlterVirusScanner = canAlterVirusScanner;
	}
	
	
	
	
	
}
