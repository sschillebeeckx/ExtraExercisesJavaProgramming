package be.abis.shapes.test;

import be.abis.shapes.enumeration.Color;
import be.abis.shapes.exception.AreaTooBigException;
import be.abis.shapes.model.*;

import java.util.List;

public class Client {

	public static void main(String[] args)  {
		
		Point p = new Point();

		Circle c = new Circle(Color.RED,p,2);
		Rectangle r = new Rectangle(Color.BLUE,new Point(),2,3);
		Square s = new Square(Color.YELLOW,new Point(),5.6);
		Triangle t = new Triangle(Color.ORANGE,new Point(),5,8);

		List<Shape> shapes = List.of(c,r,s,t);

		for (Shape sh : shapes){
			System.out.println(sh);
			try {
				System.out.println(sh.checkArea());
			} catch (AreaTooBigException e) {
				System.out.println(e.getMessage());
			}
		}


	}

}
