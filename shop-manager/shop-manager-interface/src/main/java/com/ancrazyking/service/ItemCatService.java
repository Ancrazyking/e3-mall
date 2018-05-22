package com.ancrazyking.service;

import com.ancrazyking.common.pojo.EasyUITreeNode;
import java.util.List;
/**
 * @author Ancrazyking
 * @date 2018/5/22 10:20
 **/
public interface ItemCatService
{


    List<EasyUITreeNode> getItemCatlist(long parentId);
}
