package ru.stqa.java.barancev;

public class HelloWorld{

	public static void main (String[] args){
		hello("world");

		Square s = new Square(5);

		Rectangle r = new Rectangle(6, 9);

		System.out.println("Площадь квадрата со строной " + s.l + " равна " + s.area());
		System.out.println("Площадь прямоугольника со стронами " + r.a + " и " + r.b + " равна " + r.area());
	}

	public static void hello(String somebody){
		System.out.println("Hello, " + somebody + "!");
	}
}