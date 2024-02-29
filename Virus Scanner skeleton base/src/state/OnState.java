package state;

import java.util.List;

import virus_scanner.BasicVirusScanner;


public class OnState extends ScannerState {

	public OnState(BasicVirusScanner scanner) {
		super(scanner);
		
	}

	@Override
	public void turnOn() {
		System.out.println("The virus scanner is already on");
	}

	@Override
	public void turnOff() {
		System.out.println("The virus scanner is turning off");
		scanner.setState(new OffState(scanner));
		
	}

	@Override
	public void Scanning() {
		scanner.setState(new ScanningState(scanner));
		System.out.println("Scanning in progress...");
		System.out.println("Scanner state: " + scanner.printState());
	}

	@Override
	public void ScanningFinished() {
		System.out.println("Scanning finished");
		
	}



}
