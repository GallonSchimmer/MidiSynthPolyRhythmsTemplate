package polyRythmArrayLoop;

public class threeFourPoly {
	
	public static void main(String[] args) {
		
		//Three four
		//1 2 3 4 1 2 3 4 1 2 3 4 
		//1 2 3 1 2 3 1 2 3 1 2 3
		
		//sounds on 1
		//1 - - - 1 - - - 1 - - -
		//1 - - 1 - - 1 - - 1 - -
		
		
		//try first with a number to be seen each every 4 beats and at the same time another every 3 beats
		String[] fourThree = new String[] { "34", " ", " ", "3", "4", " ", "3", " ", "4", "3", " ", " "};
		try {
			
			for (int j = 0; j < 12; j++) { //12 times is how many times the fourThree compass (array) will play
				
			
			
		for (int i = 0; i < fourThree.length; i++) {// the loop for the notes
			
			Thread.sleep(250);									// 250 the silence feel like a flow
			//System.out.println("  i : " + fourThree[i]);
			System.out.println( fourThree[i]);
			
		}
		
		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

//https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
//https://www.w3schools.com/java/java_arrays_multi.asp



