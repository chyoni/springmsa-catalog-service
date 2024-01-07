package springmsa.springmsacatalogservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springmsa.springmsacatalogservice.dto.CreateCatalogDto;
import springmsa.springmsacatalogservice.entity.Catalog;
import springmsa.springmsacatalogservice.repository.CatalogRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final ModelMapper modelMapper;

    @Override
    public Iterable<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog createCatalog(CreateCatalogDto catalogDto) {
        Catalog catalog = modelMapper.map(catalogDto, Catalog.class);
        catalogRepository.save(catalog);

        return catalog;
    }
}
