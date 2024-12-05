package com.metacoding.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class UploadRequest {

    @Data
    public static class V1DTO {
        private String username;
        private MultipartFile img;

        public Upload toEntity(String profileUrl) {
            return Upload.builder()
                    .username(username)
                    .profileUrl(profileUrl).build();
        }
    }
}