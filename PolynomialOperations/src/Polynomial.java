import java.util.*;

public final class Polynomial{
	private final LinkedHashMap<Integer,Integer> poly = new LinkedHashMap<Integer,Integer>();
	int i,j;
	Scanner input =new Scanner(System.in);
	
	/*
	 * Constructor to initialize polynomial
	 */
	public Polynomial(){
		System.out.println("Enter the exponent and coefficient of  polynomial (DESC)");
		int exp = -1;
		int coeff;
		while(exp !=0){
			exp = input.nextInt();
			coeff = input.nextInt();
			System.out.println("____");
			if(coeff!=0){
				poly.put(exp,coeff);
			}
			
		}
	}
	
	/*
	 * Constructor to initialize polynomial using parameterized method
	 */
	public Polynomial(LinkedHashMap<Integer,Integer> p){
		for(Integer i : p.keySet()){
			poly.put(i, p.get(i));
		}
	}
	
	/*
	 * @return polynomial as HashMap(exponent,coefficient)
	 */
	public LinkedHashMap<Integer,Integer> getPolynomial(){
		return poly;
	}
	
	/*
	 * display polynomial as a String
	 */
	public void displayPolynomial(){
		Integer min = Collections.min(poly.keySet());
		System.out.print("Polynimal: ");
		for (Integer i : poly.keySet()) {
				if( i == min){
					System.out.println(poly.get(i));
				}
				else{
					System.out.print(poly.get(i)+"X^"+i+" + ");
				}			  
		}
	}
}
