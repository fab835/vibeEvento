package eventos.com.vibe.app.vibeeventos.remote;

import com.google.gson.JsonObject;

import java.util.List;

import eventos.com.vibe.app.vibeeventos.model.Event;
import eventos.com.vibe.app.vibeeventos.model.ParticipantDetail;
import eventos.com.vibe.app.vibeeventos.model.ResObj;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface VibeService {

    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
    @GET("Evento/EventosAtivosDoCliente")
    Call<List<Event>> getEvents(@Query("idCliente") int userId);



    @FormUrlEncoded
    @POST("Evento/ParticipantesDoEvento")
    Call<ResObj> getParticipants(@Query("idEvento") int eventId, @Field("RegistrosPorPagina") int registrosPorPagina, @Field("Pagina") int pagina);


    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
    @GET("Participante/ObterParticipante")
    Call<List<ParticipantDetail>> getParticipantDetails(@Query("idParticipante") int participantId);

//
//    @FormUrlEncoded
//    @POST("user")
//    Call<ResObj> registration(@Field("email") String email,
//                              @Field("password") String password,
//                              @Field("password_confirmation") String password_confirmation,
//                              @Field("first_name") String first_name,
//                              @Field("last_name") String last_name);
//
//    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
//    @POST("collects")
//    Call<ResObj> createCollect(@Header("Access-Token") String token, @Header("Client") String client, @Header("Uid") String uid, @Body JsonObject body);
//
//    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
//    @GET("collects")
//    Call<ListParticipants<Collect>> getCollects(@Header("Access-Token") String token, @Header("Client") String client, @Header("Uid") String uid);
//
//    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
//    @GET("user/validate_token")
//    Call<ResObj> validateToken(@Header("Access-Token") String token, @Header("Client") String client, @Header("Uid") String uid);
//
//    @DELETE("user/sign_out")
//    Call<ResObj> sign_out(@Header("Access-Token") String token, @Header("Client") String client, @Header("Uid") String uid);
}
