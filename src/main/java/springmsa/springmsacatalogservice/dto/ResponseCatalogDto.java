package springmsa.springmsacatalogservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseCatalogDto {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private LocalDateTime createdDate;
}
