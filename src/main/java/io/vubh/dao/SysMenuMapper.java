package io.vubh.dao;

import io.vubh.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单表 数据层
 * 
 */

@Mapper
public interface SysMenuMapper
{

    List<SysMenuEntity> getSysMenuList();

}
