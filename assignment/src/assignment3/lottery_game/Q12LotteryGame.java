package assignment3.lottery_game;
import java.util.List;
import java.util.Random;

public class Q12LotteryGame {
	public void start(List<LotteryPlayer> lotteryPlayer) {
		boolean  bool=true;
		int countPick = 0;
		//printing random array for each player
		System.out.println("printing random array for each player");
		for(int i =0;i<lotteryPlayer.size();i++) {// player object
			System.out.println(lotteryPlayer.get(i).name);
			for(int j=0;j<lotteryPlayer.get(i).list.size();j++) {
				System.out.println(lotteryPlayer.get(i).list.get(j));
			}
		}
		
		while(bool) {
			for(int i =0;i<lotteryPlayer.size();i++) {// player object
				int rand=new Random().nextInt(1000);
				for(int j=0;j<lotteryPlayer.get(i).list.size();j++) {
						if(rand==lotteryPlayer.get(i).list.get(j)) {
							lotteryPlayer.get(i).list.remove(j);
							countPick++;
						}
						if(lotteryPlayer.get(i).list.isEmpty()) {
							System.out.println("Winner is "+lotteryPlayer.get(i).name);
							bool = false;
						}
						
					}
				}
			}
		System.out.println("Count of picked number : "+countPick);
//		System.out.println("Printing Remaining Array Size");
//		for(int i =0;i<lotteryPlayer.size();i++) {
//			System.out.println(lotteryPlayer.get(i).list.size()+" "+lotteryPlayer.get(i).name);
//		}

	}
    public static void main(String[] args) {
    	Q12LotteryGame q12 = new Q12LotteryGame();
    	long startTime = System.nanoTime();
    	q12.start(LotteryPlayer.getPlayerList());
    	long stopTime = System.nanoTime();
    	System.out.println("Game Duration: "+(stopTime - startTime)/1000000+" milliseconds");
    }
}