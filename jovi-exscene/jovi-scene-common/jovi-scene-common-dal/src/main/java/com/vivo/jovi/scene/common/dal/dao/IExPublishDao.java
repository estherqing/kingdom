package com.vivo.jovi.scene.common.dal.dao;

import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: IExPublishDao
 * @Description: 外销运营平台发布策略DAO
 * @Author: Lu Guodong
 * @CreateDate: 2019/5/17 15:20
 * @UpdateDate: 2019/5/17 15:20
 */
public interface IExPublishDao {
    /**
     * 获取最新发布/修改的策略信息
     *
     * @param sourceType 数据来源类型
     * @return
     */
    ExPublishEntity getLatestStrategy(@Param("sourceType") String sourceType);

    List<ExPublishEntity> findPublish(@Param("name") String name,
                                      @Param("status") Integer status,
                                      @Param("offset") Integer offset,
                                      @Param("limit") Integer limit,
                                      @Param("field") String field,
                                      @Param("order") String order);

    long countPublish(@Param("name") String name, @Param("status") Integer status);

    ExPublishEntity selectByStrategyId(@Param("strategyId") String strategyId, @Param("bizId") String bizId);

    int updateStatus(@Param("strategyId") String strategyId, @Param("modifyUserName") String modifyUserName,
                     @Param("status") Integer status, @Param("failureReason") String failureReason);

    ExPublishEntity approvalStatus(@Param("strategyId") String strategyId);

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

    int insertSelective(ExPublishEntity publishEntity);

    int updateSelective(ExPublishEntity publishEntity);

    int updateStrategy(@Param("id") Long id, @Param("strategyId") String strategyId);

    List<ExPublishEntity> selectByBizId(@Param("bizId") String bizId);

    int updatePublishStrategy(@Param("strategyId") String strategyId,
                              @Param("intelligSceneEdition") String intelligSceneEdition,
                              @Param("type") Integer type,
                              @Param("fileUrl") String fileUrl,
                              @Param("fileName") String fileName,
                              @Param("roleGrey") String roleGrey,
                              @Param("status") Integer status,
                              @Param("modifyUserName") String modifyUserName,
                              @Param("clientVersion") Integer clientVersion,
                              @Param("expectedRelease") long expectedRelease);

    /**
     * 获取所有的发布策略
     *
     * @return
     */
    List<ExPublishEntity> findAllPublish();

    /**
     * 更新实际发布量
     *
     * @param publishEntities
     */
    void updateActualRelease(List<ExPublishEntity> publishEntities);

    /**
     * 更新发布策略的bizStatus
     *
     * @param bizId
     * @param bizStatus
     * @param modifyUserName
     */
    void updateBizStatus(@Param("bizId") String bizId, @Param("modifyUserName") String modifyUserName,
                         @Param("bizStatus") Integer bizStatus);

    /**
     * 查询灰度或全量的活动卡片发布策略
     */
    List<ExPublishEntity> selectActivityCardPublishStrategy();

    /**
     * 增量查询灰度或全量的活动卡片发布策略
     */
    List<ExPublishEntity> selectIncrementActivityCardPublishStrategy(@Param("lastQueryTime") String lastQueryTime);
}
