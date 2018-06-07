package eventos.com.vibe.app.vibeeventos;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import eventos.com.vibe.app.vibeeventos.Adapters.EventListsAdapter;
import eventos.com.vibe.app.vibeeventos.model.Event;
import eventos.com.vibe.app.vibeeventos.remote.ApiUtils;
import eventos.com.vibe.app.vibeeventos.remote.VibeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progress;
    private ListView listViewCollects;
    private List<Event> events;
    private VibeService vibeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCollects = (ListView) findViewById(R.id.listParticipants);


        vibeService = ApiUtils.getUserService();

        progress  = new ProgressDialog(this);
        progress.setTitle("Carregando");
        progress.setMessage("Aguarde...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog

        listEvents();
    }

    public void listEvents(){

        progress.show();

        Call<List<Event>> call = vibeService.getEvents(-1);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.code() == 200){
                    events = (List<Event>) response.body();
                    listViewCollects.setAdapter(new EventListsAdapter(getApplicationContext(), events));
                }else{
                    Toast.makeText(MainActivity.this, "erro na resposta", Toast.LENGTH_SHORT).show();
                }
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });

    }
}
