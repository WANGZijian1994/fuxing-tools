package com.chinadep.fuxing.repository;

import com.chinadep.fuxing.entity.TagDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelRepository extends JpaRepository<TagDO,Long> {
}
