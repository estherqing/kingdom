package com.vivo.jovi.scene.common.service.vivofs;

import java.io.InputStream;

/**
 * @author lijun
 * @version 1.0
 * @describe
 * @date 2018/10/25
 */
public interface IVivoFsService {

    String uploadFile(long fileSize, String md5, String fileName, InputStream input);

    String uploadFile(String fileName, InputStream input);

    void deleteFile(String fileId);

    String getDonwloadHost();

    String joinFileId(String fileId);

    String joinFileIdByCertainHost(String fileId,String host);

    String getImeisFile(String imeiFileId);
}
