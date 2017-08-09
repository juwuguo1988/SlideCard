package slide.jwg.cn.slidecardapplication.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import slide.jwg.cn.slidecardapplication.R;
import slide.jwg.cn.slidecardapplication.adapter.TravelViewPagerAdapter;
import slide.jwg.cn.slidecardapplication.common.ExpandingPagerFactory;
import slide.jwg.cn.slidecardapplication.common.fragments.ExpandingFragment;
import slide.jwg.cn.slidecardapplication.model.UserRelation;

public class MainActivity extends AppCompatActivity implements ExpandingFragment.OnExpandingClickListener {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.back)
    ViewGroup back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupWindowAnimations();

        TravelViewPagerAdapter adapter = new TravelViewPagerAdapter(getSupportFragmentManager());
        adapter.addAll(generateTravelList());
        viewPager.setAdapter(adapter);

        ExpandingPagerFactory.setupViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ExpandingFragment expandingFragment = ExpandingPagerFactory.getCurrentFragment(viewPager);
                if (expandingFragment != null && expandingFragment.isOpenend()) {
                    expandingFragment.close();
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!ExpandingPagerFactory.onBackPressed(viewPager)) {
            super.onBackPressed();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        Explode slideTransition = new Explode();
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    private List<UserRelation> generateTravelList() {
        List<UserRelation> userRelations = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            UserRelation userRelation =new UserRelation();
            if(i ==0){
                userRelation.setSex("男");
                userRelation.setRelationship("儿子");
                userRelation.setName("张三");
                userRelation.setBirthday("1977/05/03");
                userRelation.setTel("15901548521");
                userRelation.setImage(R.drawable.seychelles);
            }else  if(i ==1){
                userRelation.setSex("女");
                userRelation.setRelationship("女儿");
                userRelation.setName("小花");
                userRelation.setBirthday("1988/03/03");
                userRelation.setTel("15901548526");
                userRelation.setImage(R.drawable.shh);
            }else  if(i ==2){
                userRelation.setSex("男");
                userRelation.setRelationship("配偶");
                userRelation.setName("李明");
                userRelation.setBirthday("1975/05/03");
                userRelation.setTel("15901548529");
                userRelation.setImage(R.drawable.newyork);
            }else  if(i ==3){
                userRelation.setSex("女");
                userRelation.setRelationship("配偶");
                userRelation.setName("李华");
                userRelation.setBirthday("1958/02/07");
                userRelation.setTel("15901548521");
                userRelation.setImage(R.drawable.p1);
            }else  if(i ==4){
                userRelation.setSex("男");
                userRelation.setRelationship("儿子");
                userRelation.setName("李磊");
                userRelation.setBirthday("1968/04/03");
                userRelation.setTel("15901548589");
                userRelation.setImage(R.drawable.seychelles);
            }
            userRelations.add(userRelation);
        }
        return userRelations;
    }

    @SuppressWarnings("unchecked")
    private void startInfoActivity(View view, UserRelation userRelation) {
        Activity activity = this;
        ActivityCompat.startActivity(activity,
                InfoActivity.newInstance(activity, userRelation),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        new Pair<>(view, getString(R.string.transition_image)))
                        .toBundle());
    }

    @Override
    public void onExpandingClick(View v) {
        //v is expandingfragment layout
        View view = v.findViewById(R.id.iv_user_avatar);
        UserRelation userRelation = generateTravelList().get(viewPager.getCurrentItem());
        startInfoActivity(view, userRelation);
    }
}
