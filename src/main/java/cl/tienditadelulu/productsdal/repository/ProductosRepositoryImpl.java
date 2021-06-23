package cl.tienditadelulu.productsdal.repository;

import cl.tienditadelulu.productsdal.dto.ProductoDto;
import cl.tienditadelulu.productsdal.dto.ImagenesDto;
import cl.tienditadelulu.productsdal.dto.PreciosEspecificosDto;
import cl.tienditadelulu.productsdal.rowmapper.CatalogoRowMapper;
import cl.tienditadelulu.productsdal.rowmapper.ImagenesRowMapper;
import cl.tienditadelulu.productsdal.rowmapper.PreciosEspecificosRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Repository
public class ProductosRepositoryImpl implements ProductosRepository {

    final JdbcTemplate jdbcTemplate;

    public List<ProductoDto> obtenerCatalogo(int productActive) {
        ArrayList<Object> params = new ArrayList<>(Collections.emptyList());
        StringBuilder sql = new StringBuilder();
        sql.append("select p.id_product,p.ean13,p.price,p.active,p.condition,p.visibility,p.available_date,pl.name,");
        sql.append("pl.meta_description,sa.quantity,");
        sql.append("concat('https://', su.domain, '/', cl.link_rewrite, '/', p.id_product, '-', pl.link_rewrite, '-', p.ean13) as link ");
        sql.append("from ps_shop_url su,ps_product p,ps_product_lang pl,ps_stock_available sa,ps_category_lang cl ");
        sql.append("where pl.id_product = p.id_product and sa.id_product = p.id_product ");
        sql.append("and cl.id_category = p.id_category_default and p.active = ?");

        params.add(productActive);

        return jdbcTemplate.query(sql.toString(), new CatalogoRowMapper(), params.toArray());
    }

    public List<PreciosEspecificosDto> obtenerPreciosEspecificos(int productActive) {
        ArrayList<Object> params = new ArrayList<>(Collections.emptyList());
        StringBuilder sql = new StringBuilder();
        sql.append("select sp.id_specific_price, p.id_product, sp.reduction, sp.reduction_type ");
        sql.append("from ps_product p, ps_specific_price sp ");
        sql.append("where sp.id_product = p.id_product ");
        sql.append("and p.active = ?");

        params.add(productActive);

        return jdbcTemplate.query(sql.toString(), new PreciosEspecificosRowMapper(), params.toArray());
    }

    public List<ImagenesDto> obtenerImagenes(int productActive) {
        ArrayList<Object> params = new ArrayList<>(Collections.emptyList());
        StringBuilder sql = new StringBuilder();
        sql.append("select i.id_image, p.id_product, concat('https://', su.domain, '/', i.id_image, '-large_default/', p.id_product, '.jpg') as image_link ");
        sql.append("from ps_shop_url su, ps_product p, ps_image i ");
        sql.append("where i.id_product = p.id_product ");
        sql.append("and p.active = ?");

        params.add(productActive);

        return jdbcTemplate.query(sql.toString(), new ImagenesRowMapper(), params.toArray());
    }

}
