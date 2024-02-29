package scan_strategy;

import java.util.List;

import state.ScanningFinishedState;
import virus_scanner.BasicVirusScanner;
import virus_scanner.Virus;

public class IntelligentScan implements ScanStrategy {
    private int alter_count = 0;
    private int count = 0;
    
	@Override
	public void performScan(List<Virus> viruses, BasicVirusScanner scanner) {
		System.out.println("Performing intelligent scan");
		
		for (Virus virus : viruses) {
            if (virus.CanAlterVirusScanner()) {
               System.out.println("Malicious virus which can alter Scanner state detected.");
               alter_count++;
               count++;
               
            }else {
            	count++;
            }
        }
		 try {
	           
	          Thread.sleep(7000);
	          scanner.getState().ScanningFinished();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 if(scanner.getState() instanceof ScanningFinishedState) {
			 System.out.println("Number of scanner altering viruses found : " +alter_count);
			 System.out.println("Number of viruses found : " +count);
				scanner.getState().turnOn();
		 }
		
		
	}


}
