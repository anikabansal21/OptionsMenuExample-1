package com.example.optionsmenuexampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /* Looked up why the icons weren't dispalying with teh options menu.  Apparently
       it is now required to make the icons visible.  So I added the if statement shown
       below based on a suggestion shown in this SO post.  I also needed to add
       @SuppressLint before the method to be allowed to use this method.  I'm not quite
       sure why all this was needed, but without it, I wasn't able to get the icons to show up

        https://stackoverflow.com/questions/19750635/icon-in-menu-not-showing-in-android


     */
    @Override
    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.stats:
                Intent intent1 = new Intent(this, Statistics.class);
                this.startActivity(intent1);
                return true;
            case R.id.about:
                Intent intent2 = new Intent(this, About.class);
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}