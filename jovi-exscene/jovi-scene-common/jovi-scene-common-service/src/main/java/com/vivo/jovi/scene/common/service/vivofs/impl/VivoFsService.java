package com.vivo.jovi.scene.common.service.vivofs.impl;

import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.internet.vivofs.client.VivofsClient;
import com.vivo.internet.vivofs.client.v2.VivofsClientV2;
import com.vivo.internet.vivofs.client.v2.model.DeleteFileResult;
import com.vivo.internet.vivofs.client.v2.model.GetFileResult;
import com.vivo.jovi.scene.common.service.vivofs.IVivoFsService;
import com.vivo.jovi.scene.common.service.vivofs.VivofsHelper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author lijun
 * @version 1.0
 * @describe
 * @date 2018/10/25
 */
@Service
public class VivoFsService implements IVivoFsService, InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(VivoFsService.class);

    private static final String DEFAULT_ENCODING = "GBK";//编码

    private static final int PROTECTED_LENGTH = 5 * 1024;// 输入流保护 5M

    @Autowired
    private VivofsClientV2 vivofsClientV2;

    private VivofsHelper vivofsHelper;

    @Value("${vivofs.app.key}")
    private String appKey;

    @Value("${file.download.host}")
    private String vivofsHost;

    private static final String END_POINT = VivoConfigManager.get("vivofs.end.point", "http://middle1.dev.vivo.xyz:8888");

    private static final String APP_KEY = VivoConfigManager.get("vivofs.app.key", "KUUfTBXDb5ZoGaT3");

    private static final String APPSECRET = VivoConfigManager.get("vivofs.app.secret", "b037677631b79a319d4ec911c66fe145");

    private static final VivofsClient VIVOFS_CLIENT = new VivofsClient(END_POINT, APP_KEY, APPSECRET);

    @Override
    public void afterPropertiesSet() throws Exception {
        vivofsHelper = new VivofsHelper(appKey, vivofsClientV2);
    }

    @Override
    public String uploadFile(long fileSize, String md5, String fileName, InputStream input) {
        return vivofsHelper.putFile(fileSize, md5, fileName, input);
    }

    @Override
    public String uploadFile(String fileName,InputStream input){
        byte [] data = new byte[0];
        try {
            data = IOUtils.toByteArray(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String md5 = DigestUtils.md5Hex(data);
        return uploadFile(data.length,md5,fileName,new ByteArrayInputStream(data));
    }

    @Override
    public void deleteFile(String fileId) {
        DeleteFileResult result = vivofsClientV2.deleteFile(fileId);

        if (result != null && result.isSuccess()) {
            return;
        } else {
            throw new RuntimeException("delete error, return code is " + result.getCode() + " msg is " + result.getMsg());
        }
    }

    @Override
    public String getDonwloadHost() {
        return vivofsHost;
    }

    /**
     * 将fileId和文件服务的域名拼接起来
     * @param fileId
     * @return
     */
    @Override
    public String joinFileId(String fileId){
        String host = getDonwloadHost();
        if(host.endsWith("/")){
            host = StringUtils.substring(host,0,-1);
        }
        String fileIdToUse = fileId;
        if(!fileIdToUse.startsWith("/")){
            fileIdToUse = "/" + fileIdToUse;
        }
        return host + fileIdToUse;
    }


    /**
     * 将fileId和指定的域名拼接起来
     * @param fileId
     * @param host
     * @return
     */
    @Override
    public String joinFileIdByCertainHost(String fileId, String host) {
        if(host.endsWith("/")){
            host = StringUtils.substring(host,0,-1);
        }
        String fileIdToUse = fileId;
        if(!fileIdToUse.startsWith("/")){
            fileIdToUse = "/" + fileIdToUse;
        }
        return host + fileIdToUse;
    }

    @Override
    public String getImeisFile(String fileId) {
        GetFileResult file = vivofsHelper.getFile(fileId);
        if (file == null) {
            return null;
        }

        InputStream input = file.getData().getContent();
        if (input == null) {
            return null;
        }
        //字节数组
        byte[] bcache = new byte[2048];
        int readSize = 0;//每次读取的字节长度
        ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
        try {
            //一次性读取2048字节
            while ((readSize = input.read(bcache)) > 0) {

                infoStream.write(bcache,0,readSize);
            }
        } catch (IOException e1) {
            LOGGER.error("imei文件读取数据异常， msg : {}", e1);
            return null;
        } finally {
            try {
                //输入流关闭
                input.close();
            } catch (IOException e) {
                return null;
            }
        }

        try {
            return infoStream.toString(DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("infoStream error！", e);
            return null;
        }
    }

}
