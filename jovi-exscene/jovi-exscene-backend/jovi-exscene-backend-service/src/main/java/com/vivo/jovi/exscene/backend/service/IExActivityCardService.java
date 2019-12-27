package com.vivo.jovi.exscene.backend.service;

import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.scene.common.constant.activitycard.ActivityCardStatusEnum;
import com.vivo.jovi.scene.common.constant.activitycard.AuditStatusEnum;
import com.vivo.jovi.scene.common.model.bo.ActivityCardBO;
import com.vivo.jovi.scene.common.model.vo.ActivityCardDetailVO;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @author zhongjiajun
 * @date 2019/12/4 16:57
 * @describe 活动卡片管理服务
 */
public interface IExActivityCardService {
    /**
     * 新增活动卡片
     *
     * @param activityCard 活动卡片对象
     * @param ssoUser      登录信息
     */
    void add(ActivityCardBO activityCard, SSOUser ssoUser);

    /**
     * 修改活动卡片信息
     *
     * @param activityCard 活动卡片对象
     * @param ssoUser      登录信息
     */
    void modify(ActivityCardBO activityCard, SSOUser ssoUser);

    /**
     * 修改活动卡片状态
     *
     * @param id      活动卡片id
     * @param status  变更后的状态
     * @param reason  状态变更原因
     * @param ssoUser 登录信息
     */
    void updateStatus(Long id, ActivityCardStatusEnum status, String reason, SSOUser ssoUser);

    /**
     * 运营人员审核
     *
     * @param id           活动卡片id
     * @param AuditStatus  审核结果
     * @param rejectReason 审核不通过原因
     * @param ssoUser      登录信息
     */
    void operationAudit(Long id, AuditStatusEnum AuditStatus, String rejectReason, SSOUser ssoUser);

    /**
     * 测试人员审核
     *
     * @param id           活动卡片id
     * @param AuditStatus  审核结果
     * @param rejectReason 审核不通过原因
     * @param ssoUser      登录信息
     */
    void testerAudit(Long id, AuditStatusEnum AuditStatus, String rejectReason, SSOUser ssoUser);

    /**
     * 删除活动卡片
     *
     * @param id 活动卡片id
     */
    void delete(Long id);

    /**
     * 分页查询活动卡片
     *
     * @param name       活动卡片名称
     * @param status     状态
     * @param orderField 排序字段
     * @param pageable   分页信息
     */
    Map getPage(String name, Integer status, String orderField, Pageable pageable);

    /**
     * 查询活动卡片详情
     *
     * @param id 活动卡片id
     */
    ActivityCardDetailVO getDetail(Long id);
}
