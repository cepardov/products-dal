package cl.tienditadelulu.productsdal.repository;

import cl.tienditadelulu.productsdal.dto.ProductoDto;
import cl.tienditadelulu.productsdal.dto.ImagenesDto;
import cl.tienditadelulu.productsdal.dto.PreciosEspecificosDto;

import java.util.List;

public interface ProductosRepository {

    List<ProductoDto> obtenerCatalogo(int productActive);
    List<PreciosEspecificosDto> obtenerPreciosEspecificos(int productActive);
    List<ImagenesDto> obtenerImagenes(int productActive);
}
