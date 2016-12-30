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
	
	protected void moveFoward(){
		switch(direction){
		case 'N':
			axisY += 1;
			break;
		case 'W':
			axisX -= 1;
			break;
		case 'S':
			axisY -= 1;
			break;
		case 'E':
			axisX += 1;
			break;
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
