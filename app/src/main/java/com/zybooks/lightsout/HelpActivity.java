package com.zybooks.lightsout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.net.Uri;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
    public void onButtonClick(View view) {
        Uri phoneNumber = Uri.parse("tel:111-222-3333");
        Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void onButtonClick1(View view) {
        Uri location = Uri.parse("geo:0,0?q=1600+Pennsylvania+Ave+NW,+Washington,+DC");
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void onButtonClick2(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);

// Supply extra that is plain text
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Helpful website");
        intent.putExtra(Intent.EXTRA_TEXT, "https://stackoverflow.com/");

// If at least one app can handle intent, allow user to choose
        if (intent.resolveActivity(getPackageManager()) != null) {
            Intent chooser = Intent.createChooser(intent, "Share URL");
            startActivity(chooser);
        }
    }
}