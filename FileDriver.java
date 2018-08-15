import java.util.*;
import java.io.*;


// Run with file name as argument
public class FileDriver {
	public static void main(String[] args) {
		Scanner sc;
		if(args.length > 0){
			File infile = new File(args[0]);
			try{
				sc = new Scanner(infile);
				String input = sc.nextLine();
				while (!input.startsWith("FM")) {
					input = sc.nextLine();
				}
				FileSystem fileSys = new FileSystem();
				while (sc.hasNextLine()) {
					String cmd = sc.next();
					String name = sc.next();
					boolean valid = true;

					if (cmd.startsWith("NF")) {
						int bnum = sc.nextInt();
						System.out.println("\n"+cmd + " " + name + " "+ bnum+ "\n");
						fileSys.newFile(name, bnum);
					} else if (cmd.startsWith("MF")) {
						int bnum = sc.nextInt();
						System.out.println("\n"+cmd + " " + name + " "+ bnum+ "\n");
						fileSys.addBlocks(name, bnum);
					} else if (cmd.startsWith("DF")) {
						System.out.println("\n"+cmd + " " + name +  "\n");
						fileSys.deleteFile(name);
					} else if (cmd.startsWith("DB")) {
						int bnum = sc.nextInt();
						System.out.println("\n"+cmd + " " + name + " "+ bnum+ "\n");
						fileSys.deleteBlocks(name, bnum);
					} else {
						valid = false;
					}
					if (valid) {
						System.out.println(fileSys);
					}
				}
				sc.close();
			}catch(FileNotFoundException e){
				System.out.println("File Not Found");
				//debug();
			}
		}else{
			debug();
		}

	}
	public static void debug(){
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
			} else if (cmd.startsWith("MF")) {
				int bnum = sc.nextInt();
				fileSys.addBlocks(name, bnum);
			} else if (cmd.startsWith("DF")) {
				fileSys.deleteFile(name);
			} else if (cmd.startsWith("DB")) {
				int bnum = sc.nextInt();
				fileSys.deleteBlocks(name, bnum);
			} else {
				valid = false;
				System.out.println("Error: Invalid command");
			}

			if (valid) {
				System.out.println(fileSys);
			}
		}
	}
}
