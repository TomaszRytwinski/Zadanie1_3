package com.capgemini.bowlingTest;

import org.junit.Test;
import org.junit.Assert;

import com.capgemini.bowling.BowlingGame;

public class BowlingTest {
	@Test
	public void ZwracaFalseJesliGraNieSkonczona(){
		BowlingGame NowaGra = new BowlingGame();
		NowaGra.roll(5);
		boolean Koniec = NowaGra.isFinished();
		Assert.assertFalse(Koniec);
	}
	@Test
	public void ZwracaFalseJesliGraPo9Rundach(){
		BowlingGame NowaGra = new BowlingGame();
		for(int i=0;i<9;i++){
			NowaGra.roll(4);
			NowaGra.roll(4);
		}
		boolean Koniec = NowaGra.isFinished();
		Assert.assertFalse(Koniec);
	}
	@Test
	public void ZwracaFalseJesliGraW10RundzieJestStrike(){
		BowlingGame NowaGra = new BowlingGame();
		for(int i=0;i<9;i++){
			NowaGra.roll(4);
			NowaGra.roll(4);
		}
		NowaGra.roll(10);
		boolean Koniec = NowaGra.isFinished();
		Assert.assertFalse(Koniec);
	}
	@Test
	public void ZwracaFalseJesliGraW10RundzieJestSpare(){
		BowlingGame NowaGra = new BowlingGame();
		for(int i=0;i<9;i++){
			NowaGra.roll(4);
			NowaGra.roll(4);
		}
		NowaGra.roll(5);
		NowaGra.roll(5);
		boolean Koniec = NowaGra.isFinished();
		Assert.assertFalse(Koniec);
	}
	@Test
	public void ZwracaTruePo10Rundach(){
		BowlingGame NowaGra = new BowlingGame();
		for(int i=0;i<=9;i++){
			NowaGra.roll(4);
			NowaGra.roll(4);
		}
		boolean Koniec = NowaGra.isFinished();
		Assert.assertTrue(Koniec);
	}
	@Test
	public void ZwracaTruePo11RundachGdyBylSpare(){
		BowlingGame NowaGra = new BowlingGame();
		for(int i=0;i<=8;i++){
			NowaGra.roll(4);
			NowaGra.roll(4);
		}
		NowaGra.roll(5);
		NowaGra.roll(5);
		
		NowaGra.roll(5);
		NowaGra.roll(5);
		NowaGra.DrukujTablice();
		boolean Koniec = NowaGra.isFinished();
		Assert.assertTrue(Koniec);
	}
	@Test
	public void PerfectGame(){
		BowlingGame NowaGra = new BowlingGame();
		do
		{
			NowaGra.roll(10);
		}while(!NowaGra.isFinished());
		Assert.assertEquals(300, NowaGra.score());
	}
	@Test(expected=IllegalStateException.class)
	public void BladGdyStracimyWiecejNiz10Kregli() throws Exception{
		BowlingGame NowaGra = new BowlingGame();
			NowaGra.roll(15);
	}
}
