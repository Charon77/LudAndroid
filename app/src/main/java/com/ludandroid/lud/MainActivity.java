package com.ludandroid.lud;

import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.DebugUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm = getSupportFragmentManager();
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.r_5); // set a custom icon for the default home button
        ab.setDisplayShowHomeEnabled(true); // show or hide the default home button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
        ab.setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(0).setChecked(true);
        fm.beginTransaction().replace(R.id.main_fragmentContainer,new HomeFragment()).addToBackStack(null).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fm.beginTransaction().replace(R.id.main_fragmentContainer,new HomeFragment()).commit();
        } else if (id == R.id.nav_notification) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_closefriend) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_fans) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_bookmarks) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_recentview) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_setting) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_about) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_signout) {
            Toast.makeText(this,"Not Implemented", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void UpdateNavDrawerSelectedItem(int n){
        switch (n){
            case 0 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 1 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 2 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 3 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 4 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 5 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 6 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 7 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case 8 :
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            default:
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
        }
    }
}
