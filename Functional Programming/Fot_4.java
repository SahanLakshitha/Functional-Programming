import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fot_4 {
	public static void main(String[] args) {
		readAndWrite();
	}
		
	public static void readAndWrite() {
		List<FootBallRankings> table = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\DTC\\\\eclipse-workspace\\\\Task 5 ex3\\\\Task5-6CS002--main\\\\FB Ranks.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        table.add(new FootBallRankings(Integer.parseInt(values[0]),values[1],Integer.parseInt(values[2]),Integer.parseInt(values[3]),
		        		Integer.parseInt(values[4]),Integer.parseInt(values[5]),Double.parseDouble(values[6])));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nSeveral teams have 20< points");
	    table.stream().filter(team -> team.getPoints() < 20)
	        .forEach(System.out::println);

	    System.out.println();
	    System.out.println("Teams with 35> points");
	    table.stream().filter(team -> team.getPoints() > 35)
	        .forEach(System.out::println);
	    
	    
	    try {
		      FileWriter writer = new FileWriter("Fot_4.txt");
		      writer.write("Several teams have 1< average\n");
		      table.stream().filter(team -> team.getAVG() <1)
		        .forEach(str -> {
		        	try {
		        		
						writer.write(str.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      
		      writer.write("\nTeams with 1> average\n");
		      table.stream().filter(team -> team.getAVG() >1)
		        .forEach(str -> {
		        	try {
		        		
						writer.write(str.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      writer.close();
		      System.out.println("Fot_4.txt created.");
		      
		    } catch (IOException e) {
		      System.out.println("Exception.");
		      e.printStackTrace();
		    }
		}
		
	}
