package com.esther.code.modules.mapper;


import com.esther.code.common.framework.dao.BaseDao;
import com.esther.code.modules.entity.Dict;
import com.esther.code.modules.vo.DictVo;

import java.util.List;

public interface DictMapper extends BaseDao {

    int insert(Dict dict);

    Dict get(Integer id);


    /**
     * 获取所有的字典列表
     *
     * @return
     */
    List<DictVo> getAllDictList();

    /**
     * 根据字典类型获取列表
     *
     * @param dictType
     * @return
     */
    List<DictVo> getDictListByDictType(String dictType);
}