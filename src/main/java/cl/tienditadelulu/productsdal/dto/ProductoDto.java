package cl.tienditadelulu.productsdal.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProductoDto {

    private long id;
    private String ean13;
    private double price;
    private int active;
    private String condition;
    private String visibility;
    private Date availableDate;
    private String name;
    private String metaDescription;
    private int quantity;
    private String link;
}
