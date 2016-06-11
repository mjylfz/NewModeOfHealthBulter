package activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.asus.newmodeofhealthbulter.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MyViewPagerAdapter;
import fragments.Fragment1;
import fragments.Fragment2;
import utils.TopSytle;

/**
 * Created by LFZ on 2016/6/10.
 */
public class DiagnoseRecord extends FragmentActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    private List<String> titleList=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);
        TopSytle.setTranslucent(this);

        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("诊断详情"));
        tabLayout.addTab(tabLayout.newTab().setText("诊断结果"));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());

        titleList.add("诊断详情");
        titleList.add("治疗推荐");

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
