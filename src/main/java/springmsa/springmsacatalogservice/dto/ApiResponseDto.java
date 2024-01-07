package springmsa.springmsacatalogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDto<T> {
    private T data;
    private String errorMessage;
}
