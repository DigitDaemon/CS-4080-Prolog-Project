import org.jpl7.*;


public class ColorChecker {

	public static boolean check(int[] corners) {
		
		Query start = new Query ("consult", new Term [] {new Atom ("src/ColorTest.pl")});
		System.out.println("ColorTest has " + (start.hasSolution() ? "Initialized" : "Not Initialized"));
		
		//int topleft = 0, topright = 0, bottomleft = 0, bottomright = 0;
		
		
		org.jpl7.Integer lefttop = new org.jpl7.Integer (corners[0]);
		org.jpl7.Integer leftbottom = new org.jpl7.Integer (corners[3]);
		org.jpl7.Integer righttop = new org.jpl7.Integer(corners[1]);
		org.jpl7.Integer rightbottom = new org.jpl7.Integer(corners[2]);
		
		String pattern = "patternThree";
		
		Query check = new Query (pattern, new Term[] {lefttop, leftbottom, righttop, rightbottom});
		
		System.out.println("That pattern is : " + check.hasSolution());
	
		return check.hasSolution();
	
	}

}
