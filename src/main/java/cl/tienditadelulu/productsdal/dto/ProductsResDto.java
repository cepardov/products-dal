package cl.tienditadelulu.productsdal.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductsResDto {

    private List<ProductosDto> productos;
}
