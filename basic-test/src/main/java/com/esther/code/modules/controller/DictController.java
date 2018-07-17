package com.esther.code.modules.controller;



import com.esther.code.common.framework.controller.BaseController;
import com.esther.code.common.framework.global.ReturnCode;
import com.esther.code.common.framework.result.GeneralResult;
import com.esther.code.modules.service.DictService;
import com.esther.code.modules.vo.DictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 字典Controller
 *
 * @author esther
 * @version 2016-09-19
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    /**
     * 获取所有的字典列表
     *
     * @param request
     */
    @RequestMapping("/list/all")
    @ResponseBody
    public GeneralResult<List<DictVo>> getAllDictList(HttpServletRequest request) {
        GeneralResult<List<DictVo>> result = new GeneralResult<List<DictVo>>();
        try {
            List<DictVo> dictVoList = dictService.getAllDictList();
            if (dictVoList != null && dictVoList.size() > 0) {
                result.setCode(ReturnCode.NORMAL.getCode());
                result.setMsg(ReturnCode.NORMAL.getMsg());
                result.setData(dictVoList);
            } else {
                result.setCode(ReturnCode.ACTION_ERROR.getCode());
                result.setMsg(ReturnCode.ACTION_ERROR.getMsg());
                logger.error("获取所有的字典列表为空");
            }
        } catch (Exception e) {
            result.setCode(ReturnCode.SYSTEM_ERROR.getCode());
            result.setMsg(ReturnCode.SYSTEM_ERROR.getMsg());
            e.printStackTrace();
            logger.error("获取所有的字典列表出现异常", e);
        }
        return result;      
    }

    /**
     * 根据字典类型获取列表
     *
     * @param dictType
     */
    @RequestMapping(value="/list/some", method = RequestMethod.GET)
    @ResponseBody
    public GeneralResult<List<DictVo>> getDictListByDictType(String dictType) {
        GeneralResult<List<DictVo>> result = new GeneralResult<List<DictVo>>();
        try {
            List<DictVo> dictVoList = dictService.getDictListByDictType(dictType);
            if (dictVoList != null && dictVoList.size() > 0) {
                result.setCode(ReturnCode.NORMAL.getCode());
                result.setMsg(ReturnCode.NORMAL.getMsg());
                result.setData(dictVoList);
            } else {
                result.setCode(ReturnCode.ACTION_ERROR.getCode());
                result.setMsg(ReturnCode.ACTION_ERROR.getMsg());
                logger.error("根据字典类型获取列表为空");
            }
        } catch (Exception e) {
            result.setCode(ReturnCode.SYSTEM_ERROR.getCode());
            result.setMsg(ReturnCode.SYSTEM_ERROR.getMsg());
            e.printStackTrace();
            logger.error("根据字典类型获取列表出现异常", e);
        }
        return result;
    }
}

