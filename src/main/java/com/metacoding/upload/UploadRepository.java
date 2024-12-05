package com.metacoding.upload;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UploadRepository {

    private final EntityManager em;

    // 이미지 파일 경로 DB 저장
    public void save(Upload upload) {
        em.persist(upload);
    }

    // 업로드된 이미지 보기
    public Upload findById(Integer id) {
        return em.find(Upload.class, id);
    }
}