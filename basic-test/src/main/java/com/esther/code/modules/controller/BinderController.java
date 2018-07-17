package com.esther.code.modules.controller;

import com.esther.code.modules.entity.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/binder")
public class BinderController {

	@RequestMapping("test.do")
	public ModelAndView test(boolean b, ModelAndView view) {
		view.setViewName("test");
		if (b) {
			view.addObject("attr", "b is true");
		} else {
			view.addObject("attr", "b is false");
		}
		return view;
	}

	@RequestMapping(value="testClass.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ModelAndView test(TestModel model, ModelAndView view) {
		view.setViewName("test");
		view.addObject("attr", model.toString());
		return view;
	}
	


}
