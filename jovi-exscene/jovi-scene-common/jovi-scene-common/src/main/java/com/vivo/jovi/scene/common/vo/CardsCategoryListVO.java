package com.vivo.jovi.scene.common.vo;

import java.util.List;

/**
 * @Classname CardsCategoryListVO
 * @Description TODO
 * @Date 2019-03-27 15:44
 * @Created by Administrator
 * @Version 1.0
 */

public class CardsCategoryListVO {

    private List<CardsCategoryVO> OneLevelCardsCategoryList;

    private List<CardsCategoryVO> secondLevelCardsCategoryList;

    public List<CardsCategoryVO> getOneLevelCardsCategoryList() {
        return OneLevelCardsCategoryList;
    }

    public void setOneLevelCardsCategoryList(List<CardsCategoryVO> oneLevelCardsCategoryList) {
        OneLevelCardsCategoryList = oneLevelCardsCategoryList;
    }

    public List<CardsCategoryVO> getSecondLevelCardsCategoryList() {
        return secondLevelCardsCategoryList;
    }

    public void setSecondLevelCardsCategoryList(List<CardsCategoryVO> secondLevelCardsCategoryList) {
        this.secondLevelCardsCategoryList = secondLevelCardsCategoryList;
    }
}
