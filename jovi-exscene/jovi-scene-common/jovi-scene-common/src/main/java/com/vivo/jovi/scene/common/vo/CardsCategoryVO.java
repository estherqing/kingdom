package com.vivo.jovi.scene.common.vo;

/**
 * @Classname CardsCategoryVO
 * @Description TODO
 * @Date 2019-03-27 15:35
 * @Created by xj
 * @Version 1.0
 */
public class CardsCategoryVO {

    /**一级分类id */
 private Integer categorieId;

 private String categorieName;

 /**二级分类id */
 private Integer subCategorieId;

 private String subCategorieName;


 public Integer getCategorieId() {
  return categorieId;
 }

 public void setCategorieId(Integer categorieId) {
  this.categorieId = categorieId;
 }

 public String getCategorieName() {
  return categorieName;
 }

 public void setCategorieName(String categorieName) {
  this.categorieName = categorieName;
 }

 public Integer getSubCategorieId() {
  return subCategorieId;
 }

 public void setSubCategorieId(Integer subCategorieId) {
  this.subCategorieId = subCategorieId;
 }

 public String getSubCategorieName() {
  return subCategorieName;
 }

 public void setSubCategorieName(String subCategorieName) {
  this.subCategorieName = subCategorieName;
 }
}
