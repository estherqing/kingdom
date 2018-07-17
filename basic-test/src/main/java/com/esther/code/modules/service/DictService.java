package com.esther.code.modules.service;


import com.esther.code.modules.mapper.DictMapper;
import com.esther.code.modules.vo.DictVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典Service
 *
 * @author esther
 * @version 2016-09-19
 */
@Service
public class DictService {
    @Autowired
    private DictMapper dictMapper;

    /**
     * 获取所有的字典列表
     * @return
     */
    public List<DictVo> getAllDictList(){
        return dictMapper.getAllDictList();
    }

    /**
     * 根据字典类型获取列表
     * @param dictType
     * @return
     */
    public List<DictVo> getDictListByDictType(String dictType){
        return dictMapper.getDictListByDictType(dictType);
    }
}
