package sequencefinder;

public class SequenceFinderApp {

	public static void main(String[] args) {

		
		/*
		 * Instructions were too ambiguous...
		 * Do both!
		 * 		
		 * 		given [5,20,21,14,15,16,17]
		 * 
		 * 		-- consecutive --
		 * 		then 4 because [14,15,16,17]
		 * AND
		 * 		-- none consecutive --
		 * 		then 5 because [5,14,15,16,17]
		 */


		ArrayFiller arrayfiller = new ArrayFiller();
		SequenceFinder sequencefinder = new SequenceFinder();
		ConsecutiveFinder consecutivefinder = new ConsecutiveFinder();
		
		String numArray = arrayfiller.menu();
		
		consecutivefinder.findLIS(numArray);
		
		sequencefinder.findLIS(numArray);
		

	}

}
