package springmsa.springmsacatalogservice.service;

import springmsa.springmsacatalogservice.dto.CreateCatalogDto;
import springmsa.springmsacatalogservice.entity.Catalog;

public interface CatalogService {
    Iterable<Catalog> getAllCatalogs();

    Catalog createCatalog(CreateCatalogDto catalogDto);
}
