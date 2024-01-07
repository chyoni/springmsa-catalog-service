package springmsa.springmsacatalogservice.dto;

import lombok.Data;

@Data
public class CreateCatalogDto {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;
}
