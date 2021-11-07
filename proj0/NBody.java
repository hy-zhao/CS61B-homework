public class NBody{
	// public static int Num;
    // public static double radius;

    public static double readRadius(String s){
		In in = new In(s);

		int Num = in.readInt();
		double radius = in.readDouble();

		String thirdItemInFile = in.readString();
		System.out.println(thirdItemInFile);
		// String fourthItemInFile = in.readString();
		// double fifthItemInFile = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String s){
		In in = new In(s);

		int Num = in.readInt();

        Body[] bodies = new Body[Num];
		double radius = in.readDouble();

        for(int i=0; i<Num; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();

            bodies[i] = new Body(xP, yP, xV, yV, m, img);
        }
		// String fourthItemInFile = in.readString();
		// double fifthItemInFile = in.readDouble();
        return bodies;
    }

    public static void main(String[] arg){
        double T = arg[0];
        double dt = arg[1];
        String filename = arg[2];
    }


}
