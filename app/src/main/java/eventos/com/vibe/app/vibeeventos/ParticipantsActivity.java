package eventos.com.vibe.app.vibeeventos;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import eventos.com.vibe.app.vibeeventos.Adapters.ParticipantListsAdapter;
import eventos.com.vibe.app.vibeeventos.model.ParticipantDetail;
import eventos.com.vibe.app.vibeeventos.model.Participants;
import eventos.com.vibe.app.vibeeventos.remote.ApiUtils;
import eventos.com.vibe.app.vibeeventos.remote.VibeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParticipantsActivity extends AppCompatActivity {

    private ProgressDialog progress;
    private ListView listViewParticipants;
    private Participants participants;
    private ParticipantDetail participantDetail;
    private VibeService vibeService;
    private int pagecounter;
    private int eventId;
    private int totalpages;
    private ImageButton btnLoadMore;
    private ImageButton btnLoadBack;
    private TextView txtPages;
    private TextView txtInicio;
    private TextView txtQuando;
    private TextView txtLocal;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);

        listViewParticipants = (ListView) findViewById(R.id.listParticipants);
        Bundle b = getIntent().getExtras();

        // toolbar
        toolbar = (Toolbar) findViewById(R.id.tb_participants);
        toolbar.setTitle( b.getString("EventNome"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vibeService = ApiUtils.getUserService();

        progress  = new ProgressDialog(this);
        progress.setTitle("Carregando");
        progress.setMessage("Aguarde...");
        progress.setCancelable(false);

        btnLoadBack = (ImageButton) findViewById(R.id.btnPrev);
        btnLoadMore= (ImageButton) findViewById(R.id.btnNext);
        txtPages = (TextView) findViewById(R.id.pages);
        txtInicio = (TextView) findViewById(R.id.txtInicio);
        txtLocal = (TextView) findViewById(R.id.txtlocal);
        txtQuando = (TextView) findViewById(R.id.txtQuando);

        txtInicio.setText( b.getString("EventInicio"));
        txtLocal.setText( b.getString("EventLocal"));
        txtQuando.setText( b.getString("EventQuando"));

        totalpages = 1;

        pagecounter = 1;
//        try {
            listParticipants(b.getInt("EventId"),1);
            eventId = b.getInt("EventId");
//        }catch (Exception e){
//            Intent c = new Intent(this, MainActivity.class);
//            startActivity(c);
//        }

        btnLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagecounter < totalpages){
                    pagecounter += 1;
                    listParticipants(eventId, pagecounter);
                }
            }
        });


        btnLoadBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (pagecounter > 1){
                pagecounter -= 1;
                listParticipants(eventId, pagecounter);
            }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public void listParticipants(int eventId,int page){
        progress.show();
        JsonObject body = new JsonObject();
        body.addProperty("Pagina", page);
        body.addProperty("RegistrosPorPagina", 15);
        Call<Participants> call = vibeService.getParticipants(eventId,body);
        call.enqueue(new Callback<Participants>() {
            @Override
            public void onResponse(Call<Participants> call, Response<Participants> response) {
                if (response.code() == 200){
                    participants = (Participants) response.body();
                    listViewParticipants.setAdapter(new ParticipantListsAdapter(getApplicationContext(), participants.getLista()));

                    listViewParticipants.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                             participantDetail(participants.getLista().get(position).getId());
                        }
                    });

                    totalpages = participants.getPaginator().getTotalPaginas();
                    txtPages.setText(pagecounter+"/"+totalpages);
                }else{
                    Toast.makeText(ParticipantsActivity.this, "erro na resposta = " + response.code(), Toast.LENGTH_SHORT).show();
                }
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<Participants> call, Throwable t) {
                Toast.makeText(ParticipantsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }

    public void participantDetail(final int participantId) {
        progress.show();

        Call<ParticipantDetail> call = vibeService.getParticipantDetails(participantId);
        call.enqueue(new Callback<ParticipantDetail>() {
            @Override
            public void onResponse(Call<ParticipantDetail> call, Response<ParticipantDetail> response) {
                if (response.code() == 200) {
                    participantDetail = (ParticipantDetail) response.body();

                    final Dialog d = new Dialog(ParticipantsActivity.this);
                    d.setContentView(R.layout.dialog_participant);
                    d.setCancelable(true);

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(ParticipantsActivity.this);
                    final View mView = getLayoutInflater().inflate(R.layout.dialog_participant, null);

                    final ImageButton btnClose = (ImageButton) mView.findViewById(R.id.btnClose);
                    final ImageView imgFoto = (ImageView) mView.findViewById(R.id.userFoto);
                    final TextView nome = (TextView) mView.findViewById(R.id.txtNome);
                    final TextView email = (TextView) mView.findViewById(R.id.txtEmail);
                    final TextView cadastro = (TextView) mView.findViewById(R.id.txtDataCadastro);
                    final TextView checkin = (TextView) mView.findViewById(R.id.txtCheckin);

                    nome.setText(participantDetail.getNome());
                    email.setText(participantDetail.getEmail());
                    cadastro.setText(participantDetail.getDataCadastro());

                    //Destaque para participantes qeu não possuem checkin
                    if(participantDetail.getCheckIn() == null ){
                        checkin.setTextColor(Color.RED);
                        checkin.setText("Sem CheckIn");
                    }else{
                        checkin.setText(participantDetail.getCheckIn());
                    }

                    try {
                        if (participantDetail.getAssinatura() != null) {
                            //decode base64 string to image
                            byte[] imageBytes = Base64.decode(participantDetail.getAssinatura(), Base64.DEFAULT);
                            Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                            imgFoto.setImageBitmap(decodedImage);
                        }else{
                            imgFoto.setScaleX(0);
                            imgFoto.setScaleY(0);
                        }
                    }catch (Exception e){
                        Toast.makeText(ParticipantsActivity.this, "erro na foto", Toast.LENGTH_SHORT).show();
                    }

                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();

                    btnClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();


                } else {
                    Toast.makeText(ParticipantsActivity.this, "erro na resposta = " + response.code(), Toast.LENGTH_SHORT).show();
                }
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<ParticipantDetail> call, Throwable t) {
                Toast.makeText(ParticipantsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }
}
