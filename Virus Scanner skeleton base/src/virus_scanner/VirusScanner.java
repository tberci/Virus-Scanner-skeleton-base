package virus_scanner;

import java.util.List;

import scan_strategy.ScanStrategy;

public interface VirusScanner {
   public void performFullScan(List<Virus> viruses);
   public void setScanStrategy(ScanStrategy scanStrategy);
   public void setProtection( boolean protection);
}
