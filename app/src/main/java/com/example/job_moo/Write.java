package com.example.job_moo;

public class Write {
    public String texttitle;
    public String usertext;
    public String editdetail;
    public Write(){
    }



    public Write(String texttitle, String usertext, String editdetail){
        this.texttitle=texttitle;
        this.usertext=usertext;
        this.editdetail=editdetail;
    }


    public String getTexttitle() {return texttitle; }


    public String getUsertext() {
        return usertext;
    }

    public String getEditdetail() {
        return editdetail;
    }
}
