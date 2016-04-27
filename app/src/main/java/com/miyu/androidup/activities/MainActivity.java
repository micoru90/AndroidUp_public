package com.miyu.androidup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.miyu.androidup.R;
import com.miyu.androidup.fragments.GlosarioFragment;
import com.miyu.androidup.fragments.HomeFragment;
import com.miyu.androidup.fragments.CompartirFragment;
import com.miyu.androidup.fragments.LoginFragment;
import com.miyu.androidup.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private de.hdodenhof.circleimageview.CircleImageView profile_image;
    private TextView profile_name;
    private TextView profile_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displayView(R.id.nav_home);

        View headerview = navigationView.getHeaderView(0);
        LinearLayout header = (LinearLayout) headerview.findViewById(R.id.header);

        profile_image = (de.hdodenhof.circleimageview.CircleImageView) headerview.findViewById(R.id.profile_image);
        profile_name = (TextView) headerview.findViewById(R.id.profile_name);
        profile_email = (TextView) headerview.findViewById(R.id.profile_email);

        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PerfilFragment();
                String title = getString(R.string.app_name);
                title  = "Perfil";

                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_relative, fragment);
                    ft.commit();
                }

                // set the toolbar title
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }

                drawer.closeDrawer(GravityCompat.START);
                setCheckedAndChekacle(R.id.nav_home, false);
                setCheckedAndChekacle(R.id.nav_perfil, false);
                setCheckedAndChekacle(R.id.nav_glosario, false);
                setCheckedAndChekacle(R.id.nav_ajustes, false);
                setCheckedAndChekacle(R.id.nav_contacto, false);
                setCheckedAndChekacle(R.id.nav_comparte, false);
                setCheckedAndChekacle(R.id.nav_valora, false);
            }
        });

        final Button signinButton = (Button) headerview.findViewById(R.id.sign);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new LoginFragment();
                String title = getString(R.string.app_name);
                title  = "Sign in";

                if (fragment != null) {
//                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.content_relative, fragment);
//                    ft.commit();

                    fragment = new LoginFragment();

                    FragmentManager manager = getSupportFragmentManager();

                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.content_relative, fragment);
                    transaction.commit();
                }

                // set the toolbar title
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }

                drawer.closeDrawer(GravityCompat.START);
                setCheckedAndChekacle(R.id.nav_home, false);
                setCheckedAndChekacle(R.id.nav_perfil, false);
                setCheckedAndChekacle(R.id.nav_glosario, false);
                setCheckedAndChekacle(R.id.nav_ajustes, false);
                setCheckedAndChekacle(R.id.nav_contacto, false);
                setCheckedAndChekacle(R.id.nav_comparte, false);
                setCheckedAndChekacle(R.id.nav_valora, false);


            }
        });

    }

    private void setCheckedAndChekacle(int nav, boolean check) {
        navigationView.getMenu().findItem(nav).setChecked(check);
        navigationView.getMenu().findItem(nav).setCheckable(check);
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
        displayView(item.getItemId());
        return true;
    }

    public void displayView(int viewId) {

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {

            case R.id.nav_home:
                fragment = new HomeFragment();
                title  = "AndroidUp";
                setCheckedAndChekacle(R.id.nav_home, true);
                break;

            case R.id.nav_perfil:
                fragment = new PerfilFragment();
                title  = "Perfil";
                setCheckedAndChekacle(R.id.nav_perfil, true);
                break;

            case R.id.nav_glosario:
                fragment = new GlosarioFragment();
                setCheckedAndChekacle(R.id.nav_glosario, true);
                title = "Glosario";
                break;

            case R.id.nav_comparte:
                fragment = new CompartirFragment();
                setCheckedAndChekacle(R.id.nav_comparte, true);
                title = "Comparte";
                break;

        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_relative, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == LoginFragment.RC_SIGN_IN) {
            LoginFragment fragment = (LoginFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.content_relative);
            fragment.onActivityResult(requestCode, resultCode, data);

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
