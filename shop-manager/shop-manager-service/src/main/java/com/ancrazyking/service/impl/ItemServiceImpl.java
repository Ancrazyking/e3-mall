package com.ancrazyking.service.impl;

import com.ancrazyking.common.pojo.EasyUIDataGridResult;
import com.ancrazyking.mapper.TbItemMapper;
import com.ancrazyking.pojo.TbItem;
import com.ancrazyking.pojo.TbItemExample;
import com.ancrazyking.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author Ancrazyking
 * @date 2018/5/19 14:52
 **/
@Service(value = "itemServiceImpl")
public class ItemServiceImpl implements ItemService
{
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(long itemId)
    {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }


    @Override
    public EasyUIDataGridResult getItemList(int page, int rows)
    {
        //设置分页信息
        PageHelper.startPage(page,rows);
        //执行查询
        TbItemExample example=new TbItemExample();
        List<TbItem> list=tbItemMapper.selectByExample(example);
        //创建一个返回值对象
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setRows(list);
        //取分页结果
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        //取总记录数
        long total=pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }
}
