package com.esther.code.service.impl;

import com.esther.code.api.IDictService;
import com.esther.code.dao.DictMapper;
import com.esther.code.model.Dict;
import com.esther.code.model.DictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author esther
 * 2018-04-18 15:54
 * $DESCRIPTION}
 */
@Service("dictService")
public class DictServiceImpl implements IDictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public int countByExample(DictExample example) {
        return dictMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(DictExample example) {
        return dictMapper.deleteByExample(example);
    }

    @Override
    public int insert(Dict record) {
        return dictMapper.insert(record);
    }

    @Override
    public int insertSelective(Dict record) {
        return dictMapper.insertSelective(record);
    }

    @Override
    public List<Dict> selectByExample(DictExample example) {
        return dictMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(Dict record, DictExample example) {
        return dictMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Dict record, DictExample example) {
        return dictMapper.updateByExample(record,example);
    }
}
