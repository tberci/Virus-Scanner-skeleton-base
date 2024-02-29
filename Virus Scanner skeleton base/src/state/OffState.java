package state;



import virus_scanner.BasicVirusScanner;

public class OffState extends ScannerState {

	public OffState(BasicVirusScanner scanner) {
		super(scanner);
		
	}

	@Override
	public void turnOn() {
		System.out.println("The virus scanner is on");
		scanner.setState(new OnState(scanner));
		
	}

	@Override
	public void turnOff() {
		System.out.println("The virus scanner is already off");
		
	}

	@Override
	public void Scanning() {
		
		
	}

	@Override
	public void ScanningFinished() {
		// TODO Auto-generated method stub
		
	}



}
