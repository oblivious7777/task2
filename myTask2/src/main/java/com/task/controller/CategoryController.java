package com.task.controller;



import org.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.task.model.Category;
import com.task.service.CategoryService;
import com.task.units.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping(value = "",method = RequestMethod.GET)
class CategoryController {
    @Autowired
    CategoryService categoryService;

    //分页查询
    @RequestMapping(value ="/list", method = RequestMethod.GET)
    public String getCategory(Page page , Model model){
        PageHelper.offsetPage(page.getStart(),5);//getStart()=0;间隔为5
        List<Category> cs= categoryService.list();//获得表
        model.addAttribute("list",cs);
        return "list";
    }
    //添加
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addCategory(Category category){
        categoryService.add(category);
        return "add";//返回的是jsp名称
    }
    //删除
    @RequestMapping(value="/add" ,method = RequestMethod.DELETE)
    public String delCategory(Category category) {
        categoryService.del(category);
        return "del";
    }

    //改名字
    @RequestMapping(value="/upd",method = RequestMethod.POST)
    public String updCategory(Category category){
        categoryService.upd(category);
        return "upd";
    }
    // 根据ID查询一条数据,用get方法
    @RequestMapping(value = "selI/{id}", method = RequestMethod.GET)
    public String queryOne(@PathVariable(value = "id") Integer id,Model model) {
        List<Category> cs= categoryService.selId(id);//获得表
        model.addAttribute("getName",cs);
        return "selI";
    }
    /*
    //分页查询
    @RequestMapping(value ="listCategory", method = RequestMethod.GET)
    public String getCategory(Page page , Model model){
        PageHelper.offsetPage(page.getStart(),5);//getStart()=0;间隔为5
        List<Category> cs= categoryService.list();//获得表
        int total = (int) new PageInfo<Category>(cs).getTotal();//获得总页数，但是为毛要经过这一步
        page.caculateLast(total);//算最后一页
        model.addAttribute("listCategory",cs);
        return "listCategory";
    }
    @RequestMapping(value ="addCategory", method = RequestMethod.POST)
    public ModelAndView addCategory (Category category){
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/addCategory");
        return mav;
    }



    @RequestMapping(value ="/id/{id}", method = RequestMethod.GET)
    public JSONArray json(){
        JSONArray json = new JSONArray();
        List<Category> cs=categoryService.list();
        for (Category c : cs) {
            JSONObject js = new JSONObject();
            js.put("name",c.getName());
            js.put("id",c.getId());
            json.put(js);
        }
        return json;
    }

*/

}
