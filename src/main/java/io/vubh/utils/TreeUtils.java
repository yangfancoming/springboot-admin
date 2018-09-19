package io.vubh.utils;


import io.vubh.entity.SysMenuEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数据处理
 * 
 */
public class TreeUtils
{

    /**
     * 根据父节点的ID获取所有子节点
     * 
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public static List<SysMenuEntity> getChildPerms(List<SysMenuEntity> list, int parentId)
    {
        List<SysMenuEntity> returnList = new ArrayList<SysMenuEntity>();
        for (Iterator<SysMenuEntity> iterator = list.iterator(); iterator.hasNext();)
        {
            SysMenuEntity t = (SysMenuEntity) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId)
            {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     * 
     * @param list
     * @param t
     */
    private static void recursionFn(List<SysMenuEntity> list, SysMenuEntity t)
    {
        // 得到子节点列表
        List<SysMenuEntity> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenuEntity tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SysMenuEntity> it = childList.iterator();
                while (it.hasNext())
                {
                    SysMenuEntity n = (SysMenuEntity) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<SysMenuEntity> getChildList(List<SysMenuEntity> list, SysMenuEntity t)
    {

        List<SysMenuEntity> tlist = new ArrayList<SysMenuEntity>();
        Iterator<SysMenuEntity> it = list.iterator();
        while (it.hasNext())
        {
            SysMenuEntity n = (SysMenuEntity) it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    List<SysMenuEntity> returnList = new ArrayList<SysMenuEntity>();

    /**
     * 根据父节点的ID获取所有子节点
     * 
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @param prefix 子节点前缀
     */
    public List<SysMenuEntity> getChildPerms(List<SysMenuEntity> list, int typeId, String prefix)
    {
        if (list == null)
        {
            return null;
        }
        for (Iterator<SysMenuEntity> iterator = list.iterator(); iterator.hasNext();)
        {
            SysMenuEntity node = (SysMenuEntity) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId() == typeId)
            {
                recursionFn(list, node, prefix);
            }
            // 二、遍历所有的父节点下的所有子节点
            /*
             * if (node.getParentId()==0) { recursionFn(list, node); }
             */
        }
        return returnList;
    }

    private void recursionFn(List<SysMenuEntity> list, SysMenuEntity node, String p)
    {
        // 得到子节点列表
        List<SysMenuEntity> childList = getChildList(list, node);
        if (hasChild(list, node))
        {
            // 判断是否有子节点
            returnList.add(node);
            Iterator<SysMenuEntity> it = childList.iterator();
            while (it.hasNext())
            {
                SysMenuEntity n = (SysMenuEntity) it.next();
                n.setMenuName(p + n.getMenuName());
                recursionFn(list, n, p + p);
            }
        }
        else
        {
            returnList.add(node);
        }
    }

    /**
     * 判断是否有子节点
     */
    private static boolean hasChild(List<SysMenuEntity> list, SysMenuEntity t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
