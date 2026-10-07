package com.comiclibrary.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class LocalStorageService implements StorageService {

    private final Path root;

    public LocalStorageService(@Value("${app.storage.local.root:./uploads}") String root) {
        this.root = Path.of(root);
    }

    @Override
    public String store(MultipartFile file, String keyPrefix) {
        String key = keyPrefix + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        Path target = root.resolve(key).normalize();
        try {
            Files.createDirectories(target.getParent());
            file.transferTo(target);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return key;
    }

    @Override
    public void delete(String key) {
        try {
            Files.deleteIfExists(root.resolve(key).normalize());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
