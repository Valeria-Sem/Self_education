package com.backend.service;

import com.backend.entity.LecturesEntity;

public interface LecturesEntityService {
    Iterable<LecturesEntity> getLecturesByIdProduct(int idProduct);
}
