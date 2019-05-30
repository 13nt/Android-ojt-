package com.example.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWeb;
    private EditText mLocation;
    private EditText mShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeb = findViewById(R.id.web);
        mLocation = findViewById(R.id.location);
        mShare = findViewById(R.id.share);
    }

    public void openWebsite(View view) {
        String url = mWeb.getText().toString();
        Uri webpageuri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpageuri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        String loc = mLocation.getText().toString();
        Uri addressuri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressuri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this");
        }
    }

    public void shareText(View view) {
        String txt = mShare.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with-------")
                .setText(txt)
                .startChooser();
    }
}
