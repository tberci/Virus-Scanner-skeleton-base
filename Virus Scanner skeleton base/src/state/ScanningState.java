package state;

import scan_strategy.FastScan;
import virus_scanner.BasicVirusScanner;

public class ScanningState extends ScannerState{

	public ScanningState(BasicVirusScanner scanner) {
		super(scanner);
		
	}

	@Override
	public void turnOn() {
		System.out.println("scanner is on");
		scanner.setState(new OnState(scanner));
	}

	@Override
	public void turnOff() {
		System.out.println("scanner is off");
		scanner.setState(new OffState(scanner));
	}

	@Override
	public void Scanning() {
		
	}

	@Override
	public void ScanningFinished() {
		System.out.println("Scanning finished");
		scanner.setState(new ScanningFinishedState(scanner));
		
	}

}
