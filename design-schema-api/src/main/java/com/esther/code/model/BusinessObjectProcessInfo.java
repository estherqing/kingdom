package com.esther.code.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class BusinessObjectProcessInfo implements Serializable {

    private static final long serialVersionUID = 5993286892322436568L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 业务对像ID
     */
    @NotNull(message = "业务对象主键不能为空")
    private Long businessObjectId;

    /**
     * 业务类型，标识此为哪一种业务对象
     */
    @NotNull(message = "业务类型不能为空")
    private String businessType;

    /**
     * 用户ID
     */
    private Long borrowerId;

    /**
     * 客户名称
     */
    private String borrowerName;

    /**
     * 发起人ID
     */
    @NotNull(message = "业务发起者主键不能为空")
    private Long launchUserId;

    /**
     * 发起人姓名
     */
    @NotNull(message = "业务对象姓名不能为空")
    private String launchUserName;

    /**
     * 发起机构ID（分公司ID）
     */
    @NotNull(message = "业务发起机构主键不能为空")
    private Long launchOrganizationId;

    /**
     * 发起机构名称（分公司名称）
     */
    @NotNull(message = "业务发起机构不能为空")
    private String launchOrganizationName;

    /**
     * 业务组ID
     */
    @NotNull(message = "业务组主键不能为空")
    private Long businessGroupId;

    /**
     * 业务组名称
     */
    @NotNull(message = "业务组不能为空")
    private String businessGroupName;

    /**
     * 业务编码
     */
    @NotNull(message = "业务编码不能为空")
    private String businessNum;

    /**
     * 是否是贴息业务，仅对贷款，贷款修改，贷款作废流程有业务意义（0：否，1：是）
     */
    private Boolean isAdvance=false;

    /**
     * 是否是二手车业务，仅对贷款，贷款修改，贷款作废流程有业务意义（0：否，1：是）
     */
    private Boolean isSecondHandCar=false;

    /**
     * 是否已提交至下一节点，0：未提交，1：已提交
     */
    private Boolean isSubmitted = false;

    /**
     * 是否已读（0：未读，1：已读）
     */
    private Boolean isRead = false;

    /**
     * 流程是否已结束（0：未结束，1：已结束）
     */
    private Boolean isFinished = false;

    /**
     * 上一节点key
     */
    private String lastNodeKey;

    /**
     * 上一流程节点名称
     */
    private String lastNodeName;

    /**
     * 上一节点索引
     */
    private Integer lastNodeIndex;

    /**
     * 流程节点的key
     */
    @NotNull(message = "流程节点编码不能为空")
    private String nodeKey;

    /**
     * 流程节点名称
     */
    @NotNull(message = "流程节点名称不能为空")
    private String nodeName;

    /**
     * 节点索引，表示此节点是流程中的第几个节点，这个值在流程确定后不会改变
     */
    @NotNull(message = "流程节点索引不能为空")
    private Integer nodeIndex;

    /**
     * 流程索引，一个业务对象走流程后，每一次操作，此值顺序递增
     */
    private Integer flowIndex;

    /**
     * 标识流程的版本
     */
    private String flowVersion;

    /**
     * 流程类型
     */
    private String flowType;

    /**
     * 操作角色Key
     */
    private String operationRoleKey;

    /**
     * 角色名称
     */
    private String operationRoleName;

    /**
     * 操作人外键
     */
    private Integer operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 审批结果，-1：待办；0：不同意；1：同意；2：补件。【2主要是经营管理部审批结果选项】;3：关闭项目（贷款项目在区域经理时，可以关闭此贷款）
     */
    private Integer approvalResult;

    /**
     * 创建时间，即：流转到当前节点的时间
     */
    private Date createDateTime;

    /**
     * 审批时间
     */
    private Date approvalDateTime;

    /**
     * 提交到下一节点的时间
     */
    private Date submittedDateTime;

    /**
     * 审批意见
     */
    private String approvalNote;

    /**
     * 不同意原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    private String declineReasonKey;

    /**
     * 补件原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    private String rfeReasonKey;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 二证业务(0:否，1:是)
     */
    private Integer isTwoCard;

    /**
     * 获取主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取业务对像ID
     */
    public Long getBusinessObjectId() {
        return businessObjectId;
    }

    /**
     * 设置业务对像ID
     */
    public void setBusinessObjectId(Long businessObjectId) {
        this.businessObjectId = businessObjectId;
    }

    /**
     * 获取业务类型，标识此为哪一种业务对象
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置业务类型，标识此为哪一种业务对象
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 获取用户ID
     */
    public Long getBorrowerId() {
        return borrowerId;
    }

    /**
     * 设置用户ID
     */
    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    /**
     * 获取客户名称
     */
    public String getBorrowerName() {
        return borrowerName;
    }

    /**
     * 设置客户名称
     */
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName == null ? null : borrowerName.trim();
    }

    /**
     * 获取发起人ID
     */
    public Long getLaunchUserId() {
        return launchUserId;
    }

    /**
     * 设置发起人ID
     */
    public void setLaunchUserId(Long launchUserId) {
        this.launchUserId = launchUserId;
    }

    /**
     * 获取发起人姓名
     */
    public String getLaunchUserName() {
        return launchUserName;
    }

    /**
     * 设置发起人姓名
     */
    public void setLaunchUserName(String launchUserName) {
        this.launchUserName = launchUserName == null ? null : launchUserName.trim();
    }

    /**
     * 获取发起机构ID（分公司ID）
     */
    public Long getLaunchOrganizationId() {
        return launchOrganizationId;
    }

    /**
     * 设置发起机构ID（分公司ID）
     */
    public void setLaunchOrganizationId(Long launchOrganizationId) {
        this.launchOrganizationId = launchOrganizationId;
    }

    /**
     * 获取发起机构名称（分公司名称）
     */
    public String getLaunchOrganizationName() {
        return launchOrganizationName;
    }

    /**
     * 设置发起机构名称（分公司名称）
     */
    public void setLaunchOrganizationName(String launchOrganizationName) {
        this.launchOrganizationName = launchOrganizationName == null ? null : launchOrganizationName.trim();
    }

    /**
     * 获取业务组ID
     */
    public Long getBusinessGroupId() {
        return businessGroupId;
    }

    /**
     * 设置业务组ID
     */
    public void setBusinessGroupId(Long businessGroupId) {
        this.businessGroupId = businessGroupId;
    }

    /**
     * 获取业务组名称
     */
    public String getBusinessGroupName() {
        return businessGroupName;
    }

    /**
     * 设置业务组名称
     */
    public void setBusinessGroupName(String businessGroupName) {
        this.businessGroupName = businessGroupName == null ? null : businessGroupName.trim();
    }

    /**
     * 获取业务编码
     */
    public String getBusinessNum() {
        return businessNum;
    }

    /**
     * 设置业务编码
     */
    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum == null ? null : businessNum.trim();
    }

    /**
     * 获取是否是贴息业务，仅对贷款，贷款修改，贷款作废流程有业务意义（0：否，1：是）
     */
    public Boolean getIsAdvance() {
        return isAdvance;
    }

    /**
     * 设置是否是贴息业务，仅对贷款，贷款修改，贷款作废流程有业务意义（0：否，1：是）
     */
    public void setIsAdvance(Boolean isAdvance) {
        this.isAdvance = isAdvance;
    }

    /**
     * 获取是否是二手车业务，仅对贷款，贷款修改，贷款作废流程有业务意义（0：否，1：是）
     */
    public Boolean getIsSecondHandCar() {
        return isSecondHandCar;
    }

    /**
     * 设置是否是二手车业务，仅对贷款，贷款修改，贷款作废流程有业务意义（0：否，1：是）
     */
    public void setIsSecondHandCar(Boolean isSecondHandCar) {
        this.isSecondHandCar = isSecondHandCar;
    }

    /**
     * 获取是否已提交至下一节点，0：未提交，1：已提交
     */
    public Boolean getIsSubmitted() {
        return isSubmitted;
    }

    /**
     * 设置是否已提交至下一节点，0：未提交，1：已提交
     */
    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    /**
     * 获取是否已读（0：未读，1：已读）
     */
    public Boolean getIsRead() {
        return isRead;
    }

    /**
     * 设置是否已读（0：未读，1：已读）
     */
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取流程是否已结束（0：未结束，1：已结束）
     */
    public Boolean getIsFinished() {
        return isFinished;
    }

    /**
     * 设置流程是否已结束（0：未结束，1：已结束）
     */
    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    /**
     * 获取上一节点key
     */
    public String getLastNodeKey() {
        return lastNodeKey;
    }

    /**
     * 设置上一节点key
     */
    public void setLastNodeKey(String lastNodeKey) {
        this.lastNodeKey = lastNodeKey == null ? null : lastNodeKey.trim();
    }

    /**
     * 获取上一流程节点名称
     */
    public String getLastNodeName() {
        return lastNodeName;
    }

    /**
     * 设置上一流程节点名称
     */
    public void setLastNodeName(String lastNodeName) {
        this.lastNodeName = lastNodeName == null ? null : lastNodeName.trim();
    }

    /**
     * 获取上一节点索引
     */
    public Integer getLastNodeIndex() {
        return lastNodeIndex;
    }

    /**
     * 设置上一节点索引
     */
    public void setLastNodeIndex(Integer lastNodeIndex) {
        this.lastNodeIndex = lastNodeIndex;
    }

    /**
     * 获取流程节点的key
     */
    public String getNodeKey() {
        return nodeKey;
    }

    /**
     * 设置流程节点的key
     */
    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey == null ? null : nodeKey.trim();
    }

    /**
     * 获取流程节点名称
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * 设置流程节点名称
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    /**
     * 获取节点索引，表示此节点是流程中的第几个节点，这个值在流程确定后不会改变
     */
    public Integer getNodeIndex() {
        return nodeIndex;
    }

    /**
     * 设置节点索引，表示此节点是流程中的第几个节点，这个值在流程确定后不会改变
     */
    public void setNodeIndex(Integer nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    /**
     * 获取流程索引，一个业务对象走流程后，每一次操作，此值顺序递增
     */
    public Integer getFlowIndex() {
        return flowIndex;
    }

    /**
     * 设置流程索引，一个业务对象走流程后，每一次操作，此值顺序递增
     */
    public void setFlowIndex(Integer flowIndex) {
        this.flowIndex = flowIndex;
    }

    /**
     * 获取标识流程的版本
     */
    public String getFlowVersion() {
        return flowVersion;
    }

    /**
     * 设置标识流程的版本
     */
    public void setFlowVersion(String flowVersion) {
        this.flowVersion = flowVersion == null ? null : flowVersion.trim();
    }

    /**
     * 获取流程类型
     */
    public String getFlowType() {
        return flowType;
    }

    /**
     * 设置流程类型
     */
    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    /**
     * 获取操作角色Key
     */
    public String getOperationRoleKey() {
        return operationRoleKey;
    }

    /**
     * 设置操作角色Key
     */
    public void setOperationRoleKey(String operationRoleKey) {
        this.operationRoleKey = operationRoleKey == null ? null : operationRoleKey.trim();
    }

    /**
     * 获取角色名称
     */
    public String getOperationRoleName() {
        return operationRoleName;
    }

    /**
     * 设置角色名称
     */
    public void setOperationRoleName(String operationRoleName) {
        this.operationRoleName = operationRoleName == null ? null : operationRoleName.trim();
    }

    /**
     * 获取操作人外键
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作人外键
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取操作人姓名
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作人姓名
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 获取审批结果，-1：待办；0：不同意；1：同意；2：补件。【2主要是经营管理部审批结果选项】;3：关闭项目（贷款项目在区域经理时，可以关闭此贷款）
     */
    public Integer getApprovalResult() {
        return approvalResult;
    }

    /**
     * 设置审批结果，-1：待办；0：不同意；1：同意；2：补件。【2主要是经营管理部审批结果选项】;3：关闭项目（贷款项目在区域经理时，可以关闭此贷款）
     */
    public void setApprovalResult(Integer approvalResult) {
        this.approvalResult = approvalResult;
    }

    /**
     * 获取创建时间，即：流转到当前节点的时间
     */
    public Date getCreateDateTime() {
        return createDateTime;
    }

    /**
     * 设置创建时间，即：流转到当前节点的时间
     */
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    /**
     * 获取审批时间
     */
    public Date getApprovalDateTime() {
        return approvalDateTime;
    }

    /**
     * 设置审批时间
     */
    public void setApprovalDateTime(Date approvalDateTime) {
        this.approvalDateTime = approvalDateTime;
    }

    /**
     * 获取提交到下一节点的时间
     */
    public Date getSubmittedDateTime() {
        return submittedDateTime;
    }

    /**
     * 设置提交到下一节点的时间
     */
    public void setSubmittedDateTime(Date submittedDateTime) {
        this.submittedDateTime = submittedDateTime;
    }

    /**
     * 获取审批意见
     */
    public String getApprovalNote() {
        return approvalNote;
    }

    /**
     * 设置审批意见
     */
    public void setApprovalNote(String approvalNote) {
        this.approvalNote = approvalNote == null ? null : approvalNote.trim();
    }

    /**
     * 获取不同意原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    public String getDeclineReasonKey() {
        return declineReasonKey;
    }

    /**
     * 设置不同意原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    public void setDeclineReasonKey(String declineReasonKey) {
        this.declineReasonKey = declineReasonKey == null ? null : declineReasonKey.trim();
    }

    /**
     * 获取补件原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    public String getRfeReasonKey() {
        return rfeReasonKey;
    }

    /**
     * 设置补件原因key，这个数据来源于静态配置文件。经营管理部节点审批时使用
     */
    public void setRfeReasonKey(String rfeReasonKey) {
        this.rfeReasonKey = rfeReasonKey == null ? null : rfeReasonKey.trim();
    }

    /**
     * 获取更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取二证业务(0:否，1:是)
     */
    public Integer getIsTwoCard() {
        return isTwoCard;
    }

    /**
     * 设置二证业务(0:否，1:是)
     */
    public void setIsTwoCard(Integer isTwoCard) {
        this.isTwoCard = isTwoCard;
    }

    @Override
    public String toString() {
        return "BusinessObjectProcessInfo{" +
                "id=" + id +
                ", businessObjectId=" + businessObjectId +
                ", businessType='" + businessType + '\'' +
                ", borrowerId=" + borrowerId +
                ", borrowerName='" + borrowerName + '\'' +
                ", launchUserId=" + launchUserId +
                ", launchUserName='" + launchUserName + '\'' +
                ", launchOrganizationId=" + launchOrganizationId +
                ", launchOrganizationName='" + launchOrganizationName + '\'' +
                ", businessGroupId=" + businessGroupId +
                ", businessGroupName='" + businessGroupName + '\'' +
                ", businessNum='" + businessNum + '\'' +
                ", isAdvance=" + isAdvance +
                ", isSecondHandCar=" + isSecondHandCar +
                ", isSubmitted=" + isSubmitted +
                ", isRead=" + isRead +
                ", isFinished=" + isFinished +
                ", lastNodeKey='" + lastNodeKey + '\'' +
                ", lastNodeName='" + lastNodeName + '\'' +
                ", lastNodeIndex=" + lastNodeIndex +
                ", nodeKey='" + nodeKey + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", nodeIndex=" + nodeIndex +
                ", flowIndex=" + flowIndex +
                ", flowVersion='" + flowVersion + '\'' +
                ", flowType='" + flowType + '\'' +
                ", operationRoleKey='" + operationRoleKey + '\'' +
                ", operationRoleName='" + operationRoleName + '\'' +
                ", operatorId=" + operatorId +
                ", operatorName='" + operatorName + '\'' +
                ", approvalResult=" + approvalResult +
                ", createDateTime=" + createDateTime +
                ", approvalDateTime=" + approvalDateTime +
                ", submittedDateTime=" + submittedDateTime +
                ", approvalNote='" + approvalNote + '\'' +
                ", declineReasonKey='" + declineReasonKey + '\'' +
                ", rfeReasonKey='" + rfeReasonKey + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}