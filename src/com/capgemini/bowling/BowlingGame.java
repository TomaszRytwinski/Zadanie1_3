package com.capgemini.bowling;
//Gra w kregle, funkcja int score zwraca obecny wynik gry, funkcja
public class BowlingGame implements BowlingGameResultCalculator {
	private int[][] tableOfScore = new int[4][12]; 

	private int round=0;
	private int roll=0;
	
	
	public BowlingGame(){
		for (int i=0;i<10;i++){
			for(int j=0;j<=3;j++){
				tableOfScore[j][i]=0;
			}
		}
	}

	private void addBonus(int _round, int numberOfPins){
		tableOfScore[2][_round]=tableOfScore[2][_round]+numberOfPins;
		
	}
	public void roll(int numberOfPins) throws IllegalStateException{
		if (numberOfPins>10 || (tableOfScore[0][round]+tableOfScore[0][round]>10)){
			throw new IllegalStateException();
		}
		if (round>=2 && tableOfScore[3][round-2]==1){
			addBonus(round-2,numberOfPins);
			tableOfScore[3][round-2]=0;
		}
		if (round>=1 && tableOfScore[3][round-1]==1){
			addBonus(round-1,numberOfPins);
			tableOfScore[3][round-1]=0;
		}
		if (round>=1 && tableOfScore[3][round-1]==2){
			addBonus(round-1,numberOfPins);
			tableOfScore[3][round-1]=1;
		}
		tableOfScore[roll][round]=numberOfPins;
		tableOfScore[2][round]=tableOfScore[2][round]+numberOfPins;
		if (roll==0 && numberOfPins == 10){
			tableOfScore[3][round]=2;
			round++;
		}
		else if (tableOfScore[2][round]==10){
			tableOfScore[3][round]=1;
			roll=0;
			round++;
		}
		else if (roll==1){
			roll=0;
			round++;
		}else{
			roll++;
		}
	}
	public int score(){
		int score=0;
		for (int i=0;i<round;i++){
				score = score + tableOfScore[2][i];
		}
		return score;
	}
	public boolean isFinished(){
		if (round<10){
			return false;
		}
		else if (round==10 && tableOfScore[2][9]<10){
			return true;
		}else if(round==11 && tableOfScore[2][9]>=10 && tableOfScore[2][9]!=2){
			return true;
		}else if(round==12){
			return true;
		}
		return false;
	}
	public void printTable(){
		for (int i=0;i<round;i++){
			for(int j=0;j<=3;j++){
				System.out.println(tableOfScore[j][i]);
			}
			System.out.println(" ");
		}
	}
}
