package br.com.stkstocker.contaazul.model;

public class Robot {
	
	private Position position;
	private Terrain terrain;
	
	public Robot(){
		this.position = new Position(0,0,'N');
		this.terrain = new Terrain(5,5);
	}
	
	public boolean validatePosition(char[] string) throws Exception{
		for (char c : string) {
			switch(c){
			case 'M':
				position.moveFoward();
				validateTerrain();
				break;
			case 'L':
				position.turnLeft();
				break;
			case 'R':
				position.turnRight();
				break;
			}
			
		}
		return true;
	}
	
	public void validateTerrain() throws Exception{
		if( position.getAxisX() >= terrain.getWidth() 
				|| position.getAxisY() >= terrain.getHeight() 
				|| position.getAxisX() < 0 
				|| position.getAxisY() < 0 ){
			throw new Exception("Cannot leave the area");
		}
	}

	public String getCoordinates(){
		return String.format("(%d,%d,%s)", position.getAxisX(), position.getAxisY(), position.getDirection());
	}
}
