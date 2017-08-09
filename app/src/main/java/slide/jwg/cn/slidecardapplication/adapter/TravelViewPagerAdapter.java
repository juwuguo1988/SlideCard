package slide.jwg.cn.slidecardapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import slide.jwg.cn.slidecardapplication.common.ExpandingViewPagerAdapter;
import slide.jwg.cn.slidecardapplication.fragments.TravelExpandingFragment;
import slide.jwg.cn.slidecardapplication.model.UserRelation;

/**
 * Created by Qs on 16/5/30.
 */
public class TravelViewPagerAdapter extends ExpandingViewPagerAdapter {

    List<UserRelation> mUserRelations;

    public TravelViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mUserRelations = new ArrayList<>();
    }

    public void addAll(List<UserRelation> userRelations){
        this.mUserRelations.addAll(userRelations);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        UserRelation userRelation = mUserRelations.get(position);
        return TravelExpandingFragment.newInstance(userRelation);
    }

    @Override
    public int getCount() {
        return mUserRelations.size();
    }

}
