
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GraphAPIBasicCall {

    public static void main(String[] args) throws IOException {
        String script = "$accessToken = 'YOUR_ACCESS_TOKEN';" + "$url = 'https://graph.microsoft.com/v1.0/me/messages';" + "$headers = @{Authorization='Bearer '+$accessToken};" + "$response = Invoke-RestMethod -Uri $url -Headers $headers -Method Get;" + "$response | ConvertTo-Json";
        String[] command = {"powershell.exe", "-Command", script};
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
        String line;
        while ((line = stdInput.readLine()) != null) {
            System.out.println(line);
        }
    }
}
