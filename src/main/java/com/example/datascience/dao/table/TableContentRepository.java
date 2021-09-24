package com.example.datascience.dao.table;

import com.example.datascience.pojo.po.table.TableContent;
import com.example.datascience.pojo.po.table.TableContentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gabri
 */
@Repository
public interface TableContentRepository extends JpaRepository<TableContent, TableContentKey> {
}
