package com.vivo.jovi.exscene.backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface IUploadFileService {

    String uploadFile(String fileName, InputStream inputStream, String docSuffix) throws IOException;

    String uploadFile(String fileName, InputStream inputStream) throws IOException;

    String getImeisFile(String data) throws IOException;

    void delFile(String data);

    boolean validImeiFile(MultipartFile file);
}
