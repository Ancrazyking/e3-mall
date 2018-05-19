package com.ancrazyking.service.impl;

import com.ancrazyking.mapper.TbItemMapper;
import com.ancrazyking.pojo.TbItem;
import com.ancrazyking.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ancrazyking
 * @date 2018/5/19 14:52
 **/
@Service
public class ItemServiceImap implements ItemService
{
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(long itemId)
    {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }
}
