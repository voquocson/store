package com.example.store.model;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class AbstractEntity {
    
    protected Boolean isDelete = false;
    
    protected Timestamp registerDate;

    protected Timestamp updateDate;

    protected Timestamp DeleteDate;

    @PrePersist
    protected void onCreate() {
        if (registerDate == null) {
            updateDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
            registerDate = updateDate;
        }
        if (isDelete == null) {
            isDelete = false;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
        if (isDelete == null) {
            isDelete = false;
        }
    }

    @Column(name = "is_delete")
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Column(name = "register_date", updatable = false)
    protected Timestamp getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "update_date")
    @JsonIgnore
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "delete_date")
    @JsonIgnore
    public Timestamp getDeleteDate() {
        return DeleteDate;
    }

    public void setDeleteDate(Timestamp deleteDate) {
        DeleteDate = deleteDate;
    }

    
}
