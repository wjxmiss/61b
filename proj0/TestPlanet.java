/**
 *	Tests the Planet class
 */
public class TestPlanet {
	public static void main(String[] args){
		Planet P1 = new Planet(1.0e12, 2.0e11, 0.0, 0.0, 2.0e30, "sun.gif");
		Planet P2 = new Planet(2.3e12, 9.5e11, 0.0, 0.0, 6.0e26, "saturn.gif");
		System.out.println(P2.calcForceExertedBy(P1));
	}
}