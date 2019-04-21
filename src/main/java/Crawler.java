import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class Crawler {
    private Client client;
    private WebTarget webTarget;

    public void init(String item) {
        client = JerseyClientBuilder.newClient();
        webTarget = client.target("https://www.albion-online-data.com/api/v1/stats/Charts/" + item);
    }
    public void getResponse() {
        //Map<String, String> response = new HashMap<>();
        Response response = webTarget.request().get();
        System.out.print("response is : " + response.hasEntity());
    }
}
