package com.example.datascience.dao.table;

import com.example.datascience.pojo.po.table.Table;
import com.example.datascience.pojo.po.table.TableKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gabri
 */
@Repository
public interface TableRepository extends JpaRepository<Table, TableKey> {
}
