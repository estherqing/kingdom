package com.vivo.jovi.exscene.backend.service.impl;

import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IUploadFileService;
import com.vivo.jovi.scene.common.service.vivofs.IVivoFsService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-02-20 11:27
 */
@Service
public class UploadFileService implements IUploadFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileService.class);

    /**
     * 校验imei是否为15个数字
     */
    private static final Pattern pattern = Pattern.compile("^\\d{15}$");

    @Autowired
    private IVivoFsService vivoFsService;

    @Override
    public String uploadFile(String fileName, InputStream input, String docSuffix) throws IOException {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        String imeiFileId = "";
        File zipFile = null;

        try {

            zipFile = new File(System.getProperty("java.io.tmpdir") +
                    System.getProperty("file.separator") + fileName.substring(0, fileName.lastIndexOf(".") + 1) + docSuffix);

            outputStream = new FileOutputStream(zipFile);
            IOUtils.copy(input, outputStream);

            inputStream = new FileInputStream(zipFile);

            imeiFileId = vivoFsService.uploadFile(fileName.substring(0, fileName.lastIndexOf(".") + 1) + docSuffix,
                    inputStream);

        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inputStream);
            zipFile.delete();
        }

        return StringUtils.isBlank(imeiFileId) ? null : vivoFsService.joinFileIdByCertainHost(imeiFileId,
                VivoConfigManager.getString("jovi.scene.file.download.host"));
    }

    @Override
    public String uploadFile(String fileName, InputStream inputStream) throws IOException {
        //需要把普通文件的输入流压缩
        ZipOutputStream out = null;
        InputStream zipInput = null;
        String imeiFileId = "";
        File zipFile = null;
        try {
            zipFile = new File(System.getProperty("java.io.tmpdir") +
                    System.getProperty("file.separator") + fileName.substring(0, fileName.lastIndexOf(".") + 1) + "zip");
            out = new ZipOutputStream(new FileOutputStream(zipFile));
            out.putNextEntry(new ZipEntry(fileName));
            IOUtils.copy(inputStream, out);
            out.closeEntry();
            out.finish();

            zipInput = new FileInputStream(zipFile);
            imeiFileId = vivoFsService.uploadFile(fileName.substring(0, fileName.lastIndexOf(".") + 1) + "zip",
                    zipInput);
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(zipInput);
            zipFile.delete();
        }

        return StringUtils.isBlank(imeiFileId) ? null : vivoFsService.joinFileIdByCertainHost(imeiFileId,
                VivoConfigManager.getString("jovi.scene.file.download.host"));
    }

    @Override
    public String getImeisFile(String data) throws IOException {
        if (data == null) {
            return "data不能为空！";
        }

        String host = VivoConfigManager.getString("jovi.scene.file.download.host");
        Integer starIndex = host.length();

        String imeiFileId = data.substring(starIndex + 1, data.length());
        return vivoFsService.getImeisFile(imeiFileId);
    }

    @Override
    public void delFile(String data) {
        if (data == null) {
            return;
        }
        String host = VivoConfigManager.getString("jovi.scene.file.download.host");
        Integer starIndex = host.length();
        String imeiFileId = data.substring(starIndex + 1, data.length());

        vivoFsService.deleteFile(imeiFileId);
    }

    @Override
    public boolean validImeiFile(MultipartFile file) {
        InputStream in = null;
        ByteArrayOutputStream baos = null;
        boolean flag = true;
        try {
            in = file.getInputStream();
            //创建字节数组输出流，用来输出读取到的内容
            baos = new ByteArrayOutputStream();
            //创建缓存大小
            byte[] buffer = new byte[2048]; // 1KB
            //每次读取到内容的长度
            int len = -1;
            //开始读取输入流中的内容
            while ((len = in.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            String content = baos.toString();
            String newImeis = content.replaceAll("\r|\n", "");
            String[] imeiArray = newImeis.split(",");
            for (String str : imeiArray) {
                if (!pattern.matcher(str).matches()) {
                    flag = false;
                    break;
                }
            }
            return flag;
        } catch (Exception e) {
            LOGGER.error("validImeiFile error", e);
            return false;
        } finally {
            try {
                in.close();
                baos.close();
            } catch (IOException e) {
                LOGGER.error("validImeiFile Stream close error", e);
            }
        }

    }
}
