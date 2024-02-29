package scan_strategy;

import java.util.List;

import state.OffState;
import state.ScanningFinishedState;
import virus_scanner.BasicVirusScanner;
import virus_scanner.Virus;

public class DeepScan implements ScanStrategy {
	private int count = 0;
	
	@Override
	public void performScan(List<Virus> viruses, BasicVirusScanner scanner) {
		System.out.println("Performing deep scan ");
		
		for (Virus virus : viruses) {
            if (virus.CanAlterVirusScanner() && !scanner.getProtection()) {
            	scanner.getState().turnOff();
                break;
            }else if(virus.isDetectable()) {
            	count++;
            }
            
        }
		 try {
	           
	          Thread.sleep(7000);
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
