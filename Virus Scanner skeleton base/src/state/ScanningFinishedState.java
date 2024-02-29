package state;

import virus_scanner.BasicVirusScanner;

public class ScanningFinishedState extends ScannerState {

	public ScanningFinishedState(BasicVirusScanner scanner) {
		super(scanner);
		
	}

	@Override
	public void turnOn() {
		scanner.setState(new OnState(scanner));
	}

	@Override
	public void turnOff() {
		System.out.println("Virus scanner turned off");
		scanner.setState(new OffState(scanner));
		
	}

	@Override
	public void Scanning() {
	
	}

	@Override
	public void ScanningFinished() {
	
		
	}

}
