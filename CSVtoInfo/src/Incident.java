import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Incident {
	
	String calldatetime;
	String callnumber;
	String description;
	String district;
	String incidentlocation;
	String location;
	String location_address;
	String location_city;
	String location_state;
	String location_zip;
	String priority;
	String recordid;
	
	public Incident(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l)
	{
		calldatetime = a;
		callnumber = b;
		description = c;
		district = d;
		incidentlocation = e;
		location = f;
		location_address = g;
		location_city = h;
		location_state = i;
		location_zip = j;
		priority = k;
		recordid = l;
	}
	
	public void fillLocation()
	{
		if(location.equals("NODATA"))
		{
			if(!location_address.equals("NODATA"))
			{
				URL url;
				String key = "AIzaSyAyZq5txQIJBAR9PtokiqNWc37aFUy_J_A";
				String link = "https://maps.googleapis.com/maps/api/geocode/json?address="+location_address+location_city+location_state+location_zip+"&key="+key;
				try 
				{
					url = new URL(link);
					URLConnection con = url.openConnection();
					InputStream is = con.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String line = null;
					while((line = br.readLine()) != null)
					{
						if(line.contains("\"location\""))
						{
							String lat = br.readLine();
							String lng = br.readLine();
							
							lat = lat.replace("\"", "");
							lat = lat.replace("lat", "");
							lat = lat.replace("lng", "");
							lat = lat.replace(":", "");
							lat = lat.replace(",", "");
							lat = lat.replace(" ", "");
							lat = lat.trim();
							
							lng = lng.replace("\"", "");
							lng = lng.replace("lat", "");
							lng = lng.replace("lng", "");
							lng = lng.replace(":", "");
							lng = lng.replace(",", "");
							lng = lng.replace(" ", "");
							lng = lng.trim();
							String dest = lat+" "+lng;
							System.out.println(dest);
							location = dest;
						}
					}
				} 
				catch (MalformedURLException e) 
				{
					System.err.println("Error reading from link");
				} catch (IOException e) {
					System.err.println("Not data found");
				}
			}
		}
	}

	public void print()
	{
		System.out.println(calldatetime+" "+callnumber+" "+description+" "+district+" "
									   +incidentlocation+" "+location+" "+location_address+" "
				                       +location_city+" "+location_state+" "+location_zip+" "+priority+" "+recordid);
	}
}
