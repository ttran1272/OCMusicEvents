package edu.orangecoastcollege.cs273.ttran1272.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EvensListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Content has already been set for ListActivity
        // setContentView(R.layout.activity_evens_list);

        // Define a built-in list adapter for this ListActivity
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Use the position in the list to look up in the title array
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        //Create an Intent to go to DetailsActivity with title and details sent
        Intent detailsIntent = new Intent(this, EventsDetailsActivity.class);
        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details", details);
        startActivity(detailsIntent);
    }
}
