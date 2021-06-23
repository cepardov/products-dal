package cl.tienditadelulu.productsdal.rowmapper;

import cl.tienditadelulu.productsdal.dto.PreciosEspecificosDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PreciosEspecificosRowMapper implements RowMapper<PreciosEspecificosDto> {
    @Override
    public PreciosEspecificosDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PreciosEspecificosDto.builder()
                .id(rs.getLong("id_specific_price"))
                .idProducto(rs.getLong("id_product"))
                .reduction(rs.getDouble("reduction"))
                .reductionType(rs.getString("reduction_type"))
                .build();
    }
}
