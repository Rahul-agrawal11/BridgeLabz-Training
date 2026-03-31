// Suppose you have to divide 14 pens among 3 students equally. Write a program to find how many pens each student will get if the pens must be divided equally. Also, find the remaining non-distributed pens.

class DividingPens {
    public static void main (String[] args) {
	    int totalPens = 14;
		int totalStudents = 3;
		
		int distributedPen = totalPens / totalStudents;
		int nonDistributedPen = totalPens % totalStudents;
		
		System.out.println("The Pen Per Student is " + distributedPen + " and the remaining pen not distributed is " + nonDistributedPen);
	}
}