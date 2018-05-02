package com.esther.code.service.flow.flownode;

import com.esther.code.api.flow.IBusinessObjectProcessInfoService;
import com.esther.code.api.flow.flownode.BusinessType;
import com.esther.code.api.flow.flownode.FlowNodeOperator;
import com.esther.code.api.flow.flownode.IFlowService;
import com.esther.code.api.logger.LoggerWrapper;
import com.esther.code.api.logger.LoggerWrapperAware;
import com.esther.code.base.exception.CLSException;
import com.esther.code.dao.BusinessObjectProcessInfoMapper;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.BusinessObjectProcessInfoExample;
import com.esther.code.util.DataPage;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Author: jiyanbin@zafh.com.cn JDK: 1.8 Created on 15/11/10.
 */
@Service("defaultBOProcessInfoService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class DefaultBOProcessInfoServiceImpl implements IBusinessObjectProcessInfoService, LoggerWrapperAware {
    @Autowired
    private BusinessObjectProcessInfoMapper mapper;

    @Autowired
    @Qualifier("enumBaseFlowService")
    private IFlowService flowService;


    protected LoggerWrapper logger;

    private Logger log = LoggerFactory.getLogger(DefaultBOProcessInfoServiceImpl.class);

    @Override
    public void setLogger(LoggerWrapper logger) {
        this.logger = logger;
    }

    @Override
    public BusinessObjectProcessInfo fetchBusinessObjectProcessInfo(long businessObjectsProcessInfo) {
        return mapper.selectByPrimaryKey(businessObjectsProcessInfo);
    }

    @Override
    public List<BusinessObjectProcessInfo> fetchByExample(BusinessObjectProcessInfoExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public BusinessObjectProcessInfo fetchBusinessObjectProcessInfo4Update(long businessObjectsProcessInfo) {
        return mapper.selectByPrimaryKey4Update(businessObjectsProcessInfo);
    }

    @Override
    public long addBOProcessInfo(BusinessObjectProcessInfo info) {
        BusinessObjectProcessInfoExample example = new BusinessObjectProcessInfoExample();
        BusinessObjectProcessInfoExample.Criteria criteria = example.createCriteria();
        criteria.andBusinessTypeEqualTo(info.getBusinessType());
        criteria.andIsSubmittedEqualTo(false);
        criteria.andBusinessObjectIdEqualTo(info.getBusinessObjectId());
        List<BusinessObjectProcessInfo> result = mapper.selectByExample(example);
        if (Objects.nonNull(result) && !result.isEmpty()) {
            throw new CLSException("业务重复创建：流程中已经存在id为【" + info.getBusinessObjectId() + "】,业务类型是【"
                    + BusinessType.getInstance(info.getBusinessType()).getDesc() + "】," + "流程节点为【" + result.get(0).getNodeName()
                    + "】且未提交的业务！" + "新流程节点【" + info.getNodeName() + "】不允许创建！");
        }
        return mapper.insertSelective(info);
    }

    @Override
    public long updateBOProcessInfo(BusinessObjectProcessInfo info) {
        log.info("====IBusinessObjectProcessInfoService.updateBOProcessInfo method invoke====");

        //为了应对并查找重复提交而导致IsSubmit被覆盖的问题的问题,此处使用select for update把目标记录锁定。这种做法不合理,但速度最快。:-)
        BusinessObjectProcessInfo target = fetchBusinessObjectProcessInfo4Update(info.getId());
        if (log.isDebugEnabled()) {
            log.debug("======Source BOPInfo :{}======" + info.toString());
            log.debug("======Target BOPInfo :{}======" + target.toString());
        }
        if (target.getIsSubmitted() && !info.getIsSubmitted()) {
            log.error(
                    "====Update BusinessObjectProcessInfo ID:{} Error! is_submitted filed value exchange from true to false is forbidden!====",
                    info.getId());
            throw new CLSException("流程记录更新错误,原流程记录由已提交状态更新为未提交状态,此为非法操作!");
        }
        //}
        return mapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public BusinessObjectProcessInfo getProcessingInfoOfBO(Long boId, BusinessType businessType) {

        return mapper.selectProcessingInfoOfBO(boId, businessType.getBusinessType());
    }

    @Override
    public BusinessObjectProcessInfo getLastProcessInfoOfBO(Long boId, BusinessType businessType) {
        /*
        BusinessObjectProcessInfoExample example = new BusinessObjectProcessInfoExample();
		BusinessObjectProcessInfoExample.Criteria criteria = example.createCriteria();
		criteria.andBusinessObjectIdEqualTo(boId);
		criteria.andBusinessTypeEqualTo(businessType.getBusinessType());
		List<BusinessObjectProcessInfo> bopInfos = mapper.selectByExample(example);
		*/
        List<BusinessObjectProcessInfo> bopInfos = getBOProcessFlowInfos(boId, businessType);
        Optional<BusinessObjectProcessInfo> bopInfoOptional = bopInfos.stream()
                .sorted(Comparator.comparing(BusinessObjectProcessInfo::getFlowIndex).reversed()).findFirst();
        return bopInfoOptional.orElse(null);
    }

    @Override
    public DataPage<BusinessObjectProcessInfo> getBOProcessFlowInfos(Long boId, BusinessType businessType, int currentPage, int pageSize) {
        DataPage<BusinessObjectProcessInfo> data = new DataPage<BusinessObjectProcessInfo>();
        data.setCurrentPage(currentPage);
        data.setPageSize(pageSize);

        data.setData(mapper.selectBOProcessFlowInfos(boId, businessType.getBusinessType(), data));
        return data;
    }

    @Override
    public DataPage<BusinessObjectProcessInfo> getBOProcessFlowInfosForLoan(List<Long> loanApplyIds, int currentPage, int pageSize) {
        DataPage<BusinessObjectProcessInfo> data = new DataPage<BusinessObjectProcessInfo>();
        data.setCurrentPage(currentPage);
        data.setPageSize(pageSize);
        if (Objects.isNull(loanApplyIds) || loanApplyIds.isEmpty()) {
            data.setData(new ArrayList<>());
        } else {
            data.setData(mapper.getBOProcessFlowInfosForLoan(loanApplyIds, data));
        }
        return data;
    }

    @Override
    public List<BusinessObjectProcessInfo> getBOProcessFlowInfos(Long boId, BusinessType businessType) {
        return mapper.selectBOProcessFlowInfos(boId, businessType.getBusinessType(), null);
    }

    @Override
    public BusinessObjectProcessInfo getPreProcessedInfoOfBOPInfo(BusinessObjectProcessInfo currentBOPInfo) {
        List<BusinessObjectProcessInfo> infos = mapper.selectBOProcessFlowInfos(currentBOPInfo.getBusinessObjectId(),
                currentBOPInfo.getBusinessType(), null);
        Optional<BusinessObjectProcessInfo> infoOptional = infos.stream()
                //过滤掉自身节点
                .filter(info -> !Objects.equals(info.getId(), currentBOPInfo.getId()))
                //过滤掉流程节点比自身节点续号大的或者跟自身节点索引相同的节点
                .filter(info -> Integer.compare(getIndexByNode(info), getIndexByNode(currentBOPInfo)) < 0)
                .sorted(Comparator.comparing(BusinessObjectProcessInfo::getFlowIndex).reversed()
                        .thenComparing(Comparator.comparing(BusinessObjectProcessInfo::getCreateDateTime).reversed())).findFirst();
        return infoOptional.orElse(null);
    }

    @Override
    public List<BusinessObjectProcessInfo> getAppointedFlowNodeProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                                 FlowNodeOperator appointedFlowNode) {
        List<BusinessObjectProcessInfo> preBOPInfos = mapper.selectBOPInfoOfOneFlowNode(boId, businessType.getBusinessType(),
                appointedFlowNode.getNodeCode());
        return preBOPInfos;
    }

    @Override
    public BusinessObjectProcessInfo getAppointedFlowNodeAnyoneProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                                 FlowNodeOperator appointedFlowNode) {
        List<BusinessObjectProcessInfo> preBOPInfos = getAppointedFlowNodeProcessedInfoOfBO(boId, businessType, appointedFlowNode);
        return preBOPInfos.stream().findAny().orElse(null);
    }

    @Override
    public BusinessObjectProcessInfo getLastAppointedFlowNodeProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                               FlowNodeOperator appointedFlowNode) {
        List<BusinessObjectProcessInfo> preBOPInfos = getAppointedFlowNodeProcessedInfoOfBO(boId, businessType, appointedFlowNode);
        Optional<BusinessObjectProcessInfo> infoOptional = preBOPInfos.stream()
                .sorted(Comparator.comparing(BusinessObjectProcessInfo::getFlowIndex).reversed()).findFirst();
        return infoOptional.orElse(null);
    }

    @Override
    public BusinessObjectProcessInfo getFirstAppointedFlowNodeProcessedInfoOfBO(Long boId, BusinessType businessType,
                                                                                FlowNodeOperator appointedFlowNode) {
        List<BusinessObjectProcessInfo> preBOPInfos = getAppointedFlowNodeProcessedInfoOfBO(boId, businessType, appointedFlowNode);
        Optional<BusinessObjectProcessInfo> infoOptional = preBOPInfos.stream()
                .sorted(Comparator.comparing(BusinessObjectProcessInfo::getFlowIndex)).findFirst();
        return infoOptional.orElse(null);
    }

    @Override
    public Long getTaskCountOfOneUser(Long userId) {
        return mapper.getTaskCountOfOneUser(userId);
    }


    @Override
    public DataPage<BusinessObjectProcessInfo> fetchAllProcessInfoOfOneUser(Long operatorId, boolean isSubmitted, int currentPage,
                                                                            int pageSize) {
        DataPage<BusinessObjectProcessInfo> data = new DataPage<BusinessObjectProcessInfo>();

        data.setCurrentPage(currentPage);
        data.setPageSize(pageSize);
        data.setData(mapper.selectAllProcessInfoOfOneUser(operatorId, isSubmitted, data));
        return data;
    }

    @Override
    public DataPage<BusinessObjectProcessInfo> searchProcessInfoOfOneUser(Long operatorId, String borrowerName, String businessNum,
                                                                          Long launchOrganizationId, String businessType, int currentPage, int pageSize, boolean isProcessed) {
        return searchProcessInfoOfOneUser(operatorId, borrowerName, businessNum, launchOrganizationId, businessType, null, currentPage,
                pageSize, isProcessed);
    }

    @Override
    public DataPage<BusinessObjectProcessInfo> searchProcessInfoOfOneUser(Long operatorId, String borrowerName, String businessNum,
                                                                          Long launchOrganizationId, String businessType, String flowNode, int currentPage, int pageSize, boolean isProcessed) {
        DataPage<BusinessObjectProcessInfo> data = new DataPage<>();
        data.setCurrentPage(currentPage);
        data.setPageSize(pageSize);
        if (isProcessed) {
            Integer start = (currentPage - 1) * pageSize;
            data.setData(mapper.searchProcessInfoOfOneUserExt(operatorId, borrowerName, businessNum, launchOrganizationId, businessType, flowNode,
                    isProcessed, start, pageSize));

            Integer totalItem = countProcessInfoOfOneUser(operatorId, borrowerName, businessNum, launchOrganizationId, businessType, flowNode, isProcessed);
            data.setTotalItem(totalItem);

        } else {
            data.setData(mapper.searchProcessInfoOfOneUser(operatorId, borrowerName, businessNum, launchOrganizationId, businessType, flowNode,
                    isProcessed, data));
        }
        return data;
    }

    @Override
    public Integer countProcessInfoOfOneUser(Long operatorId, String borrowerName, String businessNum, Long launchOrganizationId, String businessType, String flowNode, boolean isProcessed) {
        return mapper.countProcessInfoOfOneUserExt(operatorId, borrowerName, businessNum, launchOrganizationId, businessType, flowNode,
                isProcessed);
    }


    @Override
    public int deleteByBusinessObjectId(Long businessObjectId, String businessType) {
        return mapper.deleteByBusinessObjectId(businessObjectId, businessType);
    }


    @Override
    public boolean judgeBOEverThroughNamedNode(Long businessObjectId, BusinessType businessType, FlowNodeOperator<?> namedNode) {
        List<BusinessObjectProcessInfo> bopInfos = mapper.selectBOProcessFlowInfos(businessObjectId, businessType.getBusinessType(), null);

        boolean present = bopInfos
                .stream()
                //.filter(info -> Objects.equals(info.getNodeKey(), namedNode.getNodeCode()) && info.getIsSubmitted())
                //选取流程已经结束的节点；或者未结束时，选取当前正在处理的节点。
                .filter(info -> info.getIsSubmitted() || info.getIsFinished())
                .filter(info -> namedNode.getNodeIndex() <= info.getNodeIndex())
                .filter(info -> Objects.equals(info.getApprovalResult(), 1)).findAny().isPresent();
        return present;
    }

    @Override
    public boolean judgeBOIsOnOrAfterNamedNode(Long businessObjectId, BusinessType businessType, FlowNodeOperator<?> namedNode) {
        BusinessObjectProcessInfo bopInfo = getLastProcessInfoOfBO(businessObjectId, businessType);
        if (Objects.isNull(bopInfo)) {
            //throw new RuntimeException("没有找到id为【" + businessObjectId + "】的【" + businessType.getDesc() + "】流程信息");
            return false;
        }
        return BusinessType.getInstance(bopInfo.getBusinessType()).getFlowNode(bopInfo.getNodeKey()).getNodeIndex() >= namedNode
                .getNodeIndex();
    }

    @Override
    public boolean judgeBOIsAfterNamedNode(Long businessObjectId, BusinessType businessType, FlowNodeOperator<?> namedNode) {
        BusinessObjectProcessInfo bopInfo = getLastProcessInfoOfBO(businessObjectId, businessType);
        if (Objects.isNull(bopInfo)) {
            //throw new RuntimeException("没有找到id为【" + businessObjectId + "】的【" + businessType.getDesc() + "】流程信息");
            return false;
        }
        return BusinessType.getInstance(bopInfo.getBusinessType()).getFlowNode(bopInfo.getNodeKey()).getNodeIndex() > namedNode
                .getNodeIndex();
    }


    @Override
    public int finishBusinessObjectFlow(Long businessObjectId, BusinessType businessType) {
        BusinessObjectProcessInfoExample example = new BusinessObjectProcessInfoExample();
        BusinessObjectProcessInfoExample.Criteria criteria = example.createCriteria();
        criteria.andBusinessObjectIdEqualTo(businessObjectId);
        criteria.andBusinessTypeEqualTo(businessType.getBusinessType());
        BusinessObjectProcessInfo info = new BusinessObjectProcessInfo();
        info.setIsFinished(true);
        info.setIsSubmitted(true);
        info.setIsRead(true);

        return mapper.updateByExampleSelective(info, example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void setReadFlag4BOPFlowInfo(Long bopFlowInfoId, boolean isRead) {
        logger.debug(() -> "======================Set business flow info id:{}, status {}", bopFlowInfoId, isRead);
        mapper.readFlag(bopFlowInfoId, isRead);
    }

    @Override
    public long getUnreadTaskCountOfAUser(Long userId) {
        Long count = mapper.getUnreadTaskCountOfAUser(userId);
        if (count == null) {
            return 0;
        }
        return count.longValue();
    }


    @Override
    public boolean businessIsFinished(Long businessObjectsId, BusinessType businessType) {
        Boolean result = mapper.businessIsFinished(businessObjectsId, businessType.getBusinessType());
        if (Objects.isNull(result)) {
            return false;
        }
        return result;
    }

    @Override
    public DataPage<BusinessObjectProcessInfo> searchStayOnOneNodeOfUserHasHandle(Long operatorId, String borrowerName, String businessNum,
                                                                                  Long launchOrganizationId, String businessType, String flowNode, int currentPage, int pageSize, boolean isProcessed) {
        DataPage<BusinessObjectProcessInfo> data = new DataPage<BusinessObjectProcessInfo>();
        data.setCurrentPage(currentPage);
        data.setPageSize(pageSize);
        data.setData(mapper.searchStayOnOneNodeOfUserHasHandle(operatorId, borrowerName, businessNum, launchOrganizationId, businessType,
                flowNode, isProcessed, data));
        return data;
    }

    /**
     * 取消已完成的流程
     *
     * @param businessObjectsId 业务ID
     * @param businessType      业务类型
     * @return 取消结果
     */
    @Transactional
    @Override
    public boolean cancelFinishedBusinessObjectFlow(Long businessObjectsId, BusinessType businessType) {
        if (!businessIsFinished(businessObjectsId, businessType)) {
            throw new CLSException("流程未结束,无法取消");
        }
        List<BusinessObjectProcessInfo> businessObjectProcessInfoList = getBOProcessFlowInfos(businessObjectsId, businessType);
        BusinessObjectProcessInfo lastBop = getLastProcessInfoOfBO(businessObjectsId, businessType);
        if (CollectionUtils.isNotEmpty(businessObjectProcessInfoList)) {
            businessObjectProcessInfoList.stream().forEach(bop -> {
                bop.setIsFinished(false);
                if (Objects.equals(bop.getId(), lastBop.getId())) {
                    bop.setIsSubmitted(false);
                }
                mapper.updateByPrimaryKeySelective(bop);
            });
        }
        return true;
    }

    /**
     * 防止后期添加流程节点导致数据库中index与枚举不一致
     *
     * @param info
     * @return 返回节点在枚举中的index
     */
    private Integer getIndexByNode(BusinessObjectProcessInfo info) {
        return BusinessType.getInstance(info.getBusinessType()).getFlowNode(info.getNodeKey()).getNodeIndex();
    }

    @Override
    public int deleteByBusinessObjectId(Long businessObjectProcessInfoId) {
        return mapper.deleteByPrimaryKey(businessObjectProcessInfoId);
    }

    @Override
    public long updateBOProcessInfo4JoinCarDealer(BusinessObjectProcessInfo info) {
        return mapper.updateByPrimaryKeySelective(info);
    }
}
