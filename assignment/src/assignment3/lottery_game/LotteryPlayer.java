package assignment3.lottery_game;

import java.util.ArrayList;
import java.util.Random;

public class LotteryPlayer{
	String name;
	ArrayList<Integer> list;
	public LotteryPlayer(String name, ArrayList<Integer> list) {
		this.name = name;
		this.list = list;
	}
	public static ArrayList<Integer> randomNumber() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<10; i++) {
			list.add(new Random().nextInt(1000));
		}
		return list;
	}
	
	public static ArrayList<LotteryPlayer> getPlayerList() {
		ArrayList<LotteryPlayer> list = new ArrayList<LotteryPlayer>();
		for(int i = 0; i<10; i++) {
			list.add(new LotteryPlayer("Player "+(i+1),randomNumber()));
		}
		return list;
	}
}
