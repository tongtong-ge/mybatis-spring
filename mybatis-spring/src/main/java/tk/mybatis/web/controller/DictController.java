package tk.mybatis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tk.mybatis.web.model.SysDict;
import tk.mybatis.web.service.DictService;

@Controller
@RequestMapping("/dicts")
public class DictController {
	@Autowired
	private DictService dictService;
	
	/**
	 * 显示字典数据列表
	 * 
	 * @param sysDict
	 * @param offset
	 * @param limit
	 * @return
	 */
	@RequestMapping
	public ModelAndView dicts(SysDict sysDict, Integer offset, Integer limit) {
		ModelAndView mv = new ModelAndView("dicts");
		List<SysDict> dicts = dictService.findBySysDict(sysDict, offset, limit);
		mv.addObject("dicts", dicts);
		return mv;
	}
	
	/**
	 * 新增或修改字典信息页面，使用get跳转到页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(Long id) {
		ModelAndView mv = new ModelAndView("dict_add");
		SysDict sysDict;
		if(id == null) {
			sysDict = new SysDict();
		} else {
			sysDict = dictService.findById(id);
		}
		
		mv.addObject("model", sysDict);
		return mv;
	}
	
	/**
	 * 新增或修改字典信息时，通过表单post提交数据
	 * 
	 * @param sysDict
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView save(SysDict sysDict) {
		ModelAndView mv = new ModelAndView("dict_add");
		try {
			dictService.saveOrUpdate(sysDict);
			mv.setViewName("redirect:/dicts");
		} catch (Exception e) {
			mv.setViewName("dict_add");
			mv.addObject("msg", e.getMessage());
			mv.addObject("model", sysDict);
		}
		
		return mv;
	}
	
	/**
	 * 通过id删除字典信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap delete(@RequestParam Long id) {
		ModelMap modelMap = new ModelMap();
		try {
			boolean success = dictService.deleteById(id);
			modelMap.put("success", success);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("msg", e.getMessage());
		}
		
		return modelMap;
	}
	
}
