import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Info 
{
	
	public static void main(String[] args)
	{
		String unorganizedInput = getFile();
		ArrayList<Incident> data = new ArrayList<>();
		
		try(Scanner input = new Scanner(unorganizedInput))
		{
			while(input.hasNextLine())
			{
				String temp = input.nextLine();
				
				if(temp.equals(""))
					break;
				
				temp = temp.replace("\"", "");
				temp = temp.replace("POINT", "");
				temp = temp.replace("(", "");
				temp = temp.replace(")", "");
				temp = temp.replace(" ", "_");
				temp = temp.trim();
				
				String[] tempArr = new String[12];
				
				Scanner line = new Scanner(temp);
				line.useDelimiter(",");
				
				int counter = 0;
				try {
				while(line.hasNext())
				{
					String next = line.next();
					
					tempArr[counter] = next;
					counter++;
				}
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
				}
				
				
				for(int i = 0; i < tempArr.length; i++)  //Fixes blank data
				{
					if(tempArr[i].equals(""))
					{
						tempArr[i] = "NODATA";
					}
				}
				
				data.add(new Incident(tempArr[0], tempArr[1], tempArr[2], tempArr[3], tempArr[4], tempArr[5], tempArr[6], tempArr[7], tempArr[8], tempArr[9], tempArr[10], tempArr[11]));
				line.close();
			}
		}
		
		for(int i = 0; i < data.size(); i++)
		{
			data.get(i).fillLocation();
		}

		/*   Indexes of info in the array
		 *0  - call date time
		 *1  - call number
		 *2  - description
		 *3  - district
		 *4  - incident location
		 *5  - location
		 *6  - location address
		 *7  - location city
		 *8  - location state
		 *9  - location zip
		 *10 - priority
		 *11 - record id
		 */
		 
		//print(data);
		
	}
	
	public static void print(ArrayList<Incident> thing)
	{
		for(int i = 0; i < thing.size(); i++)
		{
			thing.get(i).print();
		}
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String getFile() {
		
		String hostName = "66.175.216.86";
		int portNumber = 3000;

		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),
						true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(
						new InputStreamReader(System.in))) {
			
		String output = "";	
		String s = in.readLine();
		while(!s.equals("done")) {
			output += s+"\n";
			s = in.readLine();
		}
		return output;

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println(
					"Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
		return "-1";
	}

}
