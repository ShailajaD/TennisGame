
public class SimpleTennis {
	String playerA, playerB;
	int scoreA, scoreB;
	
	// If true, playerA serves, else playerB
	boolean serve;
	
	boolean playerAWon, playerBWon;
	
	public SimpleTennis(String playerA, String playerB){
		this.playerA = playerA;
		this.playerB = playerB;
		this.scoreA = 0;
		this.scoreB = 0;		
	}
	
	
	public static void main(String[] args) {
		
		SimpleTennis game = new SimpleTennis("Pete", "Novak");
		
		game.coinToss();
		game.start();
		
	}


	private void coinToss() {		
		this.serve = Math.random() <= 0.5;
		if (this.serve)
			System.out.println(this.playerA + " is serving");
		else
			System.out.println(this.playerB + " is serving");
	}


	private void start() {
		
		while (!this.gameOver()){
			
			commentary();
			
			boolean point = Math.random()<= 0.5;
			if (point)
				this.scoreA++;
			else 
				this.scoreB++;	
		}
		if (this.playerAWon)
			System.out.println(this.playerA + " won!");
		else
			System.out.println(this.playerB + " won!");
	}


	private void commentary() {
		
		if (this.scoreA >= 3 && this.scoreB >= 3){
			if (this.scoreA == this.scoreB + 1)
				System.out.println("Advantage " + this.playerA + "!");
			else if (this.scoreB == this.scoreA + 1)
				System.out.println("Advantage " + this.playerB + "!");
			else if (this.scoreB == this.scoreA)
				System.out.println("Deuce!");
		}
		else {
			if (this.serve)
				System.out.println(translate(this.scoreA) + " " + translate(this.scoreB));
			else
				System.out.println(translate(this.scoreB) + " " + translate(this.scoreA));
		}
		
		
	}


	private String translate(int score) {
		if(score == 0)  return "Love";		
		else if(score == 1) return "Fifteen";
		else if(score == 2) return "Thirty";
		else if(score == 3) return "Fourty";
		return "";
	}


	private boolean gameOver() {
		playerAWon = (this.scoreA >= 4) && (this.scoreA - this.scoreB >= 2);
		playerBWon = (this.scoreB >= 4) && (this.scoreB - this.scoreA >= 2);
		return playerAWon || playerBWon;
	}
}
