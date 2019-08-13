package com.whg.model;
import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;
public class UploadedFile  implements Serializable{


    private static final long serialVersionUID = 4084384367884786601L;

    private MultipartFile multipartFile ;


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
