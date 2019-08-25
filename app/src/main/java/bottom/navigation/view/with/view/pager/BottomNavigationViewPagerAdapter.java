package bottom.navigation.view.with.view.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class BottomNavigationViewPagerAdapter extends FragmentPagerAdapter
{
    List<Fragment> listOfFragment = new ArrayList<>();

    public BottomNavigationViewPagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }
    public void addFragment(Fragment fragment)
    {
        listOfFragment.add(fragment);
    }

    @Override
    public Fragment getItem(int position)
    {
        return listOfFragment.get(position);
    }

    @Override
    public int getCount()
    {
        return listOfFragment.size();
    }
}