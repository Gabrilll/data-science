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

    /**
     * find all tables
     *
     * @param token token
     * @return tables
     */
    @Query("select t from table_info t where t.token=:token")
    List<Table> findTablesByToken(@Param("token") String token);

    /**
     * find tables between paras
     *
     * @param token   token
     * @param startId start para id
     * @param endId   end para id
     * @return tables
     */
    @Query("select t from table_info t where t.token=:token and t.id>=:startId and t.id<:endId")
    List<Table> findTablesByTokenAndIdBetween(@Param("token") String token, @Param("startId") Integer startId, @Param("endId") Integer endId);
}
