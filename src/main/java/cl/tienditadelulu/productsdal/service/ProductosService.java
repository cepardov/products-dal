package cl.tienditadelulu.productsdal.service;

import cl.tienditadelulu.productsdal.dto.ProductsReqDto;
import cl.tienditadelulu.productsdal.dto.ProductsResDto;

public interface ProductosService {

    ProductsResDto obtenerCatalogoProductos(ProductsReqDto productsReqDto);
}
