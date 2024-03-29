package com.ritvan.ecommerce.uploads;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public interface FileStorageService {
    public void init();

    public void save(MultipartFile file);

    public Resource load(String photo);

    public boolean delete(String name);

    public void deleteAll();

    public Stream<Path> loadAll();
}
