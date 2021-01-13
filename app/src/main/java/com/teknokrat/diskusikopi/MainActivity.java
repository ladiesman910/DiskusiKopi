package com.teknokrat.diskusikopi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gmail(View view) {
        String [] TO = {"ninocahyo.gmail.com"};
        Intent GmailIntent = new Intent(Intent.ACTION_SEND);

        GmailIntent.setData(Uri.parse("mailto: "));
        GmailIntent.setType("message/rfc822");
        GmailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        try {
            startActivity(Intent.createChooser(GmailIntent, "send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(MainActivity.this, "Tidak ada email yang dimasukan", Toast.LENGTH_SHORT).show();
        }
    }

    public void maps(View view) {
        Uri link_maps = Uri.parse("https://goo.gl/maps/NzAQbHS4cQRJGiV36");
        Intent buka_maps = new Intent(Intent.ACTION_VIEW, link_maps);
        startActivity(buka_maps);
    }

    public void telpon(View view) {
        Intent Telp = new Intent(Intent.ACTION_DIAL);
        Telp.setData(Uri.parse("tel: (089631395863)"));
        startActivity(Telp);
    }

    public void whatsapp(View view) {
        String url = "https://api.whatsapp.com/send?phone=+6289631395863";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void profil(View view) {
        Intent i = new Intent(this, profil.class);
        startActivity(i);
    }
}