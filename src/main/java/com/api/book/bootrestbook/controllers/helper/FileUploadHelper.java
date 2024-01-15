package com.api.book.bootrestbook.controllers.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUploadHelper {
    public static final String UPLOAD_DIR="C:\\Users\\hp\\Desktop\\Spring_pro\\bootrestbook\\src\\main\\resources\\static\\image";

    public static boolean uploadFile(MultipartFile multipartfile){
        boolean f=false;
        try{
            InputStream is= multipartfile.getInputStream();
            byte data[]=new byte[is.available()];
            is.read(data);

            FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartfile.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }


}
