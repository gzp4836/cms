package com.yofang.cms.service.sysmanage;

import org.junit.Test;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.yofang.cms.enums.RoleType;
import com.yofang.cms.model.Role;
import com.yofang.cms.service.RoleService;
import com.yofang.cms.service.impl.RoleServiceImpl;


public class RoleServiceImplTest {
	private static RoleService roleService;
	
	static {
		//加载ioc容器
		Ioc ioc = new NutIoc(new ComboIocLoader(
							 new AnnotationIocLoader("com.yofang.cms.dao.impl", "com.yofang.cms.service.impl", "com.yofang.cms.web.module")
							 ,new JsonLoader("aop/transaction.js","ioc/nutzdao.js")));
		//从容器中取出测试对象
		roleService= (RoleServiceImpl) ioc.get(null, "roleService");
	}
	
	/**
	 * 利用枚举，初始化角色表
	 *
	 */
	@Test
	public void testInit(){
		Role role = null;
		for (int i = 0; i < RoleType.values().length; i++) {
			RoleType[] values = RoleType.values();
			role = new Role();
			role.setName(values[i].getName());
			roleService.saveEntity(role);
		}
	}
}
