package com.api.book.bootrestbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.api.book.bootrestbook.controllers.helper.FileUploadHelper;


@RestController
public class FileUploadController {
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
    {
        try{
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File not submitted");
            }
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getSize());
            boolean f=FileUploadHelper.uploadFile(file);
            if(f){
                return ResponseEntity.ok().body("File uploaded");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File could not be uploaded");
    }
}
