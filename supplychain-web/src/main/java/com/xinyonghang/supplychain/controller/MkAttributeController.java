package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkAttributeDto;
import com.xinyonghang.supplychain.model.MkAttribute;
import com.xinyonghang.supplychain.service.MkAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/18.
 */
@RestController
@RequestMapping("/mk/attribute")
public class MkAttributeController {

    @Autowired
    DataSource dataSource;

    @Resource
    private MkAttributeService mkAttributeService;

    @RequestMapping("/toAttributeList")
    public ModelAndView toAttribute() {
        return new ModelAndView("sub/product/attributeList");
    }

    @RequestMapping("/toAddAttribute")
    public ModelAndView toAddAttribute() {
        return new ModelAndView("sub/product/addAttribute");
    }

    @RequestMapping("/toEditAttribute")
    public ModelAndView toEditAttribute() {
        return new ModelAndView("sub/product/editAttribute");
    }

    @PostMapping("/add")
    public Result add(MkAttribute mkAttribute) {
        mkAttributeService.save(mkAttribute);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkAttributeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkAttribute mkAttribute) {
        mkAttributeService.update(mkAttribute);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkAttribute mkAttribute = mkAttributeService.findById(id);
        return ResultGenerator.genSuccessResult(mkAttribute);
    }

    @PostMapping("/list")
    public Result list(@Validated MkAttributeDto mkAttributeDto) throws Exception {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        request.getSession().setAttribute("test","test");
        PageInfo pageInfo = mkAttributeService.findList(mkAttributeDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/getAttributeList")
    public Result getAttributeList(@RequestParam Long categoryId) throws Exception {
        List<MkAttribute> list = mkAttributeService.getAttributeListByCategoryId(categoryId);
        return ResultGenerator.genSuccessResult(list);
    }

}
