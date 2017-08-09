package slide.jwg.cn.slidecardapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.devspark.robototextview.widget.RobotoTextView;
import slide.jwg.cn.slidecardapplication.R;
import slide.jwg.cn.slidecardapplication.activity.InfoActivity;
import slide.jwg.cn.slidecardapplication.common.views.CircleImageView;
import slide.jwg.cn.slidecardapplication.model.UserRelation;


public class FragmentTop extends Fragment {
    static final String ARG_TRAVEL = "ARG_TRAVEL";
    UserRelation mUserRelation;

    @Bind(R.id.iv_user_avatar)
    CircleImageView iv_user_avatar;
    @Bind(R.id.rtv_user_name)
    RobotoTextView rtv_user_name;
    @Bind(R.id.rtv_user_sex)
    RobotoTextView rtv_user_sex;
    @Bind(R.id.rtv_user_relation)
    RobotoTextView rtv_user_relation;
    @Bind(R.id.rtv_user_birth)
    RobotoTextView rtv_user_birth;
    @Bind(R.id.rtv_user_tel)
    RobotoTextView rtv_user_tel;
    @Bind(R.id.rl_user_relative_edit)
    RelativeLayout rl_user_relative_edit;
    @Bind(R.id.rl_user_relative_delete)
    RelativeLayout rl_user_relative_delete;

    public static FragmentTop newInstance(UserRelation userRelation) {
        Bundle args = new Bundle();
        FragmentTop fragmentTop = new FragmentTop();
        args.putParcelable(ARG_TRAVEL, userRelation);
        fragmentTop.setArguments(args);
        return fragmentTop;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mUserRelation = args.getParcelable(ARG_TRAVEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_front, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        if (mUserRelation != null) {
            Glide.with(this).load(mUserRelation.getImage()).placeholder(R.drawable.user_default_portrait).into(iv_user_avatar);
            rtv_user_name.setText(mUserRelation.getName());
            rtv_user_sex.setText(mUserRelation.getSex());
            rtv_user_relation.setText(mUserRelation.getRelationship());
            rtv_user_birth.setText(mUserRelation.getBirthday());
            rtv_user_tel.setText(mUserRelation.getTel());
        }

    }

    //点击编辑
    @OnClick(R.id.rl_user_relative_edit)
    public void onUserRelativeEditClick() {

    }

    //点击删除
    @OnClick(R.id.rl_user_relative_delete)
    public void onUserRelativeDeleteClick() {

    }

    @SuppressWarnings("unchecked")
    private void startInfoActivity(View view, UserRelation userRelation) {
        FragmentActivity activity = getActivity();
        ActivityCompat.startActivity(activity,
                InfoActivity.newInstance(activity, userRelation),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        new Pair<>(view, getString(R.string.transition_image)))
                        .toBundle());
    }
}
