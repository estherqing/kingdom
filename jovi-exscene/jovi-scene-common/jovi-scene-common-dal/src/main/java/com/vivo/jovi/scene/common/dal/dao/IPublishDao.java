package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.PublishEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPublishDao {

    List<String> getModifyUserName();

    List<PublishEntity> findPublish(@Param("name") String name,
                                    @Param("classification") String classification,
                                    @Param("status") Integer status,
                                    @Param("modifyUserName") String modifyUserName,
                                    @Param("offset") Integer offset,
                                    @Param("limit") Integer limit,
                                    @Param("field") String field,
                                    @Param("order") String order,
                                    @Param("notInStatus") Integer notInStatus);

    long countPublish(@Param("name") String name, @Param("classification") String classification,
                      @Param("status") Integer status, @Param("modifyUserName") String modifyUserName);

    int updateStatus(@Param("strategyId") String strategyId, @Param("modifyUserName") String modifyUserName,
                     @Param("status") Integer status, @Param("failureReason") String failureReason);

    PublishEntity approvalStatus(@Param("strategyId") String strategyId);

    int approvalByOperation(@Param("strategyId") String strategyId,
                            @Param("approvalOperationUserId") String approvalOperationUserId,
                            @Param("approvalOperationUserName") String approvalOperationUserName,
                            @Param("approvalOperationStatus") Integer approvalOperationStatus,
                            @Param("approvalOperationReason") String ApprovalOperationReason);

    int approvalByTest(@Param("strategyId") String strategyId,
                       @Param("approvalTestUserId") String approvalTestUserId,
                       @Param("approvalTestUserName") String approvalTestUserName,
                       @Param("approvalTestStatus") Integer approvalTestStatus,
                       @Param("approvalTestReason") String approvalTestReason);

    int updateStatusByApproval(@Param("strategyId") String strategyId, @Param("status") Integer status);

    int insert(PublishEntity publishEntity);

    int updateStrategy(@Param("id") Long id, @Param("strategyId") String strategyId);

    List<PublishEntity> getPublishByClassification(@Param("classification") String classification);

    PublishEntity selectByStrategyId(@Param("strategyId") String strategyId);

    int updatePublishStrategy(@Param("strategyId") String strategyId,
                              @Param("type") Integer type,
                              @Param("greyType") String greyType,
                              @Param("imeiGreyType") Integer imeiGreyType,
                              @Param("imeiDefineType") String imeiDefineType,
                              @Param("status") Integer status,
                              @Param("imeiEndNums") String imeiEndNums,
                              @Param("groupName") String groupName,
                              @Param("tags") String tags,
                              @Param("modifyUserName") String modifyUserName,
                              @Param("clientVersion") Integer clientVersion,
                              @Param("phoneModelType") Integer phoneModelType,
                              @Param("phoneModelList") String phoneModelList,
                              @Param("androidVersionType") Integer androidVersionType,
                              @Param("androidVersionList") String androidVersionList,
                              @Param("expectedRelease") long expectedRelease);

    List<PublishEntity> getPublishByBizId(@Param("bizId") String tipsId);

    int updateSelective(PublishEntity publishEntity);

    int updateCardsSelective(PublishEntity publishEntity);

    void updateBizStatus(@Param("bizId") String tipsId, @Param("modifyUserName") String modifyUserName, @Param("bizStatus") Integer bizStatus);

    int clearOperationMsg(@Param("strategyId") String strategyId);

    List<PublishEntity> getAll();

    List<PublishEntity> getPublish(@Param("bizId") String bizId);

    List<PublishEntity> findAllPublish();

    void batchUpdate(List<PublishEntity> publishEntities);

    List<PublishEntity> selectByBizIdAndVersion(@Param("bizId") String tipsId, @Param("bizVersionCode") Integer versionCode);

    /*
     *   根据bizId和version code更新bizStatus
     * */
    void updateBizStatusByVersionCode(@Param("bizId") String bizId, @Param("bizVersionCode") Integer bizVersionCode,
                                      @Param("modifyUserName") String modifyUserName, @Param("bizStatus") Integer bizStatus);
}
