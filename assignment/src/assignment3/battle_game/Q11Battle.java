package assignment3.battle_game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Q11Battle {
	public static void main(String[] args) {
		Player strongPlayer = new StrongPlayer("StrongPlayer",50, 4);
		Player youngPlayer = new YoungPlayer("YoungPlayer", 90, 6);
		Player healthyPlayer = new HealthyPlayer("HealthyPlayer", 70, 5);
		Player oldPlayer = new OldPlayer("OldPlayer", 70, 7);
		generateTournament(strongPlayer,youngPlayer,healthyPlayer,oldPlayer);
	}
	private static void generateTournament(Player strongPlayer, Player youngPlayer, Player healthyPlayer,
		Player oldPlayer) {
		System.out.println("===== Generating tournament =======");		
		//random player list
		ArrayList<Player> playerList = new ArrayList<Player>();
		//distinct list 1 to 4
		Set<Integer> ints = new LinkedHashSet<>();
		Random rand = new Random();
		while(ints.size() < 4) { // 1 - 4 // 2,0,3,1// st
		    ints.add(rand.nextInt(4));   
	    }
		Iterator<Integer> i=ints.iterator();
		// adding to playerList
		while(i.hasNext()) {
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
		System.out.println("=====================================================");
		System.out.println(playerList.get(0).name +": Vs :"+playerList.get(1).name);
		System.out.println(playerList.get(2).name +": Vs :"+playerList.get(3).name);
		System.out.println("=====================================================");
		// game playing between 1 and 2 | and 3 and 4
		Player playerObj[] = new Player[2];
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		for(int j=0;j<playerList.size();j++) {
			if(j == 1 || j == 3) {
				System.out.println("start match between "+playerList.get(j-1).name+" "+playerList.get(j).name+" ?(yes/no)");
				String enter = scanner.nextLine();
				if(enter.equalsIgnoreCase("yes")) {
					playerObj[count] = fight(playerList.get(j-1), playerList.get(j));
					count ++;
				}else {
					break;
				}
			}	
		}
		try {
			for (int j = 0; j < playerObj.length; j++) {
				if(j==1) {
					 //+ playerObj[j-1].name+" : Vs : "+playerObj[j].name
					System.out.println("Do you want to start match(yes/no)?");
					String enter = scanner.nextLine();
					if(enter.equalsIgnoreCase("yes")) {
						System.out.println(" ============== Final Match ============  " );
						System.out.println(fight(playerObj[0], playerObj[1]).health+" health");
						System.out.println("=====Thanks===== ");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		scanner.close();
	}

	public static Player fight( Player player1, Player player2)  {
		int p1ShotCount = 0;
		int p2ShotCount = 0;
		Player value;
		outer:for(int k = 0 ; k<50;k++) {
//			System.out.println();
//			System.out.println("Round "+(k+1));
			Random random = new Random();
			int p1 = random.nextInt(100);
//			System.out.println("Attacker "+player2.name+" ");
			for(int i = 0; i<5; i++) {
				int attacker = random.nextInt(100);
				if(player1.health > 0 || player1.power > 0) {
					if(p1==attacker) {
//						System.out.println(" ==>You are shot");
//						System.out.println(player1.health+" health");
						player1.health=player1.health-player2.power;
						p2ShotCount++;
						break;
					}
				}else {
					value = player2;
					System.out.println(player1.name+" is out of health / power");
					break outer;
				}
			}
//			System.out.println("Attacker "+player1.name+" ");
			int p2 = random.nextInt(100);
			for(int i = 0; i<5; i++) {
				int attacker = random.nextInt(100);
				if(player2.health > 0 || player2.power > 0) {
					if(p2==attacker) {
//						System.out.println(" ==>You are shot");
						player2.health=player2.health-player1.power;
						p1ShotCount++;
						break;
					}
				}else {
					value = player1;
					System.out.println(player2.name+" is out of health / power");
					break outer;
				}
			}
		}
				
		if(player1.health>player2.health) {
			System.out.println(player1.name+" : Vs : "+player2.name);
			System.out.println("==================================================");
			System.out.println("Total round: 50");
			System.out.println(player1.name+" shot on target: "+p1ShotCount);
			System.out.println(player2.name+" shot on target: "+p2ShotCount);
			System.out.println("Winner is : "+player1.name);
			System.out.println("==================================================");
			value = player1;
		}else {
			System.out.println(player1.name+" : Vs : "+player2.name);
			System.out.println("==================================================");
			System.out.println("Total round: 50");
			System.out.println(player1.name+" shot on target: "+p1ShotCount);
			System.out.println(player2.name+" shot on target: "+p2ShotCount);
			System.out.println("Winner is : "+player2.name);
			System.out.println("==================================================");
			value = player2;
		}
		return value;	
	}	
}
