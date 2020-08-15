package assignment3.battle_game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Q11Battle {
	public static void main(String[] args) {
		Player strongPlayer = new StrongPlayer("Strong Player", 99, 20);
		Player youngPlayer = new YoungPlayer("Young Player", 90, 14);
		Player healthyPlayer = new HealthyPlayer("Healthy Player", 80, 12);
		Player oldPlayer = new OldPlayer("Old Player", 70, 8);
		generateTournament(strongPlayer, youngPlayer, healthyPlayer, oldPlayer);
		System.out.println("Time Duration : "+youngPlayer.toString());
	}

	private static void generateTournament(Player strongPlayer, Player youngPlayer, Player healthyPlayer,
		Player oldPlayer) {
		System.out.println(" Tournament Fixture: ");
		ArrayList<Player> playerList = new ArrayList<Player>();
		Set<Integer> ints = new LinkedHashSet<>();
		Random rand = new Random();
		while (ints.size() < 4) { // 1 - 4 // 2,0,3,1// st
			ints.add(rand.nextInt(4));
		}
		Iterator<Integer> i = ints.iterator();
		while (i.hasNext()) {
			switch (i.next()) {
			case 0:
				playerList.add(strongPlayer);
				break;
			case 1:
				playerList.add(youngPlayer);
				break;
			case 2:
				playerList.add(healthyPlayer);
				break;
			case 3:
				playerList.add(oldPlayer);
				break;
			}
		}
		// i have added all the players object in list
		System.out.println("\t" + playerList.get(0).name + "\t Vs\t " + playerList.get(1).name);
		System.out.println("\t" + playerList.get(2).name + "\t Vs\t " + playerList.get(3).name);
		System.out.println("==================================================");

		// game playing between 1 and 2 | and 3 and 4
		Player playerObj[] = new Player[2];
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		System.out.println("Would you like to start Battle Game(yes/no)?");
		String enter = scanner.nextLine();
		if (enter.equalsIgnoreCase("yes")) {
			youngPlayer.startTime = System.nanoTime();
			for (int j = 0; j < playerList.size(); j++) {
				if (j == 1 || j == 3) {
					System.out.println(
							"Battle\t : " + playerList.get(j - 1).name + " Vs " + playerList.get(j).name + " ");
					playerObj[count++] = fight(playerList.get(j - 1), playerList.get(j));
				}
			}
		}
		for (int j = 0; j < playerObj.length; j++) {
			if (j == 1) {
				System.out.println("Final Battle\t : " + playerObj[j - 1].name + " Vs " + playerObj[j].name + " ");
				fight(playerObj[j - 1], playerObj[j]);
			}
		}
		youngPlayer.endTime = System.nanoTime();
		scanner.close();
	}

	public static Player fight(Player player1, Player player2) {
		Random random = new Random();
		Player winner = null;
		outer: while (true) {
			int p1 = random.nextInt(100);
			for (int i = 0; i < 10; i++) {
				int attacker = random.nextInt(100);
				if (player1.health > 0) {
					if (p1 == attacker) {
						player1.health = player1.health - player2.power;
						if (player1.health - player2.power < 0) {
							winner = player2;
							System.out.println("Winner\t : " + player2.name + " " + player2.health +"\n");
							winner = player2;
							break outer;
						}
						break;
					}
				}
			}
			int p2 = random.nextInt(100);
			for (int i = 0; i < 10; i++) {
				int attacker = random.nextInt(100);
				if (player2.health > 0) {
					if (p2 == attacker) {
						player2.health = player2.health - player1.power;
						if (player2.health - player1.power < 0) {
							System.out.println("Winner\t : " + player1.name + " " + player1.health +"\n");
							winner = player1;
							break outer;
						}
						break;
					}
				}
			}
		}
		return winner;
	}
}
