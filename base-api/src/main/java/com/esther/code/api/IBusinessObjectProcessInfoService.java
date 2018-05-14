package com.esther.code.api;

import com.esther.code.flow.flownode.BusinessType;
import com.esther.code.flow.flownode.FlowNodeOperator;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.BusinessObjectProcessInfoExample;
import com.esther.code.util.DataPage;

import java.util.List;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/10.
 * <p>
 * 业务对象流程过程信息处理接口
 */
public interface IBusinessObjectProcessInfoService {

	List<BusinessObjectProcessInfo> fetchByExample(BusinessObjectProcessInfoExample example);

	/**
	 * 根据主键获取对像
	 *
	 * @param businessObjectsProcessInfo
	 * @return
	 */
	BusinessObjectProcessInfo fetchBusinessObjectProcessInfo(long businessObjectsProcessInfo);

	/**
     * 根据主键获取对像,使用mysql的for update语法
     * @param businessObjectsProcessInfo
     * @return
     */
    BusinessObjectProcessInfo fetchBusinessObjectProcessInfo4Update(long businessObjectsProcessInfo);

    /**
	 * 增加业务对象流程处理信息
	 *
	 * @param info
	 * @return
	 */
	long addBOProcessInfo(BusinessObjectProcessInfo info);

	/**
	 * 修改业务对象流程处理信息
	 *
	 * @param info
	 * @return
	 */
	long updateBOProcessInfo(BusinessObjectProcessInfo info);

	/**
	 * 获取业务对象所正处理的业务流程信息
	 * <p>
	 * 之前走过的流程信息不符合此逻辑，一个业务对象只可能有一条正在处理的流程节点信息与之对应
	 *
	 * @param boId
	 * @return
	 */
	BusinessObjectProcessInfo getProcessingInfoOfBO(Long boId, BusinessType businessType);

	/**
	 * 获取业务对象所处理的最后一个业务流程信息,包括已完成的流程
	 *
	 * @param boId
	 * @param businessType
	 * @return
	 */
	BusinessObjectProcessInfo getLastProcessInfoOfBO(Long boId, BusinessType businessType);

	/**
	 * 获取某一业务对象流程信息列表
	 *
	 * @param boId
	 * @param businessType
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	DataPage<BusinessObjectProcessInfo> getBOProcessFlowInfos(Long boId, BusinessType businessType, int currentPage, int pageSize);

	/**
	 * 获取贷款业务对象流程信息列表.
	 * <p>
	 * 根据loanProjectId获取此贷款相关的所有业务,包括<i>普通贷款</i>,<i>贷款修改</i>和<i>贷款作废</i>业务的流程信息

	 *
	 * @param loanApplyIds
	 *            贷款申请主键列表
	 * @param currentPage
	 *            当前页码
	 * @param pageSize
	 *            每页条数
	 * @return 满足条件的分页的过程信息
	 */
	DataPage<BusinessObjectProcessInfo> getBOProcessFlowInfosForLoan(List<Long> loanApplyIds, int currentPage, int pageSize);

	/**
	 * 获取某一业务对象流程信息列表
	 *
	 * @param boId
	 * @param businessType
	 * @return
	 */
	List<BusinessObjectProcessInfo> getBOProcessFlowInfos(Long boId, BusinessType businessType);

	/**
	 * 根据当前业务对象获取上一流程节点处理信息
	 *
	 * @param currentBOPInfo
	 * @return
	 */
	BusinessObjectProcessInfo getPreProcessedInfoOfBOPInfo(BusinessObjectProcessInfo currentBOPInfo);

	/**
	 * 根据当前业务对象主键，获取指定流程节点的处理信息
	 *
	 * @param boId
	 * @param appointedFlowNode
	 * @return
	 */
	List<BusinessObjectProcessInfo> getAppointedFlowNodeProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                          FlowNodeOperator appointedFlowNode);

	/**
	 * 根据当前业务对象主键，获取指定流程节点的任意一个处理信息
	 *
	 * @param boId
	 * @param appointedFlowNode
	 * @return
	 */
	BusinessObjectProcessInfo getAppointedFlowNodeAnyoneProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                          FlowNodeOperator appointedFlowNode);

	/**
	 * 根据当前业务对象主键，获取指定流程节点的最近的一个处理信息
	 *
	 * @param boId
	 * @param appointedFlowNode
	 * @return
	 */
	BusinessObjectProcessInfo getLastAppointedFlowNodeProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                        FlowNodeOperator appointedFlowNode);

	/**
	 * 根据当前业务对象主键，获取指定流程节点的最早的一个处理信息
	 *
	 * @param boId
	 * @param appointedFlowNode
	 * @return
	 */
	BusinessObjectProcessInfo getFirstAppointedFlowNodeProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                         FlowNodeOperator appointedFlowNode);

	/**
	 * 获取当前用户所有正在处理的项目
	 *
	 * @param userId
	 * @return
	 */
	Long getTaskCountOfOneUser(Long userId);



	/**
	 * 获取指定用户正在处理的或已处理的任务列表
	 *
	 * @param operatorId
	 * @return
	 */
	DataPage<BusinessObjectProcessInfo> fetchAllProcessInfoOfOneUser(Long operatorId, boolean isSubmitted, int currentPage, int pageSize);

	/**
	 * 根据条件查询已办或待办任务
	 *
	 * @param operatorId
	 * @param borrowerName
	 * @param businessNum
	 * @param launchOrganizationId
	 * @param businessType
	 * @param currentPage
	 * @param pageSize
	 * @param isProcessed
	 * @return
	 */
	DataPage<BusinessObjectProcessInfo> searchProcessInfoOfOneUser(Long operatorId, String borrowerName, String businessNum,
                                                                   Long launchOrganizationId, String businessType, int currentPage, int pageSize, boolean isProcessed);

	/**
	 * 根据条件查询已办或待办任务
	 *
	 * @param operatorId
	 * @param borrowerName
	 * @param businessNum
	 * @param launchOrganizationId
	 * @param businessType
	 * @param flowNode
	 * @param currentPage
	 * @param pageSize
	 * @param isProcessed
	 * @return
	 */
	DataPage<BusinessObjectProcessInfo> searchProcessInfoOfOneUser(Long operatorId, String borrowerName, String businessNum,
                                                                   Long launchOrganizationId, String businessType, String flowNode, int currentPage, int pageSize, boolean isProcessed);

	Integer countProcessInfoOfOneUser(Long operatorId, String borrowerName, String businessNum, Long launchOrganizationId, String businessType, String flowNode, boolean isProcessed);
	/**
	 * 删除业务对象的流程
	 *
	 * @param id
	 * @return
	 */
	int deleteByBusinessObjectId(Long id, String businessType);



	/**
	 * 判断业务{@code businessType}是否流经过指定节点{@code namedNode}
	 *
	 * @param businessObjectId
	 * @param businessType
	 * @param namedNode
	 * @return
	 */
	boolean judgeBOEverThroughNamedNode(Long businessObjectId, BusinessType businessType, FlowNodeOperator<?> namedNode);

	/**
	 * 判断业务对象是不是正处于或所指定的流程节点之后
	 *
	 * @param businessObjectId
	 * @param businessType
	 * @param namedNode
	 * @return
	 */
	boolean judgeBOIsOnOrAfterNamedNode(Long businessObjectId, BusinessType businessType, FlowNodeOperator<?> namedNode);

	/**
	 * 判断业务对象是不是处于所指定的流程节点之后
	 *
	 * @param businessObjectId
	 * @param businessType
	 * @param namedNode
	 * @return
	 */
	boolean judgeBOIsAfterNamedNode(Long businessObjectId, BusinessType businessType, FlowNodeOperator<?> namedNode);



	/**
	 * 结束某一业务的流程
	 *
	 * @param businessObjectId
	 * @return
	 */
	int finishBusinessObjectFlow(Long businessObjectId, BusinessType businessType);

	/**
	 * 设置流程信息是否为已读
	 *
	 * @param bopFlowInfoId
	 */
	void setReadFlag4BOPFlowInfo(Long bopFlowInfoId, boolean isRead);

	/**
	 * 查询用户未读任务数
	 *
	 * @param userId
	 * @return
	 */
	long getUnreadTaskCountOfAUser(Long userId);



	/**
	 * 业务是否已结束
	 *
	 * @param businessObjectsId
	 * @param businessType
	 * @return
	 */
	boolean businessIsFinished(Long businessObjectsId, BusinessType businessType);

	/**
	 * 根据条件:指定的操作者{@code operatorId},查询这个用户处理过的流程节点,(退回再提交的,只取最新一条流程记录),同时相应的业务要正处于指定节点{@code flowNode}上
	 *
	 * @param operatorId
	 * @param borrowerName
	 * @param businessNum
	 * @param launchOrganizationId
	 * @param businessType
	 * @param flowNode
	 * @param currentPage
	 * @param pageSize
	 * @param isProcessed
	 * @return
	 */
	DataPage<BusinessObjectProcessInfo> searchStayOnOneNodeOfUserHasHandle(Long operatorId, String borrowerName, String businessNum,
                                                                           Long launchOrganizationId, String businessType, String flowNode, int currentPage, int pageSize, boolean isProcessed);

	/**
	 * 取消已完成的流程
	 * 
	 * @param businessObjectsId
	 *            业务ID
	 * @param businessType
	 *            业务类型
	 * @return 取消结果
	 */
	boolean cancelFinishedBusinessObjectFlow(Long businessObjectsId, BusinessType businessType);


	/**
	 * 删除知道业务对象的流程
	 * 2018-01-23 wuzhiquan@zafh.com.cn
	 * @param businessObjectProcessInfoId
	 * @return
	 */
	int deleteByBusinessObjectId(Long businessObjectProcessInfoId);

	/**
	 * 修改业务对象流程处理信息(车商加盟流程)
	 * 2018-04-03 wuzhiquan@zafh.com.cn
	 * @param info
	 * @return
	 */
	long updateBOProcessInfo4JoinCarDealer(BusinessObjectProcessInfo info);
}
