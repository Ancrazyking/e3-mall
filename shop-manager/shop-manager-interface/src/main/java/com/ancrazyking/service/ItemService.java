package com.ancrazyking.service;

import com.ancrazyking.common.pojo.EasyUIDataGridResult;
import com.ancrazyking.pojo.TbItem;

/**
 * @author Ancrazyking
 * @date 2018/5/19 14:49
 **/
public interface ItemService
{
    TbItem getItemById(long itemId);

    //分页显示
    EasyUIDataGridResult getItemList(int page,int rows);
}
