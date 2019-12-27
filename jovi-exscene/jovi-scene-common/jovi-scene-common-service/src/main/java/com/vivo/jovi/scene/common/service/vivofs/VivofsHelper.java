package com.vivo.jovi.scene.common.service.vivofs;

import com.vivo.internet.vivofs.client.v2.VivofsClientV2;
import com.vivo.internet.vivofs.client.v2.model.GetFileResult;
import com.vivo.internet.vivofs.client.v2.model.PutFileResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author lijun
 * @date 2018/10/25
 * @since 1.0
 */
public class VivofsHelper {
    private static final String DATE_FORMATTER = "yyyyMMddHH";

    private String appKey;

    private VivofsClientV2 vivofsClient;

    public VivofsHelper(String appKey, VivofsClientV2 vivofsClient) {
        if (StringUtils.isBlank(appKey) || vivofsClient == null) {
            throw new IllegalStateException("Vivofs appKey or client must has value");
        }
        this.appKey = appKey;
        this.vivofsClient = vivofsClient;
    }


    public String putFile(long fileSize, String md5, String fileName, InputStream inputStream) {
        String fileId = generateFileId(md5, fileName);
        try {
            PutFileResult result = vivofsClient.putFile(fileId, fileSize, md5, inputStream);
            if (!result.isSuccess()) {
                throw new VivofsPutException(result.getCode(), result.getMsg(), result.getRequestId());
            }
            return fileId;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PutFileResult putFile(String fileId, File file) {
        try {
            PutFileResult result = vivofsClient.putFile(fileId, file);
            if (!result.isSuccess()) {
                throw new VivofsPutException(result.getCode(), result.getMsg(), result.getRequestId());
            }

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String generateFileId(String md5, String fileName) {
//        return new StringBuilder("/").append(appKey)
        return new StringBuilder().append(appKey)
                .append("/")
                .append(DateFormatUtils.format(new Date(), DATE_FORMATTER)).append("/")
                .append(md5).append("/")
                .append(fileName).toString();
    }

    public GetFileResult getFile(String fileId) {

        return vivofsClient.getFile(fileId);
    }
}
