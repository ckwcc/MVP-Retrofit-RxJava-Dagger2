package com.ckw.zfsoft.mvpanddagger2.example.repository;

/**
 * Created by ${ckw}
 * Create Time 2017/8/22.
 * Describe:
 */

public class NearbyPerson {
    /**
     * "userid": "607",
     "userpic": "/Uploads/s_5997adc3d3a85.png",
     "longitude": "108.895002706077776",
     "latitude": "34.241995671795905"
     */
    private String userid;
    private String userpic;
    private String longitude;
    private String latitude;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "NearbyPerson{" +
                "userid='" + userid + '\'' +
                ", userpic='" + userpic + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
