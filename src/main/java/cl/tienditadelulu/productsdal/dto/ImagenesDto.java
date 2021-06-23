package cl.tienditadelulu.productsdal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImagenesDto {

    private long id;
    private long idProducto;
    private String imageLink;
}
