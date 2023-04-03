package com.cybersoft.osahaneat.service.impl;

import com.cybersoft.osahaneat.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileStorageServiceImp implements FileStorageService {
    @Value("${upload.path}")
    String path;

    private Path root;
    @Override
    public boolean saveFiles(MultipartFile file) {
        try {

            init();
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), REPLACE_EXISTING);

            return true;
        } catch (IOException e) {
            System.out.println("FileStorageServiceImp || saveFiles()\t" + e.getMessage());
            return false;
        }

    }

    @Override
    public Resource load(String fileName) {
        try {

            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void init() {
        try {
            root = Paths.get(path);
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            System.out.println("FileStorageServiceImp || init()\t" + e.getMessage());
        }
    }
}
