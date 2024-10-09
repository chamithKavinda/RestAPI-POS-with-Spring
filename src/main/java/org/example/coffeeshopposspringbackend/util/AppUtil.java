package org.example.coffeeshopposspringbackend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class AppUtil {
    public static String toBase64ProductImg(MultipartFile pro_img) throws IOException {
        return Base64.getEncoder().encodeToString(pro_img.getBytes());
    }
}
