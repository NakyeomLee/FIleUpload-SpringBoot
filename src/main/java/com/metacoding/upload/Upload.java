package com.metacoding.upload;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "upload_tb")
@Entity
public class Upload {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private Integer id;
    private String username;
    private String profileUrl;

    @Builder
    public Upload(Integer id, String username, String profileUrl) {
        this.id = id;
        this.username = username;
        this.profileUrl = profileUrl;
    }
}
