package springmsa.springmsacatalogservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmsa.springmsacatalogservice.dto.ApiResponseDto;
import springmsa.springmsacatalogservice.dto.CreateCatalogDto;
import springmsa.springmsacatalogservice.dto.ResponseCatalogDto;
import springmsa.springmsacatalogservice.entity.Catalog;
import springmsa.springmsacatalogservice.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<ApiResponseDto<List<ResponseCatalogDto>>> getCatalogs() {
        Iterable<Catalog> allCatalogs = catalogService.getAllCatalogs();

        List<ResponseCatalogDto> result = new ArrayList<>();

        allCatalogs.forEach(catalog -> {
            ResponseCatalogDto catalogDto = modelMapper.map(catalog, ResponseCatalogDto.class);
            result.add(catalogDto);
        });

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDto<>(result, null));
    }

    @PostMapping("")
    public ResponseEntity<ApiResponseDto<ResponseCatalogDto>> createCatalog(@RequestBody CreateCatalogDto catalogDto) {
        Catalog catalog = catalogService.createCatalog(catalogDto);

        ResponseCatalogDto responseCatalogDto = modelMapper.map(catalog, ResponseCatalogDto.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponseDto<>(responseCatalogDto, null));
    }
}
