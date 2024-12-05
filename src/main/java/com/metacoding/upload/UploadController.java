package com.metacoding.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
public class UploadController {

    private final UploadService uploadService;

    // form 태그 이용
    @GetMapping("/file1")
    public String file1() {
        return "file1";
    }

    // ajax 이용
    @GetMapping("/file2")
    public String file2() {
        return "file2";
    }

    // DTO 안만들고 @RequestParam("key값") 이용하는 경우 - @RequestParam("key값") 생략 가능
//    @PostMapping("v1/upload")
    // public String v1Upload(@RequestParam("username") String username, @RequestParam("img") MultipartFile img)
//    public String v1Upload(String username, MultipartFile img) {
//        return "index";
//    }

    // DTO 만든 경우
    @PostMapping("/v1/upload")
    public String v1Upload(UploadRequest.V1DTO v1DTO) {
        System.out.println(v1DTO.getUsername());
        System.out.println(v1DTO.getImg().getOriginalFilename());
        System.out.println(v1DTO.getImg().getContentType());

        uploadService.v1사진저장(v1DTO);
        return "index";
    }

    @PostMapping("v2/upload")
    public String v2Upload() {
        return "index";
    }

    // form 태그 이용
    @GetMapping("/file1-check")
    public String file1Check(Model model) {
        Upload upload = uploadService.v1사진보기();
        model.addAttribute("model", upload);
        return "file1-check";
    }
}