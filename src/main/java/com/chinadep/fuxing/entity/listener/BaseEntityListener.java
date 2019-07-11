package com.chinadep.fuxing.entity.listener;

import com.chinadep.fuxing.entity.BaseDO;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class BaseEntityListener {
    @PreUpdate
    public void preUpdate(BaseDO entity) {
        Date lastModified = new Date();
        entity.setLastModified(lastModified);
    }

    @PrePersist
    public void prePersist(BaseDO entity) {
        Date createdDate = new Date();
        entity.setFirstInsert(createdDate);
    }
}
