import java.util.*;


public final class PolynomialOperations {
	
	/*
	 * @param p polynomial
	 * @param num value to evaluate
	 */
	private void evaluate(Polynomial p,float num){
		double result =0;
		LinkedHashMap<Integer,Integer> poly = p.getPolynomial();
		for (Integer i : poly.keySet()) {
			result+= poly.get(i) * Math.pow(num, i);
		}
		System.out.println("Result of evaluation: "+ result);
	}
	/*
	 * @param p Polynomial object
	 * find degree of polynomial
	 */
	private int degree(Polynomial p){
		LinkedHashMap<Integer,Integer> poly = p.getPolynomial();
		Integer degreeP = Collections.max(poly.keySet());
		return degreeP;
	}
	
	/*
	 * @param poly1 first polynomial
	 * @param poly2 second polynomial
	 * multiplication of 2 polynomial
	 */
	private void multiplyPoly(Polynomial poly1, Polynomial poly2){
		LinkedHashMap<Integer,Integer> p1 = poly1.getPolynomial();
		LinkedHashMap<Integer,Integer> p2 = poly2.getPolynomial();
		LinkedHashMap<Integer,Integer> res = new LinkedHashMap<Integer,Integer>();
		int exp=0,t=0,coeff=0;
		for(Integer i : p1.keySet()){
			for(Integer j : p2.keySet()){
				exp = i+j;
				if(res.containsKey(exp)){
					t = res.get(exp);
					coeff = t + p1.get(i)*p2.get(j);
					res.put(exp,coeff);
				}
				else{
					coeff = p1.get(i)*p2.get(j);
					res.put(exp,coeff);
				}
			}
		}
		Polynomial fpoly = new Polynomial(res);
		fpoly.displayPolynomial();
	
	}
	
	/*
	 * @param poly1 first polynomial
	 * @param poly2 second polynomial
	 * addition of 2 polynomial
	 */
	private void addPoly(Polynomial poly1, Polynomial poly2){
		
		LinkedHashMap<Integer,Integer> p1 = poly1.getPolynomial();
		LinkedHashMap<Integer,Integer> p2 = poly2.getPolynomial();
		LinkedHashMap<Integer,Integer> res = new LinkedHashMap<Integer,Integer>();
		int exp=0,t=0,coeff=0;
		if(degree(poly1)>= degree(poly2)){
			for(Integer i : p1.keySet()){
				if(p2.containsKey(i)){
					exp = i;
					coeff = p1.get(i) +p2.get(i);
					res.put(exp,coeff);
				}
				else{
					exp=i;
					coeff = p1.get(i);
					res.put(i, coeff);
				}
			}
		}
		else {
			for(Integer i : p2.keySet()){
				if(p1.containsKey(i)){
					exp = i;
					coeff = p2.get(i) +p1.get(i);
					res.put(exp,coeff);
				}
				else{
					exp=i;
					coeff = p2.get(i);
					res.put(i, coeff);
				}
			}
		}
		
		
		
		Polynomial fpoly = new Polynomial(res);
		fpoly.displayPolynomial();
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Input of 2 polynomials
		System.out.println("Input for first polynomial: ");
		Polynomial poly1 = new Polynomial();
		poly1.displayPolynomial();
		System.out.println("Input for second polynomial: ");
		Polynomial poly2 = new Polynomial();
		poly2.displayPolynomial();
		
		/*
		 * Menu for choosing method
		 */
		PolynomialOperations obj = new PolynomialOperations();
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag){
			System.out.println("\n\nMENU : \n"
					+ "1. Evalute the 2 polynomials \n"
					+ "2. Find degree of the 2 polynomials \n"
					+ "3. Add 2 polynomials \n"
					+ "4. Multiply 2 polynomials \n"
					+ "0. Exit \n");
			System.out.println("Enter your choice: ");
			int choice = input.nextInt();
			switch(choice){
			
			case 1 : 
						 System.out.println("Enter num for first polynomial: ");
						 int num = input.nextInt();
						 obj.evaluate(poly1, num);
						 System.out.println("Enter num for second polynomial: ");
						 num = input.nextInt();
						 obj.evaluate(poly2, num);
						 break;
					
			case 2 : 
					 System.out.print("Degree of first polynomial: ");
					 System.out.println(obj.degree(poly1));
					 System.out.print("Degree of second polynomial: ");
					 System.out.println(obj.degree(poly2));
					 break;
					
			case 3 : 
						System.out.println("Addition of two polynomials: ");
						obj.addPoly(poly1,poly2);
						break;
					
			case 4 : 
					 System.out.println("Multiplication of two polynomials: ");
					 obj.multiplyPoly(poly1,poly2);
					 break;
					
			case 0 : flag = false;
					 break;
			default: System.out.println("Wrong choice! Try again.");
							 
			}
		}
		input.close();
	}

}
