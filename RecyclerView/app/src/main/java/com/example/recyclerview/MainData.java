package com.example.recyclerview;

public class MainData {

    private final int iv_profile;
    private final String tv_name;
    private String tv_content;

    public MainData(int iv_profile, String tv_name, String tv_content) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

}
