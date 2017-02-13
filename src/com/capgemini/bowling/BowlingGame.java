package com.capgemini.bowling;
//Gra w kregle, funkcja int score zwraca obecny wynik gry, funkcja
public class BowlingGame implements BowlingGameResultCalculator {
	private int[][] TablicaWynikow = new int[4][12]; 

	private int kolejka=0;
	private int rzut=0;
	
	
	public BowlingGame(){
		for (int i=0;i<10;i++){
			for(int j=0;j<=3;j++){
				TablicaWynikow[j][i]=0;
			}
		}
	}

	private void DodajBonus(int _kolejka, int numberOfPins){
		TablicaWynikow[2][_kolejka]=TablicaWynikow[2][_kolejka]+numberOfPins;
		
	}
	public void roll(int numberOfPins) throws IllegalStateException{
		if (numberOfPins>10 || (TablicaWynikow[0][kolejka]+TablicaWynikow[0][kolejka]>10)){
			throw new IllegalStateException();
		}
		if (kolejka>=2 && TablicaWynikow[3][kolejka-2]==1){
			DodajBonus(kolejka-2,numberOfPins);
			TablicaWynikow[3][kolejka-2]=0;
		}
		if (kolejka>=1 && TablicaWynikow[3][kolejka-1]==1){
			DodajBonus(kolejka-1,numberOfPins);
			TablicaWynikow[3][kolejka-1]=0;
		}
		if (kolejka>=1 && TablicaWynikow[3][kolejka-1]==2){
			DodajBonus(kolejka-1,numberOfPins);
			TablicaWynikow[3][kolejka-1]=1;
		}
		TablicaWynikow[rzut][kolejka]=numberOfPins;
		TablicaWynikow[2][kolejka]=TablicaWynikow[2][kolejka]+numberOfPins;
		if (rzut==0 && numberOfPins == 10){
			TablicaWynikow[3][kolejka]=2;
			kolejka++;
		}
		else if (TablicaWynikow[2][kolejka]==10){
			TablicaWynikow[3][kolejka]=1;
			rzut=0;
			kolejka++;
		}
		else if (rzut==1){
			rzut=0;
			kolejka++;
		}else{
			rzut++;
		}
	}
	public int score(){
		int score=0;
		for (int i=0;i<kolejka;i++){
				score = score + TablicaWynikow[2][i];
		}
		return score;
	}
	public boolean isFinished(){
		if (kolejka<10){
			return false;
		}
		else if (kolejka==10 && TablicaWynikow[2][9]<10){
			return true;
		}else if(kolejka==11 && TablicaWynikow[2][9]>=10 && TablicaWynikow[2][9]!=2){
			return true;
		}else if(kolejka==12){
			return true;
		}
		return false;
	}
	public void DrukujTablice(){
		for (int i=0;i<kolejka;i++){
			for(int j=0;j<=3;j++){
				System.out.println(TablicaWynikow[j][i]);
			}
			System.out.println(" ");
		}
	}
}
