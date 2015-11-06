package toursite.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class FileUploadSrviceImpl implements FileUploadService {
    public String upload(MultipartFile multipartFile, String patch) throws IOException {
//        SecureRandom random = new SecureRandom();
//        String filenameExtension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
//        String filename = new BigInteger(130, random).toString(32) + filenameExtension;
//
//        byte[] bytes = multipartFile.getBytes();
//        BufferedOutputStream stream =
//                new BufferedOutputStream(new FileOutputStream(new File(patch + filename)));
//        stream.write(bytes);
//        stream.close();
//        File file = convert(multipartFile, filename);

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "khomko-v",
                "api_key", "668656986683845",
                "api_secret", "30HP9RuWbfQ60wrmaGHtgM-Xu_o"));


        Map uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());

        return "";
    }

    private File convert(MultipartFile file, String filename) throws IOException {
        File convFile = new File("D:/toursite_upload/temp/images/" + filename);
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
