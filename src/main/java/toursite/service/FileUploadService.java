package toursite.service;

import org.springframework.web.multipart.MultipartFile;
import toursite.model.Category;

import java.io.IOException;
import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface FileUploadService {
    public String upload(MultipartFile file, String fileName) throws IOException;
}
