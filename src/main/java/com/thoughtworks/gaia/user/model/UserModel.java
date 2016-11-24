package com.thoughtworks.gaia.user.model;

import com.thoughtworks.gaia.common.jpa.IdBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USER")
public class UserModel extends IdBaseModel {
    @Column(name = "user_id", nullable = false, length = 64)
    private String userId;

    @Column(name = "time_created", nullable = false, updatable = false)
    private Date timeCreated;

    public String getUserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
}
