package com.karan.unifynd.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karan.unifynd.R;
import com.karan.unifynd.fragments.FragmentFirst;
import com.karan.unifynd.fragments.FragmentSecond;
import com.karan.unifynd.fragments.FragmentThird;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity implements HasSupportFragmentInjector,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    public BottomNavigationView bottomNavigationView;
    public Fragment active;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    private Fragment fragmentFirst;
    private Fragment fragmentSecond;
    private Fragment fragmentThird;
    private FragmentManager fragmentManager;
    private Menu menu;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavigationView.setItemIconTintList(null);
        fragmentFirst = new FragmentFirst();
        fragmentSecond = new FragmentSecond();
        fragmentThird = new FragmentThird();
        active = fragmentFirst;
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fragmentManager.beginTransaction().add(R.id.container_home, fragmentFirst, "fragment_first").commit();
        fragmentManager.beginTransaction().add(R.id.container_home, fragmentSecond, "fragment_second").hide(fragmentSecond).commit();
        fragmentManager.beginTransaction().add(R.id.container_home, fragmentThird, "fragment_third").hide(fragmentThird).commit();

        bottomNavigationView.setSelectedItemId(R.id.first);

    }

    public boolean updateFragment(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.first:
                fragmentManager.beginTransaction().hide(active).show(fragmentFirst).commit();
                active = fragmentFirst;
                menuItem.setIcon(R.drawable.ic_star_active);
                Menu menu = bottomNavigationView.getMenu();
                menu.getItem(1).setIcon(R.drawable.ic_setup_dots_inactive);
                menu.getItem(2).setIcon(R.drawable.ic_arrow_with_scribble_inactive);
                return true;
            case R.id.second:
                fragmentManager.beginTransaction().hide(active).show(fragmentSecond).commit();
                active = fragmentSecond;
                menuItem.setIcon(R.drawable.ic_dots_menu_active);
                Menu menu1 = bottomNavigationView.getMenu();
                menu1.getItem(0).setIcon(R.drawable.ic_star_inactive);
                menu1.getItem(2).setIcon(R.drawable.ic_arrow_with_scribble_inactive);
                return true;
            case R.id.third:
                fragmentManager.beginTransaction().hide(active).show(fragmentThird).commit();
                active = fragmentThird;
                menuItem.setIcon(R.drawable.ic_arrow_with_scribble_active);
                Menu menu2 = bottomNavigationView.getMenu();
                menu2.getItem(1).setIcon(R.drawable.ic_setup_dots_inactive);
                menu2.getItem(0).setIcon(R.drawable.ic_star_inactive);
                return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        count = 0;
        return updateFragment(item);
    }

    @Override
    public void onBackPressed() {

        for (Fragment frag : fragmentManager.getFragments()) {
            if (frag.isVisible()) {
                FragmentManager childFm = frag.getChildFragmentManager();
                if (childFm.getBackStackEntryCount() > 0) {
                    childFm.popBackStack();
                    return;
                }
            }
        }
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            return;
        }
        if (count == 0) {
            count = 1;
            Toast.makeText(this, "Press again for exit", Toast.LENGTH_LONG).show();
        } else {
            releaseInstance();
            finishAndRemoveTask();
            super.onBackPressed();
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}