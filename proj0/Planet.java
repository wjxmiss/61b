public class Planet {
	public double xxPos; //current x position
	public double yyPos; //current y position
	public double xxVel; //current velocity in the x direction
	public double yyVel; //current velocity in the y direction
	public double mass;
	public String imgFileName; //the name of an image that depicts the planet
	public static double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet P){
		xxPos = P.xxPos;
		yyPos = P.yyPos;
		xxVel = P.xxVel;
		yyVel = P.yyVel;
		mass = P.mass;
		imgFileName = P.imgFileName;
	}

	public double calcDistance(Planet P){
		double d = (P.xxPos - xxPos)*(P.xxPos - xxPos) + (P.yyPos - yyPos)*(P.yyPos - yyPos);
		d = Math.sqrt(d);
		return d;
	}

	public double calcForceExertedBy(Planet P){
		double r = calcDistance(P);
		double F = (G*P.mass*mass)/(r*r);
		return F;
	}

	public double calcForceExertedByX(Planet P){
		double r = calcDistance(P);
		double F = (G*P.mass*mass)/(r*r);
		double dx = P.xxPos - xxPos;
		return F*dx/r;
	}

	public double calcForceExertedByY(Planet P){
		double r = calcDistance(P);
		double F = (G*P.mass*mass)/(r*r);
		double dy = P.yyPos - yyPos;
		return F*dy/r;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netForceX=0;
		for(Planet P : allPlanets){
			if(P.equals(this)) continue;
			netForceX = netForceX + calcForceExertedByX(P);
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double netForceY=0;
		for(Planet P : allPlanets){
			if(P.equals(this)) continue;
			netForceY = netForceY + calcForceExertedByY(P);
		}
		return netForceY;
	}

	public void update(double dt, double fX, double fY){
		xxVel = xxVel + dt*fX/mass;
		yyVel = yyVel + dt*fY/mass;
		xxPos = xxPos + dt*xxVel;
		yyPos = yyPos + dt*yyVel;
	}

	public void draw(){
		StdDraw.picture(xxPos,yyPos, "images/"+imgFileName);
	}
}
