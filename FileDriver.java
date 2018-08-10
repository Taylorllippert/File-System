import java.util.*;

public class FileDriver {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter FM: ");
	String input = sc.nextLine();
	while (!input.startsWith("FM")) {
		System.out.println("Eror: Please try again");
		input = sc.nextLine();
	}
	
	FileSystem fileSys = new FileSystem();
	while (!input.startsWith("q")) {
		System.out.println("Please enter your command: ");
		String cmd = sc.next();
		String name = sc.next();
		boolean valid = true;
		
		if (cmd.startsWith("NF")) {
			int bnum = sc.nextInt();
			fileSys.newFile(name, bnum);
		}
		
		else if(cmd.startsWith("MF")) {
			int bnum = sc.nextInt();
			fileSys.addBlocks(name, bnum);
		}
		
		else if (cmd.startsWith("DF")) {
			fileSys.deleteFile(name);
		}
		
		else if (cmd.startsWith("DB")) {
			int bnum = sc.nextInt();
			fileSys.deleteBlocks(name, bnum);
		}
		
		else {
			valid = false;
			System.out.println("Error: Invalid command");
		}
		
		if (valid) {
			fileSys.printFile(name);
		}
	}

}
