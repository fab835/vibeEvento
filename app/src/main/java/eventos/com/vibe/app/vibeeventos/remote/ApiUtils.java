package eventos.com.vibe.app.vibeeventos.remote;

/**
 * Created by Fábio on 15/02/2018.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://receptivawebapi.azurewebsites.net/api/";

    public static VibeService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(VibeService.class);
    }
}
