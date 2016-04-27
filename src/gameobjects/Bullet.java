package gameobjects;

import main.Engine;
import utils.Coordinates;
import utils.MyColor;

public class Bullet {
	// Aktuális pozíció
	private Coordinates position;
	private Coordinates direction;
	private Engine engine;
	private MyColor color;
	
	public Bullet(Coordinates _position, Coordinates _direction, MyColor _color, Engine _engine) {
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
		case BLUE:
			return "blue";
		case YELLOW:
			return "yellow";
		case RED:
			return "red";
		case GREEN:
			return "green";
		}
		return "";
	}
	
	// Szín lekérdezése
	public MyColor getColor() {
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
