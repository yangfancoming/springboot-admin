package io.vubh.controller;

import io.vubh.entity.SysMenuEntity;
import io.vubh.service.SysMenuServiceImpl;
import io.vubh.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * 系统菜单
 * 
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController  {
	@Autowired
	private SysMenuServiceImpl sysMenuService;

	/**
	 * 导航菜单
	 */
	@RequestMapping("/nav")
	public Result nav() {

		List<SysMenuEntity> menuList = sysMenuService.getSysMenuList();
		return Result.success().put("menuList", menuList);
	}
}
