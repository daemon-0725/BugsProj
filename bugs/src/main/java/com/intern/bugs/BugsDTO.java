package com.intern.bugs;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public final class BugsDTO {
    private String id;

    @NotEmpty
    private String desc;

    @NotEmpty
    private String title;

    @NotEmpty
    private String status;

    private String devAssigned;

    private String tesAssigned;

    private Date filedAt;

    public BugsDTO() {}

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", desc='" + getDesc() + "'" +
            ", title='" + getTitle() + "'" +
            ", status='" + getStatus() + "'" +
            ", devAssigned='" + getDevAssigned() + "'" +
            ", tesAssigned='" + getTesAssigned() + "'" +
            ", filedAt='" + getFiledAt() + "'" +
            "}";
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDevAssigned() {
        return this.devAssigned;
    }

    public void setDevAssigned(String devAssigned) {
        this.devAssigned = devAssigned;
    }

    public String getTesAssigned() {
        return this.tesAssigned;
    }

    public void setTesAssigned(String tesAssigned) {
        this.tesAssigned = tesAssigned;
    }

    public Date getFiledAt() {
        return this.filedAt;
    }

    public void setFiledAt(Date filedAt) {
        this.filedAt = filedAt;
    }
}