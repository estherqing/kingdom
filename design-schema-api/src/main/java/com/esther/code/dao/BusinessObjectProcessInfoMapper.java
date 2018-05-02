/*
 * BusinessObjectProcessInfoMapper.java
 * Copyright? 2015-2015 浙江车果网络科技有限公司
 * All rights reserved.
 * --------------------------------------------
 * 2015-11-11 Created
 */
package com.esther.code.dao;


import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.BusinessObjectProcessInfoExample;
import com.esther.code.util.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessObjectProcessInfoMapper {

    int countByExample(BusinessObjectProcessInfoExample example);

    int deleteByExample(BusinessObjectProcessInfoExample example);

    int deleteByPrimaryKey(Long id);

    long insert(BusinessObjectProcessInfo record);

    BusinessObjectProcessInfo selectByPrimaryKey(Long id);

    BusinessObjectProcessInfo selectByPrimaryKey4Update(Long id);

    List<BusinessObjectProcessInfo> selectAll();

    int updateByPrimaryKey(BusinessObjectProcessInfo record);

    BusinessObjectProcessInfo selectProcessingInfoOfBO(@Param("boId") Long boId, @Param("businessType") String businessType);

    List<BusinessObjectProcessInfo> selectBOProcessFlowInfos(@Param("boId") Long boId, @Param("businessType") String businessType, @Param("page") Paging page);

    List<BusinessObjectProcessInfo> selectBOPInfoOfOneFlowNode(@Param("boId") Long boId, @Param("businessType") String businessType, @Param("nodeKey") String nodeKey);

    Long getTaskCountOfOneUser(Long userId);

    List<BusinessObjectProcessInfo> selectAllProcessInfoOfOneUser(@Param("operatorId") Long operatorId,
                                                                  @Param("isSubmitted") boolean isSubmitted,
                                                                  @Param("page") Paging page);


    List<BusinessObjectProcessInfo> searchProcessInfoOfOneUser(@Param("operatorId") Long operatorId,
                                                               @Param("borrowerName") String borrowerName,
                                                               @Param("businessNum") String businessNum,
                                                               @Param("launchOrganizationId") Long launchOrganizationId,
                                                               @Param("businessType") String businessType,
                                                               @Param("flowNode") String flowNode,
                                                               @Param("isSubmitted") Boolean isSubmitted,
                                                               @Param("page") Paging page);

    List<Long> getNeedLoanOfOneOrganization(@Param("organizationId") Long organizationId,
                                            @Param("businessType") String businessType,
                                            @Param("nodeKey") String nodeKey);

    int deleteByBusinessObjectId(@Param("businessObjectId") Long businessObjectId, @Param("businessType") String businessType);

    int insertSelective(BusinessObjectProcessInfo record);

    List<BusinessObjectProcessInfo> selectByExample(BusinessObjectProcessInfoExample example);

    int updateByExampleSelective(@Param("record") BusinessObjectProcessInfo record, @Param("example") BusinessObjectProcessInfoExample example);

    int updateByExample(@Param("record") BusinessObjectProcessInfo record, @Param("example") BusinessObjectProcessInfoExample example);

    int updateByPrimaryKeySelective(BusinessObjectProcessInfo record);

    List<Long> getBusinessObjectsIdsByExample(BusinessObjectProcessInfoExample example);

    Long getUnreadTaskCountOfAUser(Long operatorId);

    List<Long> getBusinessObjectIdsIncludeAndAfterANode(@Param("launchOrganizationId") Long launchOrganizationId,
                                                        @Param("businessGroupIds") List<Long> businessGroupIds,
                                                        @Param("businessType") String businessType,
                                                        @Param("nodeIndex") int nodeIndex);

    Boolean businessIsFinished(@Param("businessObjectId") Long businessObjectId, @Param("businessType") String businessType);

    List<BusinessObjectProcessInfo> searchStayOnOneNodeOfUserHasHandle(@Param("operatorId") Long operatorId,
                                                                       @Param("borrowerName") String borrowerName,
                                                                       @Param("businessNum") String businessNum,
                                                                       @Param("launchOrganizationId") Long launchOrganizationId,
                                                                       @Param("businessType") String businessType,
                                                                       @Param("flowNode") String flowNode,
                                                                       @Param("isSubmitted") Boolean isSubmitted,
                                                                       @Param("page") Paging page);

    List<BusinessObjectProcessInfo> getBOProcessFlowInfosForLoan(@Param("loanApplyIds") List<Long> loanApplyIds, @Param("page") Paging page);

    void readFlag(@Param("id") Long id, @Param("isRead") Boolean isRead);

    /**
     * 待办任务改进
     * @param operatorId
     * @param borrowerName
     * @param businessNum
     * @param launchOrganizationId
     * @param businessType
     * @param flowNode
     * @param isSubmitted
     * @param
     * @return
     */
    List<BusinessObjectProcessInfo> searchProcessInfoOfOneUserExt(@Param("operatorId") Long operatorId,
                                                                  @Param("borrowerName") String borrowerName,
                                                                  @Param("businessNum") String businessNum,
                                                                  @Param("launchOrganizationId") Long launchOrganizationId,
                                                                  @Param("businessType") String businessType,
                                                                  @Param("flowNode") String flowNode,
                                                                  @Param("isSubmitted") Boolean isSubmitted,
                                                                  @Param("start") Integer start,
                                                                  @Param("pageSize") Integer pageSize);

    Integer countProcessInfoOfOneUserExt(@Param("operatorId") Long operatorId,
                                         @Param("borrowerName") String borrowerName,
                                         @Param("businessNum") String businessNum,
                                         @Param("launchOrganizationId") Long launchOrganizationId,
                                         @Param("businessType") String businessType,
                                         @Param("flowNode") String flowNode,
                                         @Param("isSubmitted") Boolean isSubmitted);

 }