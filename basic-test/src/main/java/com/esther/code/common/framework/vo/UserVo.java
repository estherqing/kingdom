package com.esther.code.common.framework.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户返回VO
 *
 * @author esther
 * @version 2016-12-08
 */
public class UserVo implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 用户ID **/
    private Integer id;
    /** 用户登录名 **/
    private String userName;
    /** 用户密码 **/
    private String userPassword;
    /** 昵称 **/
    private String nickname;
    /** 头像 **/
    private String portrait;
    /** 邮箱 **/
    private String email;
    /** 手机号码 **/
    private String mobile;
    /** 所属银行id **/
    private String bankId;
    /** 部门名称 **/
    private String office;
    /** 职位 **/
    private String position;
    /** 上次登录时间 **/
    private Date lastLoginTime;
    /** 备注 **/
    private String remark;
    /** 银行名称 **/
    private String bankName; 
    /** 用户类型(1、银行用户 2、专家用户 3、合作公司用户) **/
    private Short userType;
    /** 个人简介(专家用户) **/
    private String resume;
    /** 擅长领域(专家用户) **/
    private String field;
    /** 用户分类（专家用户分类：1大数据 2云计算 3核心系统 4数据库 5衍生品系统）**/
    private Short userClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bank_id) {
        this.bankId = bank_id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    } 

    public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Short getUserType() {
		return userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Short getUserClass() {
		return userClass;
	}

	public void setUserClass(Short userClass) {
		this.userClass = userClass;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [userName=");
        builder.append(userName);
        builder.append(", userPassword=");
        builder.append(userPassword);
        builder.append(", nickname=");
        builder.append(nickname);
        builder.append(", portrait=");
        builder.append(portrait);
        builder.append(", email=");
        builder.append(email);
        builder.append(", mobile=");
        builder.append(mobile);
        builder.append(", bankId=");
        builder.append(bankId);
        builder.append(", bankName=");
        builder.append(bankName);
        builder.append(", office=");
        builder.append(office);
        builder.append(", position=");
        builder.append(position);
        builder.append(", userType=");
        builder.append(userType);
        builder.append(", resume=");
        builder.append(resume);
        builder.append(", field=");
        builder.append(field);
        builder.append(", userClass=");
        builder.append(userClass);
        builder.append(", lastLoginTime=");
        builder.append(lastLoginTime);
        builder.append(", remark=");
        builder.append(remark);
        builder.append(", id=");
        builder.append(id);
        builder.append("]");
        return builder.toString();
    }

}
