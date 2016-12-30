package br.com.stkstocker.contaazul.model;

public class Position {
	
	private int axisX;
	private int axisY;
	private char direction;
	
	
	public Position(int x, int y, char dir){
		this.axisX = x;
		this.axisY = y;
		this.direction = dir;
	}
	
	public int getAxisX(){
		return axisX;
	}
	
	public int getAxisY(){
		return axisY;
	}
	
	public char getDirection(){
		return direction;
	}
	
	protected void moveFoward(Terrain t) throws Exception{
		int x = axisX;
		int y = axisY;
		switch(direction){
		case 'N':
			y += 1;
			break;
		case 'W':
			x -= 1;
			break;
		case 'S':
			y -= 1;
			break;
		case 'E':
			x += 1;
			break;
		}
		validateTerrain(x,y,t);
		axisX = x;
		axisY = y;
	}

	public void validateTerrain(int x, int y, Terrain t) throws Exception{
		if( x >= t.getWidth() 
				|| y >= t.getHeight() 
				|| x < 0 
				|| y < 0 ){
			throw new Exception("Cannot leave the area");
		}
	}
	
	protected void turnLeft(){
		switch(direction){
		case 'N':
			direction = 'W';
			break;
		case 'W':
			direction = 'S';
			break;
		case 'S':
			direction = 'E';
			break;
		case 'E':
			direction = 'N';
			break;
		}
	}
	
	protected void turnRight(){
		switch(direction){
		case 'N':
			direction = 'E';
			break;
		case 'E':
			direction = 'S';
			break;
		case 'S':
			direction = 'W';
			break;
		case 'W':
			direction = 'N';
			break;
		}
	}

	
}
