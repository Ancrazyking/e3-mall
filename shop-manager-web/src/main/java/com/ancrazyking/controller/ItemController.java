package com.ancrazyking.controller;

import com.ancrazyking.common.pojo.EasyUIDataGridResult;
import com.ancrazyking.common.util.E3Result;
import com.ancrazyking.pojo.TbItem;
import com.ancrazyking.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ancrazyking
 * @date 2018/5/19 14:55
 **/
@Controller
@RequestMapping("/item")
public class ItemController
{

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem tbItem=itemService.getItemById(itemId);
        return tbItem;
    }


    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
        //调用服务查询商品列表
        EasyUIDataGridResult result=itemService.getItemList(page,rows);
        return result;
    }


    @RequestMapping("/save")
    @ResponseBody
    public E3Result saveItem(TbItem item,String desc){
        E3Result result=itemService.addItem(item,desc);
        return result;
    }


}
