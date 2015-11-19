package com.epam.training.spring.aspects;


import org.springframework.jdbc.core.JdbcTemplate;

final public class DbHelper {
    private static boolean isExists(JdbcTemplate jdbcTemplate, String tableName, long id){
        long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM " + tableName + " WHERE showing_id = ?",
                new Object[]{ id },
                Long.class);

        return count > 0;
    }

    public static long getCountByTableAndId(JdbcTemplate jdbcTemplate, String tableName, long id){
        if (isExists(jdbcTemplate, tableName, id))
            return jdbcTemplate.queryForObject("SELECT number FROM " + tableName + " WHERE showing_id = ?",
                new Object[]{ id },
                Long.class);

        return 0;
    }

    public static void createOrUpdateRecord(JdbcTemplate jdbcTemplate, String tableName, long showingId){
        long count = getCountByTableAndId(jdbcTemplate, tableName, showingId);

        if (count == 0){
            createRecord(jdbcTemplate, tableName, showingId);
        }else {
            updateRecord(jdbcTemplate, tableName, showingId, count + 1);
        }

    }

    private static void createRecord(JdbcTemplate jdbcTemplate, String tableName, long showingId){
        jdbcTemplate.update("INSERT INTO " + tableName + " (showing_id, number) VALUES(?, ?)",
                new Object[]{showingId, 1});
    }

    private static void updateRecord(JdbcTemplate jdbcTemplate, String tableName, long showingId, long updatedCount){
        jdbcTemplate.update("UPDATE " + tableName + " SET number=? WHERE showing_id = ?",
                new Object[]{updatedCount, showingId} );
    }
}
