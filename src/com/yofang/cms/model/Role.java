package com.yofang.cms.model;


import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

@Table("SYS_ROLE")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 743954709611070123L;
	@Id
	private int id;
	/** 角色名称*/
	private String name;
	/** 角色描述*/
	private String description;
	
	@Many(target=User.class, field="roleId")
	private List<User> users;	
	
	@ManyMany(target=Privilege.class, relation="SYS_ROLE_PRIVILEGE", from="roleId", to="privilegeId")
	private List<Privilege> privileges;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
}
