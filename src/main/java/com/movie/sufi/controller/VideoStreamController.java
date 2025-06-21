package com.movie.sufi.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/stream")
public class VideoStreamController {

    private final Path videoStoragePath = Paths.get("videos").toAbsolutePath().normalize();

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> streamVideo(@PathVariable String filename) throws Exception {
        Path filePath = videoStoragePath.resolve(filename).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
                .body(resource);
    }
}