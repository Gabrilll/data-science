package com.example.datascience.dao.table;

import com.example.datascience.pojo.po.table.Table;
import com.example.datascience.pojo.po.table.TableKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gabri
 */
@Repository
public interface TableRepository extends JpaRepository<Table, TableKey> {

    @Query("select t from table_info t where t.token=:token")
    List<Table> findTablesByToken(@Param("token") String token);
}
