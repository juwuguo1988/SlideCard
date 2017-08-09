package slide.jwg.cn.slidecardapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import slide.jwg.cn.slidecardapplication.common.fragments.ExpandingFragment;
import slide.jwg.cn.slidecardapplication.model.UserRelation;

/**
 * this is control fragment , Top and Bottom is child in it.
 *
 */
public class TravelExpandingFragment extends ExpandingFragment {

    static final String ARG_TRAVEL = "ARG_TRAVEL";
    UserRelation mUserRelation;

    public static TravelExpandingFragment newInstance(UserRelation userRelation){
        TravelExpandingFragment fragment = new TravelExpandingFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TRAVEL, userRelation);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null) {
            mUserRelation = args.getParcelable(ARG_TRAVEL);
        }
    }

    /**
     * include TopFragment
     * @return
     */
    @Override
    public Fragment getFragmentTop() {
        return FragmentTop.newInstance(mUserRelation);
    }

    /**
     * include BottomFragment
     * @return
     */
    @Override
    public Fragment getFragmentBottom() {
        return FragmentBottom.newInstance();
    }
}
