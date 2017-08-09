package slide.jwg.cn.slidecardapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import slide.jwg.cn.slidecardapplication.R;
import slide.jwg.cn.slidecardapplication.common.views.CircleImageView;
import slide.jwg.cn.slidecardapplication.model.UserRelation;


public class InfoActivity extends AppCompatActivity {

    private static final String EXTRA_TRAVEL = "EXTRA_TRAVEL";
    @Bind(R.id.iv_user_avatar)
    CircleImageView iv_user_avatar;
    @Bind(R.id.tv_user_relative_name)
    TextView tv_user_relative_name;
    @Bind(R.id.tv_user_relative_birth)
    TextView tv_user_relative_birth;
    @Bind(R.id.tv_user_relative_tel)
    TextView tv_user_relative_tel;
    @Bind(R.id.tv_user_relative_relation)
    TextView tv_user_relative_relation;

    public static Intent newInstance(Context context, UserRelation userRelation) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(EXTRA_TRAVEL, userRelation);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        UserRelation userRelation = getIntent().getParcelableExtra(EXTRA_TRAVEL);
        if (userRelation != null) {
            Glide.with(this).load(userRelation.getImage()).placeholder(R.drawable.user_default_portrait).into(iv_user_avatar);
            tv_user_relative_name.setText("亲友名称： " + userRelation.getName());
            tv_user_relative_relation.setText("与患者关系：" + userRelation.getRelationship());
            tv_user_relative_birth.setText(userRelation.getBirthday());
            tv_user_relative_tel.setText(userRelation.getTel());
        }
    }
}
