package io.vubh.service;


import io.vubh.dao.SysMenuMapper;
import io.vubh.entity.SysMenuEntity;
import io.vubh.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * 菜单 业务层处理
 * 
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService
{
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenuEntity> getSysMenuList() {

        List<SysMenuEntity>  menus = sysMenuMapper.getSysMenuList();

        //组装树的形式
        List<SysMenuEntity>  menur = TreeUtils.getChildPerms(menus, 0);
        return menur;
    }
}
