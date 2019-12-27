package com.vivo.jovi.exscene.backend.service;

import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.exscene.backend.service.model.PublishStrategyDetail;
import com.vivo.jovi.exscene.backend.service.model.form.PublishForm;
import com.vivo.jovi.exscene.backend.service.model.form.PublishStrategyForm;
import com.vivo.jovi.exscene.backend.service.model.vo.Approval;
import com.vivo.jovi.exscene.backend.service.model.vo.PublishVO;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IPublishService {

    List<PublishVO> findPublish(PublishForm publishForm, Pageable pageable);

    long countPublish(PublishForm publishForm);

    CommonVO updateStatus(SSOUser ssoUser, PublishForm publishForm);

    Approval approvalStatus(PublishForm publishForm);

    CommonVO approval(SSOUser ssoUser, Approval approval);

    int insertSelective(ExPublishEntity exPublishEntity);

    int updateSelective(ExPublishEntity exPublishEntity);

    int updateStrategy(Long id, String strategyId);

    List<PublishVO> getPublishExamine();

    Map<String, Object> uploadTranslateFile(MultipartFile file);

    PublishStrategyDetail getPublishDetail(String strategyId, String bizId);

    CommonVO publish(SSOUser ssoUser, PublishStrategyForm publishStrategyForm);
}
