package com.satish.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button showPopupMenuButton;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPopupMenuButton = findViewById(R.id.showPopupMenuButton);
        fragmentManager = getSupportFragmentManager();


        showPopupMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_settings) {
                    loadFragment(new SettingFragment());
                    return true;
                } else if (itemId == R.id.menu_help) {
                    loadFragment(new HelpFragment());
                    return true;
                } else if (itemId == R.id.menu_feedback) {
                    loadFragment(new FeedbackFragment());
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null); // Optional: Add to back stack for navigation
        transaction.commit();
    }
}