package com.shiro2.entity;

import lombok.Data;

import java.util.List;
@Data
public class Userinfo {
    private List trees;
    private List roles;



    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.uid
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.uname
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    private String uname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.upass
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    private String upass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.isdelete
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    private Boolean isdelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.uid
     *
     * @return the value of userinfo.uid
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.uid
     *
     * @param uid the value for userinfo.uid
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.uname
     *
     * @return the value of userinfo.uname
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public String getUname() {
        return uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.uname
     *
     * @param uname the value for userinfo.uname
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.upass
     *
     * @return the value of userinfo.upass
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public String getUpass() {
        return upass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.upass
     *
     * @param upass the value for userinfo.upass
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public void setUpass(String upass) {
        this.upass = upass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.isdelete
     *
     * @return the value of userinfo.isdelete
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public Boolean getIsdelete() {
        return isdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.isdelete
     *
     * @param isdelete the value for userinfo.isdelete
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}