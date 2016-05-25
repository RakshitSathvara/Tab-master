package in.vaksys.tab;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

    private Spinner spinner_select_value;
    private Toolbar toolbar;
    String item;
    private EventBus bus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Car");
        list.add("Bike");

        spinner_select_value = (Spinner) findViewById(R.id.spinner_select_value);

        final ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_select_value.setAdapter(spinAdapter);

        spinner_select_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(getApplicationContext(), "Selected  : " + item,
                        Toast.LENGTH_LONG).show();

                if (position == 0) {
                //    bus.post(new MessageCar("datata",0));
                    bus.post(new MessageCar(item));
                    //     startService(new Intent(MainActivity.this, MessageService.class));
                }
                if (position == 1) {
                    bus.post(new MessageCar(item));
                //    bus.post(new Messagebike("bikekekeke"));
                    //  startService(new Intent(MainActivity.this, MessageService.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {

        adapter.addFragment(new FragmentOne(), "One");
        adapter.addFragment(new FragmentTwo(), "Two");
        adapter.addFragment(new FragmentThree(), "Three");
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0){
                    Log.e("Positon fregment 1",item);
                    bus.post(new MessageCar(item));
                }
                if (position == 1){
                    Log.e("Positon fregment 2",item);
                    bus.post(new MessageCar(item));

                }

                if (position == 2){
                    Log.e("Positon fregment 3",item);
                    bus.post(new MessageCar(item));

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    protected void onDestroy() {
        // Unregister
        bus.unregister(this);
        super.onDestroy();
    }


}
