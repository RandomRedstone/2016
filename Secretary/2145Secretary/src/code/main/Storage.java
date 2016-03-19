package code.main;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Storage {
	static Formatter team;
	static Formatter business;
	static String location = Main.class.getResource("Main.class").toString().substring(6).replace("bin/code/main/Main.class", "");
	public static void openTeamFile() {
		try {
			team = new Formatter(location+"src/storage/team/team.txt");
		} catch (FileNotFoundException e) {
			
		}
	}
	public static void writeToFile() {
		team.format("%d %s %s %.2f%n", "hi");
	}
	public static void close() {
		team.close();
		business.close();
	}
}
