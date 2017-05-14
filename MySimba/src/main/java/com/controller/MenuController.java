package com.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.util.JsonUtil;
import com.model.Menu;
import com.service.IMenuService;
import com.session.SessionUtil;



@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private IMenuService menuService;
	
	private final Log logger = LogFactory.getLog(MenuController.class);
	/**
	 * ��ȡ���˵�����
	 * @param node  ext��ʹ��������������ݸ��ڵ�id
	 * @param id  easyui��ʹ��������������ݸ��ڵ�id
	 * @param dealMenu �Ƿ�Բ˵����ݽ��д���(��url������Ȩ�޹���) Ĭ��Ϊtrue
	 * @param showRoot �Ƿ���ʾ���ڵ�
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("listChildrenMenu")
	public String listChildrenMenu(Integer node, Integer id, Boolean dealMenu, Boolean showRoot, ModelMap model, HttpServletRequest request){
		int parentID = -1;//���ĸ��ڵ�
		if(node!=null){
			parentID = node;
		}else if(id!=null){
			parentID = id;
		}else if(showRoot!=null && showRoot){
		}
		if(dealMenu==null){
			dealMenu = true;
		}
		List<Menu> list = menuService.listChildren(parentID);
		if(dealMenu){
			//Ĭ�϶Բ˵�����Ȩ�޹���
			dealMenus(request,list);
		}
		model.put("message", JsonUtil.toJson(list));
		System.out.println(JsonUtil.toJson(list));
		return "message";
	}
	public void dealMenus(HttpServletRequest request, List<Menu> list) {
		String contextPath = request.getContextPath();
		Iterator<Menu> iterator = list.iterator();
		while(iterator.hasNext()){
			Menu menu = iterator.next();
			boolean hasPermission = hasPermisson(menu,request);
			if(hasPermission){
				menu.setUrl(deal(menu.getUrl(),contextPath));
			}else{
				iterator.remove();
			}
		}
	}
	/**
	 * ����url
	 * @param url
	 * @param contextPath
	 * @return
	 */
	private String deal(String url, String contextPath) {

		if(StringUtils.isBlank(url)){
			return "";
		}
		if(url.startsWith("htpp") || url.startsWith("https")){
			return url;
		}
		return contextPath+url;
	}
	private boolean hasPermisson(Menu menu, HttpServletRequest request) {
		boolean hasPermission = SessionUtil.hasPermission(request.getSession(),menu.getUrl());
		if(hasPermission){
			return true;
		}
		return false;
	}
}
