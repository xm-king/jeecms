package com.jeecms.cms.entity.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.jeecms.cms.entity.main.base.BaseCmsGroup;
import com.jeecms.common.hibernate3.PriorityInterface;

public class CmsGroup extends BaseCmsGroup implements PriorityInterface {
	private static final long serialVersionUID = 1L;

	/**
	 * 从集合中提取ID数组
	 * 
	 * @param groups
	 * @return
	 */
	public static Integer[] fetchIds(Collection<CmsGroup> groups) {
		Integer[] ids = new Integer[groups.size()];
		int i = 0;
		for (CmsGroup g : groups) {
			ids[i++] = g.getId();
		}
		return ids;
	}

	/**
	 * 根据列表排序
	 * 
	 * @param source
	 *            元素集合
	 * @param target
	 *            有顺序列表
	 * @return 一个新的、按目标排序的列表
	 */
	public static List<CmsGroup> sortByList(Set<CmsGroup> source,
			List<CmsGroup> target) {
		List<CmsGroup> list = new ArrayList<CmsGroup>(source.size());
		for (CmsGroup g : target) {
			if (source.contains(g)) {
				list.add(g);
			}
		}
		return list;
	}

	/**
	 * 是否允许上传后缀
	 * 
	 * @param ext
	 * @return
	 */
	public boolean isAllowSuffix(String ext) {
		String suffix = getAllowSuffix();
		if (StringUtils.isBlank(suffix)) {
			return true;
		}
		String[] attr = StringUtils.split(suffix, ",");
		for (int i = 0, len = attr.length; i < len; i++) {
			if (attr[i].equals(ext)) {
				return true;
			}
		}
		return false;
	}

	public void init() {
		if (getRegDef() == null) {
			setRegDef(false);
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsGroup () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsGroup (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsGroup (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.Integer priority,
		java.lang.Integer allowPerDay,
		java.lang.Integer allowMaxFile,
		java.lang.Boolean needCaptcha,
		java.lang.Boolean needCheck,
		java.lang.Boolean regDef) {

		super (
			id,
			name,
			priority,
			allowPerDay,
			allowMaxFile,
			needCaptcha,
			needCheck,
			regDef);
	}

	/* [CONSTRUCTOR MARKER END] */

}