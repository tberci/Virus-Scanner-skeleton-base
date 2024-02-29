package scan_strategy;

import java.util.List;

import virus_scanner.BasicVirusScanner;
import virus_scanner.Virus;

public interface ScanStrategy {
	
	public void performScan(List<Virus> viruses, BasicVirusScanner scanner);
	
}
