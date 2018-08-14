package com.intern.bugs;

import java.util.Date;

import org.springframework.data.annotation.Id;

final class BugsEntity {
    @Id
    private String id;

    private String title;

    private String desc;

    private String status;

    private String devAssigned;

    private String tesAssigned;

    private Date filedAt;

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDevAssigned() {
        return this.devAssigned;
    }

    public String getTesAssigned() {
        return this.tesAssigned;
    }

    public Date getFiledAt() {
        return this.filedAt;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + this.id + "'" +
            ", title='" + this.title + "'" +
            ", desc='" + this.desc + "'" +
            ", status='" + this.status + "'" +
            ", devAssigned='" + this.devAssigned + "'" +
            ", tesAssigned='" + this.tesAssigned + "'" +
            ", filedAt='" + this.filedAt + "'" +
            "}";
    }

    private BugsEntity (Builder builder) {
        this.title = builder.title;
        this.desc = builder.desc;
        this.status = builder.status;
        this.devAssigned = "";
        this.tesAssigned = "";
        this.filedAt = new Date();
    }

    static Builder getBuilder() {
        return new Builder();
    }

    public void update(String title, String desc, String status, String dev, String tes) {
        this.title = title;
        this.desc = desc;
        this.status = status;
        this.devAssigned = dev;
        this.tesAssigned = tes;
        this.filedAt = new Date();
    }

    //Builder class
    static class Builder {
        private String title;

        private String desc;

        private String status;

        private String devAssigned;

        private String tesAssigned;

        private Builder() {}

        Builder desc(String description) {
            this.desc = description;
            return this;
        }
 
        Builder title(String title) {
            this.title = title;
            return this;
        }

        Builder status(String status) {
            this.status = status;
            return this;
        }

        Builder devAssign (String devAssigned) {
            this.devAssigned = devAssigned;
            return this;
        }

        Builder tesAssign (String tester) {
            this.tesAssigned = tester;
            return this;
        }

        BugsEntity build() {
            BugsEntity build = new BugsEntity(this);
            return build;
        }
    }
}