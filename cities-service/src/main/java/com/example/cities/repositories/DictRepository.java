package com.example.cities.repositories;

import com.example.cities.domain.Dict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "dicts", path = "dicts")
public interface DictRepository extends PagingAndSortingRepository<Dict, Long> {

    Page<Dict> findAll(Pageable pageable);

    @RestResource(exported = false)
    Dict findById(Long id);

    @RestResource(path = "key", rel = "key")
    Page<Dict> findByKeyIgnoreCase(@Param("q") String key, Pageable pageable);

  
}
