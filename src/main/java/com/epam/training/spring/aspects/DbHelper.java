package com.epam.training.spring.aspects;


import org.springframework.jdbc.core.JdbcTemplate;

final public class DbHelper {
    public static long getCountByTableAndId(JdbcTemplate jdbcTemplate, String tableName, long id){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM " + tableName + " WHERE showing_id = ?",
                new Object[]{ id },
                Long.class);
    }

    public static void createOrUpdateTable(JdbcTemplate jdbcTemplate, String tableName, long showingId){
        long count = getCountByTableAndId(jdbcTemplate, tableName, showingId);

        if (count == 0){
            createTable(jdbcTemplate, tableName);
        }else {
            updateTable(jdbcTemplate,tableName, showingId, count + 1);
        }

    }

    private static void createTable(JdbcTemplate jdbcTemplate, String tableName){

    }

    private static void updateTable(JdbcTemplate jdbcTemplate, String tableName, long showingId, long updatedCount){

    }
}
