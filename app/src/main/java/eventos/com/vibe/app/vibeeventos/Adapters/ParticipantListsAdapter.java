package eventos.com.vibe.app.vibeeventos.Adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eventos.com.vibe.app.vibeeventos.R;
import eventos.com.vibe.app.vibeeventos.model.Event;
import eventos.com.vibe.app.vibeeventos.model.ListParticipants;
import eventos.com.vibe.app.vibeeventos.model.Participants;


public class ParticipantListsAdapter extends ArrayAdapter<ListParticipants> {

    private Context context;
    private List<ListParticipants> listparticipants;


    public ParticipantListsAdapter(Context context, List<ListParticipants> listparticipants){
        super(context, R.layout.participant_row_layout, listparticipants);
        this.context = context;
        this.listparticipants = listparticipants;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.participant_row_layout, parent, false);

        final ListParticipants listparticipant = listparticipants.get(position);



        TextView Nome = (TextView) convertView.findViewById(R.id.textNome);
        Nome.setText(listparticipant.getNome());

        TextView Checkin = (TextView) convertView.findViewById(R.id.textCheckIn);


        //Destaque para participantes qeu não possuem checkin
        if(listparticipant.getCheckIn() == null ){
            Checkin.setTextColor(Color.RED);
            Checkin.setText("checkin: Sem CheckIn");
        }else{
            Checkin.setText("checkin: " + listparticipant.getCheckIn());
        }

        return convertView;
    }
}
