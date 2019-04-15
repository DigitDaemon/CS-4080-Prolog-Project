package main;

import org.jpl7.*;


public class ColorChecker {

	public static void main(String[] args) {
		
		Query start = new Query ("consult", new Term [] {new Atom ("src/ColorTest.pl")});
		System.out.println("ColorTest has " + (start.hasSolution() ? "Initialized" : "Not Initialized"));
		
		int topleft = 0, topright = 0, bottomleft = 0, bottomright = 0;
		
		
		org.jpl7.Integer lefttop = new org.jpl7.Integer (topleft);
		org.jpl7.Integer leftbottom = new org.jpl7.Integer (bottomleft);
		org.jpl7.Integer righttop = new org.jpl7.Integer(topright);
		org.jpl7.Integer rightbottom = new org.jpl7.Integer(bottomright);
		
		String pattern = "patternThree";
		
		Query check = new Query (pattern, new Term[] {lefttop, leftbottom, righttop, rightbottom});
		
		System.out.println("That pattern is : " + check.hasSolution());
	}

}
