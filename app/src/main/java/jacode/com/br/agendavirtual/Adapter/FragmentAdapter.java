package jacode.com.br.agendavirtual.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import jacode.com.br.agendavirtual.Fragments.PassadosFragment;
import jacode.com.br.agendavirtual.Fragments.PendentesFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    int numberTabs;

    public FragmentAdapter(FragmentManager fm, int numberTabs) {
        super(fm);
        this.numberTabs = numberTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                PendentesFragment tab1 = new PendentesFragment();
                return tab1;
            case 1:
                PassadosFragment tab2 = new PassadosFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberTabs;
    }
}
