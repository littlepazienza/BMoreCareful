import java.util.ArrayList;
import java.util.Scanner;

public class Info 
{
	public static void main(String[] args)
	{
		String unorganizedInput = "\"2019-02-11T12:15:00.000\",\"P190421400\",\"ASSIST OFFICER\",\"CD\",\"BOOKER T WASHINGTON MIDDLE\",,,\"BOOKER T WASHINGTON MIDDLE BALTIMORE\",\"MD\",,\"Emergency\",\"4242711\"\r\n" + 
				"\"2019-02-10T19:37:00.000\",\"P190412734\",\"ASSIST FIRE DEPT\",\"WD\",\"800 VINE ST\",\"POINT (-76.629806 39.290575)\",\"800 VINE ST\",\"BALTIMORE\",\"MD\",,\"Emergency\",\"4240973\"\r\n" + 
				"\"2019-02-08T15:09:00.000\",\"P190392439\",\"ASSIST FIRE DEPT\",\"NE\",\"BELAIR RD/CHESTERFIELD AV\",,\"BELAIR RD\",\"BALTIMORE\",\"MD\",,\"Emergency\",\"4233355\"\r\n" + 
				"\"2019-02-03T22:35:00.000\",\"P190343004\",\"Immediate Inc\",\"CD\",\"600 MUCCULLUGH CIRCLE\",,\"600 MUCCULLUGH CIRCLE\",\"BALTIMORE\",\"MD\",,\"Emergency\",\"4216047\"\r\n" + 
				"\"2019-02-03T14:33:00.000\",\"P190341582\",\"Immediate Inc\",\"WD\",\"800 N FREMONT AV\",\"POINT (-76.633988 39.298211)\",\"800 N FREMONT AV\",\"BALTIMORE\",\"MD\",,\"Emergency\",\"4214761\"\r\n" + 
				"\"2019-02-01T11:47:00.000\",\"P190321204\",\"ASSIST FIRE DEPT\",\"ED\",\"900 MC KIM ST\",,\"900 MC KIM ST\",\"BALTIMORE\",\"MD\",,\"Emergency\",\"4208228\"\r\n" + 
				"\"2019-01-31T23:51:00.000\",\"P190313729\",\"Immediate Inc\",\"SE\",\"E FAYETTE ST/N PORT ST\",,\"E FAYETTE ST\",\"ST BALTIMORE\",\"MD\",,\"Emergency\",\"4207125\"";
		ArrayList<String[]> data = new ArrayList<>();
		
		try(Scanner input = new Scanner(unorganizedInput))
		{
			while(input.hasNextLine())
			{
				String temp = input.nextLine();
				
				temp = temp.replace("\"", "");
				temp = temp.replace("POINT", "");
				temp = temp.replace("(", "");
				temp = temp.replace(")", "");
				
				String[] tempArr = new String[12];
				
				Scanner line = new Scanner(temp);
				line.useDelimiter(",");
				
				int counter = 0;
				while(line.hasNext())
				{
					tempArr[counter] = line.next();
					counter++;
				}
				
				data.add(tempArr);
				line.close();
			}
		}
		
		for (int i = 0; i < data.size(); i++) 
		{
			for (int j = 0; j < data.get(i).length; j++) 
			{
				if(data.get(i)[j].equals(""))
				{
					data.get(i)[j] = "NODATA";
				}
			}
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
		 *printData(data) prints everything
		 *printRow(data, row) prints a specific call
		 *printCol(data, col) REFER TO COL DATA ABOVE
		 */
		
	}
	
	public static void printData(ArrayList<String[]> data)
	{
		for(int i = 0; i < data.size(); i++)
		{
			for(int j = 0; j < data.get(i).length; j++)
			{
				System.out.print(data.get(i)[j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void printCol(ArrayList<String[]> data, int col)
	{
		for(int i = 0; i < data.size(); i++)
		{
		    System.out.println(data.get(i)[col]);
		}
	}
	
	public static void printRow(ArrayList<String[]> data, int row)
	{
		for(int i = 0; i < data.get(row).length; i++)
		{
		    System.out.print(data.get(row)[i]+" ");
		}
		System.out.println();
	}
}
