package cl.tienditadelulu.productsdal.rowmapper;

import cl.tienditadelulu.productsdal.dto.ProductoDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogoRowMapper implements RowMapper<ProductoDto> {

    @Override
    public ProductoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ProductoDto.builder()
                .id(rs.getLong("id_product"))
                .ean13(rs.getString("ean13"))
                .price(rs.getDouble("price"))
                .active(rs.getInt("active"))
                .condition(rs.getString("condition"))
                .visibility(rs.getString("visibility"))
                .availableDate(rs.getDate("available_date"))
                .name(rs.getString("name"))
                .manufacturer(rs.getString("manufacturer"))
                .metaDescription(rs.getString("meta_description"))
                .quantity(rs.getInt("quantity"))
                .link(rs.getString("link"))
                .build();
    }
}
