package com.ancrazyking.service.impl;

import com.ancrazyking.common.pojo.EasyUITreeNode;
import com.ancrazyking.mapper.TbItemCatMapper;
import com.ancrazyking.mapper.TbItemMapper;
import com.ancrazyking.pojo.TbItemCat;
import com.ancrazyking.pojo.TbItemCatExample;
import com.ancrazyking.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ancrazyking.pojo.TbItemCatExample.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/5/22 10:22
 **/
@Service(value = "itemCatServiceImpl")
public class ItemCatServiceImpl implements ItemCatService
{
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatlist(long parentId)
    {
        //根据parentId查询子节点列表
        //创建查询条件
        TbItemCatExample example=new TbItemCatExample();
        Criteria criteria=example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list=tbItemCatMapper.selectByExample(example);
        //创建返回结果
        List<EasyUITreeNode> resultlist=new ArrayList<>();
        for(TbItemCat tbItemCat:list){
            EasyUITreeNode node=new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultlist.add(node);
        }
        return resultlist;
    }
}
