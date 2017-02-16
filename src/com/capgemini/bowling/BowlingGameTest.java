package com.capgemini.bowling;

import org.junit.Test;
import org.junit.Assert;

public class BowlingGameTest {
	@Test
	public void returnsFalseWhenTheGameIsNotFinished(){
		BowlingGame newGame = new BowlingGame();
		newGame.roll(5);
		boolean end = newGame.isFinished();
		Assert.assertFalse(end);
	}
	@Test
	public void returnsFalseAfter9Rounds(){
		BowlingGame newGame = new BowlingGame();
		for(int i=0;i<9;i++){
			newGame.roll(4);
			newGame.roll(4);
		}
		boolean Koniec = newGame.isFinished();
		Assert.assertFalse(Koniec);
	}
	@Test
	public void returnsFalseIfIn10thRoundisStrike(){
		BowlingGame newGame = new BowlingGame();
		for(int i=0;i<9;i++){
			newGame.roll(4);
			newGame.roll(4);
		}
		newGame.roll(10);
		boolean end = newGame.isFinished();
		Assert.assertFalse(end);
	}
	@Test
	public void returnsFalseIfIn10thRoundisSpare(){
		BowlingGame newGame = new BowlingGame();
		for(int i=0;i<9;i++){
			newGame.roll(4);
			newGame.roll(4);
		}
		newGame.roll(5);
		newGame.roll(5);
		boolean end = newGame.isFinished();
		Assert.assertFalse(end);
	}
	@Test
	public void returnsTrueAfter10rounds(){
		BowlingGame newGame = new BowlingGame();
		for(int i=0;i<=9;i++){
			newGame.roll(4);
			newGame.roll(4);
		}
		boolean end = newGame.isFinished();
		Assert.assertTrue(end);
	}
	@Test
	public void returnsTrueAfter11rounds(){
		BowlingGame newGame = new BowlingGame();
		for(int i=0;i<=8;i++){
			newGame.roll(4);
			newGame.roll(4);
		}
		newGame.roll(5);
		newGame.roll(5);
	
		newGame.roll(5);
		newGame.roll(5);
		boolean end = newGame.isFinished();
		Assert.assertTrue(end);
	}
	@Test
	public void perfectGame(){
		BowlingGame newGame = new BowlingGame();
		do
		{
			newGame.roll(10);
		}while(!newGame.isFinished());
		Assert.assertEquals(300, newGame.score());
	}
	@Test(expected=IllegalStateException.class)
	public void shouldReturnExceptionwhenInputIsMoreThan10() throws Exception{
		BowlingGame newGame = new BowlingGame();
		newGame.roll(11);
	}
}
