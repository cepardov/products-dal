package cl.tienditadelulu.productsdal.rowmapper;

import cl.tienditadelulu.productsdal.dto.ImagenesDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImagenesRowMapper implements RowMapper<ImagenesDto> {
    @Override
    public ImagenesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ImagenesDto.builder()
                .id(rs.getLong("id_image"))
                .idProducto(rs.getLong("id_product"))
                .imageLink(rs.getString("image_link"))
                .build();
    }
}
