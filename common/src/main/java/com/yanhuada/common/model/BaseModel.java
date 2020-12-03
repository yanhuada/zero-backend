package com.yanhuada.common.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 17:41
 */
public class BaseModel {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected Long version;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long createdAtToUnixtime() {
        if (createdAt == null) {
            return null;
        }

        return createdAt.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public Long updatedAtToUnixtime() {
        if (updatedAt == null) {
            return null;
        }

        return updatedAt.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public String createdAtToDatetime() {
        if (createdAt == null) {
            return null;
        }

        return createdAt.format(DATE_TIME_FORMATTER);
    }

    public String updatedAtToDatetime() {
        if (updatedAt == null) {
            return null;
        }

        return updatedAt.format(DATE_TIME_FORMATTER);
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
