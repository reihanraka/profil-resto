package com.example.sarestoran;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        // Find the ImageView from the layout file
        ImageView ivPhoneIcon = findViewById(R.id.ivPhoneIcon);

        // Set a click listener on the ImageView
        ivPhoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Specify the phone number
                String phoneNumber = "089675060482"; // Replace with the actual phone number

                // Create an Intent with the ACTION_DIAL action and the phone number
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));

                // Start the dialer activity
                startActivity(intent);
            }
        });


            // ... your menuItems and TextView creation code ...

            // Find the ImageView from the layout file
            ImageView ivEmailIcon = findViewById(R.id.ivEmailIcon); // Replace with the actual ID

            // Set OnClickListener for the ImageView
            ivEmailIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Open Gmail when the ImageView is clicked
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("mailto:")); // Mailto URI for launching email apps
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"}); // Replace with actual recipient email address
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject"); // Replace with actual email subject
                    intent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body."); // Replace with actual email body
                    startActivity(intent);
                }
            });




        ImageView ivMapIcon = findViewById(R.id.ivMapIcon);

        ivMapIcon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                // Titik koordinat yang akan ditampilkan di Google Maps
                double latitude = -6.98062551575039;
                double longitude = 110.40880251866201;

                // Membuat Uri dari koordinat
                Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);

                // Membuat Intent untuk membuka Google Maps
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                // Memulai aktivitas intent
                if (null != mapIntent.resolveActivity(getPackageManager())) {
                    startActivity(mapIntent);
                }
            }
        });
        }
}
