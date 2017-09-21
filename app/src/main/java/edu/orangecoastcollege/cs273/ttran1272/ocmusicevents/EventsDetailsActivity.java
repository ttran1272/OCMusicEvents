package edu.orangecoastcollege.cs273.ttran1272.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_detail);

        // Get the data out of the Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        // Set the text of the text views
        titleTextView.setText(title);
        detailsTextView.setText(details);

        // Use the Asset Manager to retrieve a file (image)
        AssetManager am = this.getAssets();
        String imageFileName = title.replace(" ","") + ".jpeg";

        // Use Asset Manager to open a stream to the file name
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e){
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e );
        }

    }

    /**
     *
     * Go back to the EventsListActivity
    **/
    protected  void goBackToList(View v){

        // Terminate the current activity (terminate the details activity)
        finish();
    }
}
