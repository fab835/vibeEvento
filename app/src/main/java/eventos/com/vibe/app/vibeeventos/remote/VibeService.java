package eventos.com.vibe.app.vibeeventos.remote;


import com.google.gson.JsonObject;

import java.util.List;

import eventos.com.vibe.app.vibeeventos.model.Event;
import eventos.com.vibe.app.vibeeventos.model.ListParticipants;
import eventos.com.vibe.app.vibeeventos.model.ParticipantDetail;
import eventos.com.vibe.app.vibeeventos.model.Participants;
import eventos.com.vibe.app.vibeeventos.model.ResObj;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface VibeService {

    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
    @GET("Evento/EventosAtivosDoCliente")
    Call<List<Event>> getEvents(@Query("idCliente") int userId);

    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
    @POST("Evento/ParticipantesDoEvento")
    Call<Participants> getParticipants(@Query("idEvento") int eventId,@Body JsonObject body);

    @Headers({"Content-Type: application/json", "Cache-Control: no-cache"})
    @GET("Participante/ObterParticipante")
    Call<ParticipantDetail> getParticipantDetails(@Query("idParticipante") int participantId);

}
