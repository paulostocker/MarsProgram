package br.com.stkstocker.contaazul.model;

public class Terrain {

	int width;
	int height;
	
	public Terrain(int w, int h){
		this.width = w;
		this.height = h;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
