import java.util.Scanner;
public class NBody {

	public static double readRadius(String filename){
		In inputstream = new In(filename);
        inputstream.readLine();
        return inputstream.readDouble();
	}

	public static Planet[] readPlanets(String filename){
		In inputstream = new In(filename);
        int n = inputstream.readInt();
        inputstream.readLine();
        inputstream.readLine();
        Planet[] allPlanets = new Planet[n];
        int i=0;
        //double xP = inputstream.readDouble();
        while(i<n){
        	//double [] parameters = new double [5];
        	/*Scanner scanner = new Scanner(inputstream.readLine());
        	In localstream = new In(scanner);
        	int j=0;
        	while(j<5){
        		parameters[j++] = inputstream.readDouble();
        		System.out.print(parameters[j-1]+" ");
        	}
        	String  ss = inputstream.readString();
        	System.out.println(ss); 
        	allPlanets[i++] = new Planet(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], ss);*/       	
        	allPlanets[i++] = new Planet(inputstream.readDouble(), inputstream.readDouble(), inputstream.readDouble(), inputstream.readDouble(), inputstream.readDouble(), inputstream.readString());
        }
        return allPlanets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] allPlanets = readPlanets(filename);
		double r = readRadius(filename);
		int n = allPlanets.length;

		StdDraw.setScale(-r,r);

		double time = 0.0;

		while(time<=T){
			double[] xForces = new double[n];
			double[] yForces = new double[n];
			int i=0;
			//calculate the net x and y forces for each planet
			for(Planet P:allPlanets){
				xForces[i]=P.calcNetForceExertedByX(allPlanets);
				yForces[i]=P.calcNetForceExertedByY(allPlanets);
				i++;
			}
			//update each of the planets including position, velocity and acceleration
			for(i=0; i<n; i++){
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}
			//draw the background image
			StdDraw.clear();
			StdDraw.picture(0,0, "images/starfield.jpg", 2*r, 2*r);
			for(Planet P:allPlanets){
				P.draw();//draw all of the planets
			}
			StdDraw.show(100);
			time = time + dt;
		}
		//StdAudio.play("audio/2001.mid");
		System.out.println(n);
		System.out.println(r);
		for(Planet P:allPlanets){
			System.out.printf("%12e %12e %12e %12e %12e %12s\n",P.xxPos,P.yyPos,P.xxVel,P.yyVel,P.mass,P.imgFileName);
		}
	}
}
