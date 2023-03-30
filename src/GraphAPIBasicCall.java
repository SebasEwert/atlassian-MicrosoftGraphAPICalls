
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GraphAPIBasicCall {
    public static void main(String[] args) {
        String graphEndpoint = "https://graph.microsoft.com/v1.0/me";

        // Replace with your access token
        String accessToken = "INSERT_ACCESS_TOKEN_HERE";


        try {
            URL url = new URL(graphEndpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Set the Authorization header with the access token
            String authHeader = "Bearer " + accessToken;
            conn.setRequestProperty("Authorization", authHeader);

            // Send the request and read the response
            int responseCode = conn.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Print the response
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


  //  This code creates an HTTP GET request to the Microsoft Graph API endpoint https://graph.microsoft.com/v1.0/me
  //  and sets the Authorization header with the access token. The response is then printed to the console.
  //  Note that you need to replace INSERT_ACCESS_TOKEN_HERE with your actual access token.



}
