package com.comiclibrary.storage;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String store(MultipartFile file, String keyPrefix);
    void delete(String key);
}
