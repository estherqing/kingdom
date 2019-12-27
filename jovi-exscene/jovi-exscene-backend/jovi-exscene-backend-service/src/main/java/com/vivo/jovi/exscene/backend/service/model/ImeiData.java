package com.vivo.jovi.exscene.backend.service.model;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @program: ssdp-intellig-scene
 * @description:
 * @author: xuxitao
 * @create: 2018-12-22 16:48
 **/
public class ImeiData {
    private Integer releaseType;
    private List<String> imeiList;
    private List<String> mantissaList1;
    private List<String> mantissaList2;
    private String fileId;
    private String fileName;

    public Integer getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(Integer releaseType) {
        this.releaseType = releaseType;
    }

    public List<String> getImeiList() {
        return imeiList;
    }

    public void setImeiList(List<String> imeiList) {
        this.imeiList = imeiList;
    }

    public List<String> getMantissaList1() {
        return mantissaList1;
    }

    public void setMantissaList1(List<String> mantissaList1) {
        this.mantissaList1 = mantissaList1;
    }

    public List<String> getMantissaList2() {
        return mantissaList2;
    }

    public void setMantissaList2(List<String> mantissaList2) {
        this.mantissaList2 = mantissaList2;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean verify(boolean nextFlag){
        if(nextFlag){
            if(releaseType==null){
                return true;
            }

            if(releaseType==2 && imeiList==null && StringUtils.isBlank(fileId) &&
                    StringUtils.isBlank(fileName)  && mantissaList1==null &&
                    mantissaList2==null){
                return true;
            }
        }

        return false;
    }
}
