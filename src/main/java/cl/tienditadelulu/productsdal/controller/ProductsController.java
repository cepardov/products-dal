package cl.tienditadelulu.productsdal.controller;

import cl.tienditadelulu.productsdal.dto.ProductsReqDto;
import cl.tienditadelulu.productsdal.dto.ProductsResDto;
import cl.tienditadelulu.productsdal.service.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductsController {

    final ProductosService productosService;

    @PostMapping ("/catalogo")
    public ResponseEntity<ProductsResDto> obtenerCatalogo(@RequestBody ProductsReqDto productsReqDto) {
        return ResponseEntity.ok(productosService.obtenerCatalogoProductos(productsReqDto));
    }
}
