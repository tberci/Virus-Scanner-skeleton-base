package scan_strategy;

import java.util.List;

import state.OffState;
import state.ScanningFinishedState;
import virus_scanner.BasicVirusScanner;
import virus_scanner.Virus;

public class FastScan implements ScanStrategy {
	
	private int count = 0;
	
	@Override
	public void performScan(List<Virus> viruses,BasicVirusScanner scanner) {
		System.out.println("Performing fast scan");
		for (int i = 0; i < viruses.size(); i++) {
		    if ( viruses.get(i).CanAlterVirusScanner() && !scanner.getProtection() ) {
		        scanner.getState().turnOff();
		        break;
		    }else if ( viruses.get(i).isDetectable() && i % 2 == 0) {
		        count++;
		    }
		}
		 try {
	           
	          Thread.sleep(2000);
	          scanner.getState().ScanningFinished();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		if(!(scanner.getState() instanceof OffState) && scanner.getState() instanceof ScanningFinishedState) {
			System.out.println("Number of viruses found : " +count);
			scanner.getState().turnOn();
		}
		
		
	}
	
}
