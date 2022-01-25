import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fot_2 {

	public static void main(String args[]) {
		readAndWrite();
	}
	public static void readAndWrite() {
		// reading from file
		List<FootBallRankings> table = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DTC\\eclipse-workspace\\Task 5 ex3\\Task5-6CS002--main\\FB Ranks.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        table.add(new FootBallRankings(Integer.parseInt(values[0]),values[1],Integer.parseInt(values[2]),Integer.parseInt(values[3]),
		        		Integer.parseInt(values[4]),Integer.parseInt(values[5]),Double.parseDouble(values[6])));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table.stream().forEach(x -> System.out.println(x));
	    System.out.println();
	    table.parallelStream().forEach(System.out::println);    
	    
	 // file writing
	 		try {
 		      FileWriter writer = new FileWriter("Fot_2.txt");
 		     writer.write("\nNormal output\n");
 		     table.forEach(x -> {
 				try {
 					writer.write(x + "\n");
 				} catch (IOException e) {
 					e.printStackTrace();
 				}
 			});
			    writer.write("\nParallel Stream\n");
			      table.parallelStream()
			      .forEach(x -> {
			        	try {
							writer.write(x.toString() + "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
			        });
			      writer.close();
			      System.out.println("Fot_2.txt created.");
			    } catch (IOException e) {
			      System.out.println("Exception.");
			      e.printStackTrace();
	    }

	}
}
