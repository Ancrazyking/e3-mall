package com.ancrazyking.service.impl;

import com.ancrazyking.common.pojo.EasyUIDataGridResult;
import com.ancrazyking.common.util.E3Result;
import com.ancrazyking.common.util.IDUtils;
import com.ancrazyking.mapper.TbItemDescMapper;
import com.ancrazyking.mapper.TbItemMapper;
import com.ancrazyking.pojo.TbItem;
import com.ancrazyking.pojo.TbItemDesc;
import com.ancrazyking.pojo.TbItemDescExample;
import com.ancrazyking.pojo.TbItemExample;
import com.ancrazyking.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

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

    //添加商品
    @Override
    public E3Result addItem(TbItem item, String desc)
    {
        //1.随机生成商品id
        long itemId= IDUtils.genItemId();
        item.setId(itemId);
        //设置商品状态,1-正常,2-下架,3-删除
        item.setStatus((byte)1);
        Date date=new Date();
        item.setCreated(date);
        item.setUpdated(date);
        //3.向商品表插入数据
        tbItemMapper.insert(item);

        TbItemDesc tbItemDesc=new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDesc.setItemDesc(desc);
        tbItemDescMapper.insert(tbItemDesc);

        //返回E3Result.ok();
        return E3Result.ok();
    }


    @Override
    public E3Result updateItem(TbItem item, String desc)
    {
        TbItemExample example=new TbItemExample();
        tbItemMapper.updateByExample(item,example);


        return E3Result.ok();
    }
}
