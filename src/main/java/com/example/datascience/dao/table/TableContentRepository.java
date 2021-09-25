package com.example.datascience.dao.table;

import com.example.datascience.pojo.po.table.TableContent;
import com.example.datascience.pojo.po.table.TableContentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gabri
 */
@Repository
public interface TableContentRepository extends JpaRepository<TableContent, TableContentKey> {
    /**
     * find table cells of a table
     *
     * @param token   token
     * @param tableId table id
     * @return table cells
     */
    @Query("select t from table_content t where t.token=:token and t.tableId=:tableId")
    public List<TableContent> findTableContentsByTokenAndTableId(@Param("token") String token, @Param("tableId") Integer tableId);

}
