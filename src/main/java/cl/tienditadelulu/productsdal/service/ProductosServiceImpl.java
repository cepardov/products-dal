package cl.tienditadelulu.productsdal.service;

import cl.tienditadelulu.productsdal.dto.*;
import cl.tienditadelulu.productsdal.repository.ProductosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductosServiceImpl implements ProductosService {

    final ProductosRepository productosRepository;

    @Override
    public ProductsResDto obtenerCatalogoProductos(ProductsReqDto productsReqDto) {
        List<ProductosDto> productosDtoList = new ArrayList<>();

        int productActive = productsReqDto.isProductActive() ? 1 : 0;

        List<ProductoDto> productoDtoList = productosRepository.obtenerCatalogo(productActive);
        List<PreciosEspecificosDto> preciosEspecificosDtoList = productosRepository.obtenerPreciosEspecificos(productActive);
        List<ImagenesDto> imagenesDtoList = productosRepository.obtenerImagenes(productActive);

        productoDtoList.forEach(productoDto -> {
            ProductosDto productsResDto = ProductosDto.builder()
                    .id(productoDto.getId())
                    .ean13(productoDto.getEan13())
                    .price(productoDto.getPrice())
                    .active(productoDto.getActive())
                    .condition(productoDto.getCondition())
                    .visibility(productoDto.getVisibility())
                    .availableDate(productoDto.getAvailableDate())
                    .name(productoDto.getName())
                    .manufacturer(productoDto.getManufacturer())
                    .metaDescription(description(productoDto.getMetaDescription()))
                    .quantity(productoDto.getQuantity())
                    .link(productoDto.getLink())
                    .build();
            productosDtoList.add(productsResDto);
        });

        productosDtoList.forEach(productsResDto -> {
            productsResDto.setPreciosEspecificos(preciosEspecificosDtoList.stream()
                    .filter(preciosEspecificosDto -> preciosEspecificosDto.getIdProducto() == productsResDto.getId())
                    .collect(Collectors.toList()));
            productsResDto.setImagenes(imagenesDtoList.stream()
                    .filter(imagenesDto -> imagenesDto.getIdProducto() == productsResDto.getId())
                    .collect(Collectors.toList()));
        });


        return ProductsResDto.builder()
                .productos(productosDtoList.stream()
                        .collect(Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingLong(ProductosDto::getId))), ArrayList::new)))
                .build();
    }

    private String description(String metaDescription) {
        if (null == metaDescription || metaDescription.isEmpty()) {
            return "Sin descripcion";
        }
        return metaDescription;
    }
}
