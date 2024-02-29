package virus_scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import scan_strategy.DeepScan;
import scan_strategy.FastScan;
import scan_strategy.IntelligentScan;
import state.OffState;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		int virus_number;

		List<Virus> viruses = new ArrayList<>();
		
		User user = new User();
		
		BasicVirusScanner basicVirusScanner = BasicVirusScanner.getInstance();
		basicVirusScanner.getState().turnOn();
		ProxyVirusScanner proxy  = new ProxyVirusScanner(basicVirusScanner,user);
		
		System.out.println("add new viruses ");
	
        System.out.println("1. Number of detectable viruses");
        virus_number = sc.nextInt();
        for(int i= 0; i< virus_number;i++) {
    		viruses.add(new Virus(true,false));
        }
        System.out.println("2. Number of undetectable viruses");
        virus_number = sc.nextInt();
        for(int i= 0; i< virus_number;i++) {
    		viruses.add(new Virus(false,false));
        }

        System.out.println("3. Number of scanner state altering viruses");
        virus_number = sc.nextInt();
        for(int i= 0; i< virus_number;i++) {
    		viruses.add(new Virus(false,true));
        }
    	System.out.println("");
    	
    		do {
    			System.out.println("User status:" + user.printStatus());
    			System.out.println("Current scanning strategy : "+ basicVirusScanner.printStrategy());
    			System.out.println("Scanner state :" + basicVirusScanner.printState());
			 	System.out.println("");
	            System.out.println("Select a scanning strategy");
	            System.out.println("1. Intelligent Scan");
	            System.out.println("2. Deep Scan");
	            System.out.println("3. Fast Scan");
	            System.out.println("");
	            System.out.println("4. Perform scan");
	            System.out.println("5. Activate premium status");
	            System.out.println("6. Quit");

	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    proxy.setScanStrategy(new IntelligentScan());
	                    break;
	                case 2:
	                    proxy.setScanStrategy(new DeepScan());
	                    break;
	                case 3:
	                    proxy.setScanStrategy(new FastScan());
	                    break;
	                case 4:
	                    proxy.performFullScan(viruses);
	                    break;
	                case 5:
	                    user.getState().premiumOn();
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    basicVirusScanner.getState().turnOff();
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        	System.out.println("");
	          
	        } while (!(basicVirusScanner.getState() instanceof OffState) );
    	
		
	}

}
