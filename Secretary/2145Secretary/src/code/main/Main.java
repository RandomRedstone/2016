package code.main;

import java.util.ArrayList;

import code.team.Member;

public class Main {
	public static ArrayList<Member> a;
	public static void main(String[] args) {
		Storage.openTeamFile();
		Storage.writeToFile();
		Storage.close();
	}
}
