package io.github.rafaeljpc.springboot.thymeleaf.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class IncomeRepository @Autowired constructor(
    private val jdbc: JdbcTemplate
) {

    fun incomeColumns(): List<String> {
        jdbc.fetchSize = 1
        val result = jdbc.query(SQL_INCOME_RESULT_COLUMNS, columnRowMapper).firstOrNull() ?: emptyList()
        return result
    }

    companion object {
        private const val SQL_INCOME_RESULT_COLUMNS = "SELECT * FROM data.some_data"

        private val columnRowMapper = RowMapper<List<String>> { rs, _ ->
            val line = mutableListOf<String>()

            (1..rs.metaData.columnCount).forEach {
                line.add(rs.metaData.getColumnName(it))
            }
            line
        }

    }
}