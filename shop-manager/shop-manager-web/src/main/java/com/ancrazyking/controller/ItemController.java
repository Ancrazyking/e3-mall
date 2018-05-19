package com.ancrazyking.controller;

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
@RequestMapping("/mall")
public class ItemController
{

    @Autowired
    private ItemService itemService;


    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem tbItem=itemService.getItemById(itemId);
        return tbItem;
    }


}
