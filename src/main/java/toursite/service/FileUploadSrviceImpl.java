package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import toursite.dao.CountryDAO;
import toursite.model.Country;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class FileUploadSrviceImpl implements FileUploadService {
    public String upload(MultipartFile file, String patch) throws IOException {
        SecureRandom random = new SecureRandom();
        String filenameExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = new BigInteger(130, random).toString(32) + filenameExtension;

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File(patch + filename)));
        stream.write(bytes);
        stream.close();
        return filename;
    }
}
