package com.cybersoft.osahaneat.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    boolean saveFiles(MultipartFile file);
    Resource load(String fileName);
}
