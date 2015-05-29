import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class testGetPost {
 
	public static void main(String[] args) throws Exception {
		testGetPost http = new testGetPost();
		
		System.out.println("Test 1 - Send Http GET request");
		http.sendGet();
 
		System.out.println("\nTest 2 - Send Http POST request");
		http.sendPost();
	}
	
	/**
	 *  HTTP POST request
	 *  @throws Exceptio
	 */
	private void sendGet() throws Exception {
 
		String requestURI = "https://api.constantcontact.com/v2/account/info?api_key=9q5v5xkntkang5mzfe3v96k4";
		 
		URL obj = new URL(requestURI);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional. default is GET
		con.setRequestMethod("GET");
		
		//add request header
		con.setRequestProperty("Authorization", "Bearer 18aec063-d5a0-4f06-96fc-15ca281dc99c");
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + requestURI);
		System.out.println("Response Code : " + responseCode);
		
		// Display the response
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
	}
		 
	/**
	 * HTTP POST request
	 * @throws Exception
	 */
	private void sendPost() throws Exception {
 
		String requestURI = "https://api.constantcontact.com/v2/account/verifiedemailaddresses?api_key=9q5v5xkntkang5mzfe3v96k4";
		 
		URL obj = new URL(requestURI);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("POST");
		
		//add request header
		con.setRequestProperty("Authorization", "Bearer 18aec063-d5a0-4f06-96fc-15ca281dc99c");
		con.setRequestProperty("Content-Type", "application/json");
		con.addRequestProperty("email_address", "mnravi.1@gmail.com");
		
		// Send post request
		/*con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.flush();
		wr.close();*/
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + requestURI);
		System.out.println("Response Code : " + responseCode);
 
		// Display the response
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
	 
}
