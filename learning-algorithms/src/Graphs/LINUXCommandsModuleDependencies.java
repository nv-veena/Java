package Graphs;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LINUXCommandsModuleDependencies {
	public final Integer MAXCOMS = 1000;
	public static void main(String[] args) {
		
		LINUXCommandsModuleDependencies d = new LINUXCommandsModuleDependencies();
		Vector<String> inCommands = null;
		String PATH = "C:\\Users\\vvenkatesh\\Downloads\\eclipse-java-oxygen-3-win32-x86_64\\SystemDependencies-master\\"; // IMPORTANT: change to your own path
	
		//Integer N = d.MAXCOMS;
		
		try {
			inCommands = d.readCommandsFromFile(PATH+"SampleInput.txt");
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
		d.runNCommands(inCommands, 20);
		
		System.out.println();
		System.out.println(inCommands);
	}
	public void runNCommands (Vector<String> commands, Integer N) {
		// PRE: commands contains set of commands read in by readCommandsFromFile()
		// POST: executed min(N, all) commands
		
		Map <String, List<String>> c = new HashMap<String, List<String>>();
		ArrayList<String> installed = new ArrayList<String>();
		ArrayList<String> installedSepa = new ArrayList<String>();
		ArrayList<String> allList = new ArrayList<String>();
		
		for (int i=0; i<N; i++){
			if(i==commands.size())
				break;
			
			String[] splitStr = commands.get(i).split("\\s+");
			
			if (splitStr[0].equals("DEPEND")){
				c.put(splitStr[1], new ArrayList<String>());
				
				System.out.println(commands.get(i));
				for (int j=2;j<splitStr.length; j++){
					if (c.containsKey(splitStr[1])){
						c.get(splitStr[1]).add(splitStr[j]);
						allList.add(splitStr[j]);
					}
				}
			
			}
			
			else if (splitStr[0].equals("INSTALL")){
				System.out.println(commands.get(i));
				boolean alreadyInstalled = false;
				if (installed.toString().contains(splitStr[1])){
					System.out.println("   "+splitStr[1]+" is already installed");
					alreadyInstalled = true;
				}
					
				if (!alreadyInstalled){
					installedSepa.add(splitStr[1]);
					for (int j=checkCycleString(splitStr[1],splitStr[1],c).size()-1; j>=0; j--){
						
						if (!installed.contains(checkCycleString(splitStr[1],splitStr[1],c).get(j))){
							System.out.println("   Installing "+checkCycleString(splitStr[1],splitStr[1],c).get(j));
							installed.add((String) checkCycleString(splitStr[1],splitStr[1],c).get(j));
						}
					}
				}

			}
			
			else if (splitStr[0].equals("REMOVE")){
				System.out.println(commands.get(i));
				if (!installed.contains(splitStr[1])){
					System.out.println("   "+splitStr[1]+" is not installed");
					continue;
				}
				if (c.values().toString().contains(splitStr[1]))
					System.out.println("   "+splitStr[1]+" is still needed");
				else{

					installedSepa.remove(splitStr[1]);
					for (int j=0; j<checkCycleString(splitStr[1],splitStr[1],c).size(); j++){
						
						if ( (!installedSepa.contains(checkCycleString(splitStr[1],splitStr[1],c).get(j)))){
							if((timesChecker(allList,(String) checkCycleString(splitStr[1],splitStr[1],c).get(j))==0)){
								
								System.out.println("   Removing "+checkCycleString(splitStr[1],splitStr[1],c).get(j));
								installed.remove(checkCycleString(splitStr[1],splitStr[1],c).get(j));
								if (c.containsKey(checkCycleString(splitStr[1],splitStr[1],c).get(j))){
									for (int w=0; w<c.get(checkCycleString(splitStr[1],splitStr[1],c).get(j)).size(); w++){
										allList.remove(c.get(checkCycleString(splitStr[1],splitStr[1],c).get(j)).get(w));
									}
										
								}

								
							}
						
							
						}
						
					}
							
				}

				
			}
			
			else if (splitStr[0].equals("LIST")){
				System.out.println(commands.get(i));
				for (int j=0; j<installed.size();j++)
					System.out.println("   "+installed.get(j));
			}
			
			else if (splitStr[0].equals("END")){
				System.out.println(commands.get(i));
				break;
			}		
		}
	}
	
	public int timesChecker (ArrayList<String> x, String str){
		int count=0;
		for (int i=0; i<x.size(); i++){
			if (x.get(i).equals(str))
				count++;
		}
		return count;
	}
	
	public ArrayList checkCycleString(String to, String from, Map <String, List<String>> a){
		ArrayList<String> bal = new ArrayList<String>();
		ArrayList<String> listOfAll = new ArrayList<String>();
		return checkCycleStringDoNotCall(from, bal, to, from, a, listOfAll);
	}
	
	public ArrayList checkCycleStringDoNotCall(String iniFrom, ArrayList<String> x, String to, String from, Map <String, List<String>> a, ArrayList n){
		if (!a.containsKey(from)){
			n.add(from);
			return n;
		}
			
		if (a.get(from).contains(to)){
			if (!n.contains(from))
				n.add(from);
			if (!n.contains(to))
				n.add(to);
			return n;
		}
			
		for (int i=a.get(from).size()-1; i>=0;i--){
			int q = a.get(from).size();
			if (!n.contains(from) && a.get(from).size()!=0)
				n.add(from);
			if (n.contains(a.get(from).get(i)))
				n.remove(a.get(from).get(i));
			n.add(a.get(from).get(i));
			if(a.containsKey(a.get(from).get(i))==false){
				//does the member have a key group? If NO-> the element does not work depend then it ends here
				continue;
			}
				
			else {
				
				x.add(a.get(from).get(i));
				if (!n.contains(from))
					n.add(from);
				checkCycleStringDoNotCall(iniFrom, x, to,a.get(from).get(i),a, n);
			}
				
		}
		if (!n.contains(from))
			n.add(from);
		return n;
	}
	
	public Vector<String> readCommandsFromFile(String fInName) throws IOException {
		// PRE: -
		// POST: returns lines from input file as vector of string
		BufferedReader fIn = new BufferedReader(
							 new FileReader(fInName));
		String s;
		Vector<String> comList = new Vector<String>();
		
		while ((s = fIn.readLine()) != null) {
			comList.add(s);
		}
		fIn.close();
		
		return comList;
	}
	
	
	public String readSoln(String fInName, Integer N) throws IOException {
		// PRE: -
		// POST: returns N lines from input file as single string
		BufferedReader fIn = new BufferedReader(
							 new FileReader(fInName));
		String s;
		String out = "";
		Integer i = 0;

		while (((s = fIn.readLine()) != null) && (i <= N)) {
			if ((i != N) || s.startsWith("   ")) // responses to commands start with three spaces
				out += s + System.lineSeparator();
			if (!s.startsWith("   "))  
				i += 1;
		}
		fIn.close();
		
		return out;
	}
}
