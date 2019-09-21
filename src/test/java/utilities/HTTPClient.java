package test.java.utilities;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class HTTPClient {

    public void createBookingPostRequest() throws Exception {
        String requestUrl =  PropertyManager.getInstance().getRequestUrl();

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(requestUrl);

        //TODO: To refactor and have the values passed as parameters from the caller function
        String json = "{\"firstname\":\"John\",\"lastname\":\"Smith\",\"totalprice\":\"4\",\"depositpaid\":\"true\",\"bookingdates\":{\"checkin\":\"2019-09-21\",\"checkout\":\"2019-09-21\"}}";
        StringEntity entity = new StringEntity(json);
        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        client.execute(post);
    }
}
