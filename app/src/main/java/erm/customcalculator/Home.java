package erm.customcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import erm.customcalculator.classes.HistoryManager;
import erm.customcalculator.enums.Calculations;
import erm.customcalculator.fragments.ArithmeticFragment;
import erm.customcalculator.fragments.CalcBase;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //CALC-3
    

    public final static String CURRENT_FRAGMENT_TAG = "current_fragment";
    FrameLayout mContent;
    //separate merge
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = setUpToolbar();

        setUpObjects();

        setUpFab();

        setUpDrawer(toolbar);

        setUpNavigation();

        setContentIfNone();
    }

    private void setUpObjects() {
        mContent = (FrameLayout) findViewById(R.id.content);
    }

    private Toolbar setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void setUpNavigation() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setUpDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setUpFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcBase frag = getContent();
                if (frag != null)
                    frag.calculateAndDisplay();
            }
        });
    }

    private void setContentIfNone() {
        Fragment frag = getContent();
        if (frag == null)
            changeContext(new ArithmeticFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            CalcBase frag = getContent();
            if (frag != null)
                setTitle(frag.getNameOfCalculation());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_page) {
            CalcBase frag = getContent();
            if (frag != null)
                frag.clearPage();
            return true;
        } else if(id == R.id.action_history){
            HistoryManager hm = new HistoryManager(this);
            hm.showHistoryPopup();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String title = item.getTitle().toString();

        CalcBase frag = Calculations.getFragmentByCalculation(Calculations.getCalculationByTitle(this, title));

        changeContext(frag);

        setTitle(title);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeContext(CalcBase frag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, frag, CURRENT_FRAGMENT_TAG);
        transaction.addToBackStack(CURRENT_FRAGMENT_TAG);
        transaction.commit();

    }

    private CalcBase getContent() {
        Fragment frag = getSupportFragmentManager().findFragmentByTag(CURRENT_FRAGMENT_TAG);
        if (frag != null && frag instanceof CalcBase) {
            return (CalcBase) frag;
        } else {
            return null;
        }

    }
}
