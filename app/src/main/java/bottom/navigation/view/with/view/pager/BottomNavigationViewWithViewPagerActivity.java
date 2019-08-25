package bottom.navigation.view.with.view.pager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BottomNavigationViewWithViewPagerActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view_with_view_pager);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.fragment_container_view_pager);
        setupViewPager(viewPager);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.action_home:
                        viewPager.setCurrentItem(0);
                        toolbar.setTitle("Home");
                        break;
                    case R.id.action_note:
                        viewPager.setCurrentItem(1);
                        toolbar.setTitle("Note");
                        break;
                    case R.id.action_email:
                        viewPager.setCurrentItem(2);
                        toolbar.setTitle("Email");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }
            @Override
            public void onPageSelected(int position)
            {
                if (menuItem != null)
                {
                    menuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);
            }
            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager)
    {
        BottomNavigationViewPagerAdapter adapter = new BottomNavigationViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new NoteFragment());
        adapter.addFragment(new EmailFragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_english:
                Toast.makeText(getApplicationContext(), "English", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_hindi:
                Toast.makeText(getApplicationContext(), "Hindi", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_spanish:
                Toast.makeText(getApplicationContext(), "Spanish", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if (bottomNavigationView.getSelectedItemId() != R.id.action_home)
        {
            bottomNavigationView.setSelectedItemId(R.id.action_home);
        }
        else
        {
            super.onBackPressed();
        }
    }
}
