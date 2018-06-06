package eventos.com.vibe.app.vibeeventos.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eventos.com.vibe.app.vibeeventos.R;
import eventos.com.vibe.app.vibeeventos.model.Event;


public class EventListsAdapter extends ArrayAdapter<Event> {

    private Context context;
    private List<Event> events;


    public EventListsAdapter(Context context, List<Event> events){
        super(context, R.layout.events_row_layout, events);
        this.context = context;
        this.events = events;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.events_row_layout, parent, false);

        Event event = events.get(position);
        ImageView userFoto = (ImageView) convertView.findViewById(R.id.userFoto);
        try {
            //decode base64 string to image
            byte[] imageBytes = Base64.decode(event.getClienteImagem().split(",")[1], Base64.DEFAULT);
            Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            userFoto.setImageBitmap(decodedImage);
        }catch (Exception e){
            Toast.makeText(context, "erro na foto", Toast.LENGTH_SHORT).show();
            userFoto.setImageResource(R.drawable.semimg);
        }

        ImageView eventFoto = (ImageView) convertView.findViewById(R.id.eventFoto);
        try {
            //decode base64 string to image
            byte[] imageBytes = Base64.decode(event.getImagem().split(",")[1], Base64.DEFAULT);
            Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            eventFoto.setImageBitmap(decodedImage);
        }catch (Exception e){
            Toast.makeText(context, "erro na foto", Toast.LENGTH_SHORT).show();
            eventFoto.setImageResource(R.drawable.semimg);
        }

        TextView textViewTitle = (TextView) convertView.findViewById(R.id.textTitle);
        textViewTitle.setText(event.getNome());

        TextView textViewDesc = (TextView) convertView.findViewById(R.id.textDesc);
        textViewDesc.setText(event.getLocal());

        TextView Inicio = (TextView) convertView.findViewById(R.id.textDesc2);
        Inicio.setText("Início: " + event.getInicio());

        TextView Quando = (TextView) convertView.findViewById(R.id.textDesc3);
        Quando.setText("Quando: " + event.getQuando());

        Button btnAction = (Button) convertView.findViewById(R.id.btnParticipate);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
