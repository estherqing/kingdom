package com.esther.code.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by gaowenlin on 2015/11/22.
 */
public class ZipUtils {
    // private static final Logger LOGGER = LoggerFactory.getLogger(ZipUtils.class);

    public static void Zip(String sourceDir, String destFile, String defaultParentPath) {
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new FileOutputStream(destFile));
            //启动压缩进程
            startCompress(zos, defaultParentPath, sourceDir);
        } catch (FileNotFoundException e) {
            //LOGGER.error("文件压缩失败", e);
        } finally {
            try {
                if (zos != null) zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private static void startCompress(ZipOutputStream zos, String oppositePath, String directory) {
        File file = new File(directory);
        if (file.isDirectory()) {
            //如果是压缩目录
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File aFile = files[i];
                if (aFile.isDirectory()) {
                    //如果是目录，修改相对地址
                    String newOppositePath = oppositePath + aFile.getName() + File.separator;
                    //创建目录
                    compressDirectory(zos, oppositePath, aFile);
                    //进行递归调用
                    startCompress(zos, newOppositePath, aFile.getPath());
                } else {
                    //如果不是目录，则进行压缩
                    if (aFile.isFile() && aFile.getName().indexOf(".zip") > 0) {
                        continue;
                    }
                    compressFile(zos, oppositePath, aFile);
                }
            }
        } else {
            //如果是压缩文件，直接调用压缩方法进行压缩
            compressFile(zos, oppositePath, file);
        }

    }

    //压缩文件
    private static void compressFile(ZipOutputStream zos, String oppositePath, File file) {
        //创建一个Zip条目，每个Zip条目都是必须相对于根路径
        ZipEntry entry = new ZipEntry(oppositePath + file.getName());
        InputStream is = null;
        try {
            //将条目保存到Zip压缩文件当中
            zos.putNextEntry(entry);
            //从文件输入流当中读取数据，并将数据写到输出流当中.
            is = new FileInputStream(file);
            int length = 0;
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while ((length = is.read(buffer, 0, bufferSize)) >= 0) {
                zos.write(buffer, 0, length);
            }
            zos.flush();
            zos.closeEntry();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //压缩目录
    private static void compressDirectory(ZipOutputStream zos, String oppositePath, File file) {
        //压缩目录，这是关键，创建一个目录的条目时，需要在目录名后面加多一个"/"
        ZipEntry entry = new ZipEntry(oppositePath + file.getName() + File.separator);
        try {
            zos.putNextEntry(entry);
            //zos.flush();
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解压指定zip文件
    public static void unZip(String unZipfileName,String target){//unZipfileName需要解压的zip文件名
        ZipInputStream  zipIn;
        FileOutputStream fileOut;
        ZipEntry zipEntry;
        File file;
        byte[] buf = new byte[512];
        int readedBytes;
        try{
            zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(unZipfileName)));

            while((zipEntry = zipIn.getNextEntry()) != null){
                file = new File(target+zipEntry.getName());
                if(zipEntry.isDirectory()){
                    file.mkdirs();
                }
                else{
                    //如果指定文件的目录不存在,则创建之.
                    File parent = file.getParentFile();
                    if(parent!=null &&!parent.exists()){
                        parent.mkdirs();
                    }
                    fileOut = new FileOutputStream(file);
                    while(( readedBytes = zipIn.read(buf) ) > 0){
                        fileOut.write(buf , 0 , readedBytes );
                    }
                    fileOut.close();
                }
                zipIn.closeEntry();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    //解压指定zip文件
    public static void unZip(FileInputStream fileInputStream,String target){//unZipfileName需要解压的zip文件名
        ZipInputStream  zipIn;
        FileOutputStream fileOut;
        ZipEntry zipEntry;
        File file;
        byte[] buf = new byte[512];
        int readedBytes;
        try{
            zipIn = new ZipInputStream(new BufferedInputStream(fileInputStream));

            while((zipEntry = zipIn.getNextEntry()) != null){
                file = new File(target+zipEntry.getName());
                if(zipEntry.isDirectory()){
                    file.mkdirs();
                }
                else{
                    //如果指定文件的目录不存在,则创建之.
                    File parent = file.getParentFile();
                    if(parent!=null &&!parent.exists()){
                        parent.mkdirs();
                    }

                    fileOut = new FileOutputStream(file);
                    while(( readedBytes = zipIn.read(buf) ) > 0){
                        fileOut.write(buf , 0 , readedBytes );
                    }
                    fileOut.close();
                }
                zipIn.closeEntry();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * 解压byte[]
     * @param data
     * @return
     */
    public static Map<String, byte[]> unZip(byte[] data) {
        Map<String, byte[]> map = new HashMap<>();
        ZipInputStream  zipIn;
        ZipEntry zipEntry;
        try {
            zipIn = new ZipInputStream(new ByteArrayInputStream(data));
            while((zipEntry = zipIn.getNextEntry()) != null){
                byte[] buf = new byte[1024];
                int num;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((num = zipIn.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, num);
                }
                map.put(zipEntry.getName(), baos.toByteArray());
                baos.flush();
                baos.close();
            }
            zipIn.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }
}
