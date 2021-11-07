public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body rocinante){
        return Math.sqrt(Math.pow(this.xxPos - rocinante.xxPos, 2) + Math.pow(this.yyPos - rocinante.yyPos, 2));
    }

    public double calcForceExertedBy(Body rocinante){
        return G * this.mass * rocinante.mass / Math.pow(this.calcDistance(rocinante), 2);
    }

    public double calcForceExertedByX(Body rocinante){
        double force = this.calcForceExertedBy(rocinante);
        return force * (rocinante.xxPos - this.xxPos) / this.calcDistance(rocinante);
    }

    public double calcForceExertedByY(Body rocinante){
        double force = this.calcForceExertedBy(rocinante);
        return force * (rocinante.yyPos - this.yyPos) / this.calcDistance(rocinante);
    }

    public double calcNetForceExertedByX(Body [] allBodys){
        double netX=0;
        for(Body temp: allBodys){
            if(this.equals(temp)){
                continue;
            }
            netX += this.calcForceExertedByX(temp);
        }
        return netX;
    }

    public double calcNetForceExertedByY(Body [] allBodys){
        double netY=0;
        for(Body temp: allBodys){
            if(this.equals(temp)){
                continue;
            }
            netY += this.calcForceExertedByY(temp);
        }
        return netY;
    }

    public void update(double dt, double fX, double fY){
        xxVel += dt * fX/mass;
        yyVel += dt * fY/mass;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

}
