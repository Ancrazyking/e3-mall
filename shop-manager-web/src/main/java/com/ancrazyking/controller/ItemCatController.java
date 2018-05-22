package com.ancrazyking.controller;

import com.ancrazyking.common.pojo.EasyUITreeNode;
import com.ancrazyking.pojo.TbItem;
import com.ancrazyking.pojo.TbItemCat;
import com.ancrazyking.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



/**
 * @author Ancrazyking
 * @date 2018/5/22 15:40
 **/
@Controller
public class ItemCatController
{
    @Autowired
    private ItemCatService itemCatService;

/*

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(
            @RequestParam(name="id", defaultValue="0")Long parentId) {
        //调用服务查询节点列表
        List<EasyUITreeNode> list = itemCatService.getItemCatlist(parentId);
        return list;
    }

*/
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatlist(
      @RequestParam(name="id",defaultValue = "0") Long parentId
    ){
        List<EasyUITreeNode> list=itemCatService.getItemCatlist(parentId);
        return list;
    }
}
