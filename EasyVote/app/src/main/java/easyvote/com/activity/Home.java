package easyvote.com.activity;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import easyvote.com.easyvote.R;
import easyvote.com.fragment.Dashboard;
import easyvote.com.fragment.Result;

/**
 * Created by Infinia on 17-01-2016.
 */
public class Home extends AppCompatActivity {
    private final ArrayList<View> mMenuItems = new ArrayList<>(3);
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    int menuItem;

    String url;
    private Toolbar mToolbar;
    private TextView title, name, roll_no, usetname;
    private boolean viewIsAtHome;
    private Context context = Home.this;
    boolean doubleBackToExitPressedOnce = false;
    private Spinner spin_extra_info;
    public Spinner spin_latest_all;
    // private ImageButton img_but_extra_info;
    public ArrayList<String> varietyCustomMess = new ArrayList<>();
    private boolean onlyOne = true;
    static String[] Time = {"Latest", "All"};
    int whichFragment = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organize_activity_home);
        setUpToolbar();
        initView();
        menuItem = getIntent().getIntExtra("menuItem", 0);
        initializeNavigationDrawer();
        setNavigationHeaderData();


    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (doubleBackToExitPressedOnce) {
            finish();
        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // Snackbar.make(getV, "Please Select Any College", Snackbar.LENGTH_SHORT).show();
            Toast.makeText(context, "Again press back button to exit", Toast.LENGTH_SHORT).show();
            doubleBackToExitPressedOnce = true;
            if (!viewIsAtHome) { //if the current view is not the News fragment
                setFragment(R.id.dashboard);
            } else {
                moveTaskToBack(true);  //If view is in News fragment, exit application
            }
        }
    }

    private void setUpToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.title);


        title.setText("Create Election");
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setFragment(R.id.dashboard);


    }

    private void setNavigationHeaderData() {

        /*email.setVisibility(View.VISIBLE);
        edit.setVisibility(View.VISIBLE);*/

    }

    private void initializeNavigationDrawer() {
        setupNavigationDrawerContent(navigationView);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(final MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    private void setFragment(int id) {


        switch (id) {
            case R.id.dashboard:
                viewIsAtHome = false;
                switchFragment(Dashboard.class);
                title.setText("Dashboard");
                whichFragment = 0;
                break;
            case R.id.result:
                viewIsAtHome = false;
                switchFragment(Result.class);
                title.setText("Result");
                whichFragment = 1;
                break;

            default:
                switchFragment(CreateCandidate.class);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        drawer.closeDrawers();
    }

    private void switchFragment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_fragment, fragment).commit();
    }

    public void selectDrawerItem(MenuItem menuItem) {
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        setFragment(menuItem.getItemId());
    }


}

