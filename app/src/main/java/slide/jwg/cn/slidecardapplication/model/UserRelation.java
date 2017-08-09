package slide.jwg.cn.slidecardapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserRelation implements Parcelable {

    private String id;
    private int image;
    private String birthday;
    private String name;
    private String relationship;         //SPOUSE/配偶,SON/儿子,DAUGHTER/女儿
    private String sex;                  //性别:MALE/FEMALE
    private String tel;
    private Boolean pushPlanNotify;      //是否开启调整用药
    private Boolean masNotify;           //是否开启服药提醒
    private Boolean reviewNotify;        //是否开启复查消息
    private Boolean smsEnable;           //是否开启短信提醒

    public UserRelation() {
    }

    protected UserRelation(Parcel in) {
        image = in.readInt();
        birthday = in.readString();
        name = in.readString();
        relationship =in.readString();
        sex =in.readString();
        tel =in.readString();
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public static final Creator<UserRelation> CREATOR = new Creator<UserRelation>() {
        @Override
        public UserRelation createFromParcel(Parcel in) {
            return new UserRelation(in);
        }

        @Override
        public UserRelation[] newArray(int size) {
            return new UserRelation[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(birthday);
        dest.writeString(name);
        dest.writeString(relationship);
        dest.writeString(sex);
        dest.writeString(tel);
    }
}
