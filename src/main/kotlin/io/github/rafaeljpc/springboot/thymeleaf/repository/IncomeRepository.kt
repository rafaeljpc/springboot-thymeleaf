package io.github.rafaeljpc.springboot.thymeleaf.repository

import io.github.rafaeljpc.springboot.thymeleaf.dto.SomeDataDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class IncomeRepository @Autowired constructor(
    private val jdbc: JdbcTemplate
) {

    fun countData(): Long = run {
        jdbc.queryForObject<Long>(SQL_DATA_COUNT) { rs, _ ->
            rs.getLong(1)
        } ?: 0
    }

    fun listData(): List<SomeDataDTO> {
        val result = jdbc.query(SQL_DATA_LIST, columnRowMapper)
        return result
    }

    fun saveDate(dataDTO: SomeDataDTO) {
        jdbc.update(SQL_ADD_DATA, dataDTO.nome, dataDTO.email)
    }

    companion object {
        private const val SQL_DATA_LIST = "SELECT * FROM data.some_data"
        private const val SQL_DATA_COUNT = "SELECT count(1) FROM data.some_data"
        private const val SQL_ADD_DATA = "insert into data.some_data (nome, email) values (?, ?)"

        private val columnRowMapper = RowMapper<SomeDataDTO> { rs, _ ->
            SomeDataDTO(
                id = rs.getLong("id"),
                nome = rs.getString("nome"),
                email = rs.getString("email"),
                createdAt = rs.getTimestamp("created_at").toLocalDateTime()
            )
        }

    }
}