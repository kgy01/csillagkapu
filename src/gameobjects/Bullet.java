package gameobjects;

import main.Engine;
import utils.Coordinates;

public class Bullet {
	// Aktuális pozíció
	private Coordinates position;
	private Coordinates direction;
	private Engine engine;
	private int color;
	
	public Bullet(Coordinates _position, Coordinates _direction, int _color, Engine _engine) {
		position = _position;
		direction = _direction;
		color = _color;
		engine = _engine;
	}
	
	public void start() {
		position = position.add(direction);
		Field nextfield = engine.getField(position);
		while (!nextfield.hit(this)) {
			position = position.add(direction);
			nextfield = engine.getField(position);
		}
		System.out.println("BULLET DISPOSED pos:" + position.toString() + " col:" + toString());
	}
	
	public String toString() {
		switch (color) {
		case Portal.BLUE:
			return "blue";
		case Portal.YELLOW:
			return "yellow";
		case Portal.RED:
			return "red";
		case Portal.GREEN:
			return "green";
		}
		return "";
	}
	
	// Szín lekérdezése
	public int getColor() {
		return color;
	}
	
	public Coordinates getPosition() {
		return position;
	}
	
	public Coordinates getDirection() {
		return direction;
	}
	
	public void setPosition(Coordinates _position) {
		position = _position;
	}
	
	public void setDirection(Coordinates _direction) {
		direction = _direction;
	}
}
