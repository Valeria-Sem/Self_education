package com.backend.service.impl;

import com.backend.entity.LecturesEntity;
import com.backend.repository.LecturesEntityRepository;
import com.backend.service.LecturesEntityService;
import com.backend.service.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturesEntityServiceImpl implements LecturesEntityService {

    private final LecturesEntityRepository lecturesEntityRepository;
    private final ProductEntityService productEntityService;

    @Autowired
    public LecturesEntityServiceImpl(LecturesEntityRepository lecturesEntityRepository,
                                     ProductEntityService productEntityService){
        this.lecturesEntityRepository = lecturesEntityRepository;
        this.productEntityService = productEntityService;
    }

    @Override
    public Iterable<LecturesEntity> getLecturesByIdProduct(int idProduct) {
        return lecturesEntityRepository.getLecturesEntitiesByProductId(idProduct);
    }
}
