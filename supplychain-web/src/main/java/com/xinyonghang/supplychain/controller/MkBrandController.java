package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkBrandDto;
import com.xinyonghang.supplychain.model.MkBrand;
import com.xinyonghang.supplychain.service.MkBrandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/brand")
public class MkBrandController {
    @Resource
    private MkBrandService mkBrandService;

    @RequestMapping("/toBrandList")
    public ModelAndView toBrandList() {
        return new ModelAndView("sub/brand/brandList");
    }

    @RequestMapping("/toAddBrand")
    public ModelAndView toAddBrand() {
        return new ModelAndView("sub/brand/addBrand");
    }

    @RequestMapping("/toEditBrand")
    public ModelAndView toEditBrand() {
        return new ModelAndView("sub/brand/editBrand");
    }

    @PostMapping("/add")
    public Result add(MkBrand mkBrand) {
        mkBrandService.save(mkBrand);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkBrandService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkBrand mkBrand) {
        mkBrandService.update(mkBrand);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkBrand mkBrand = mkBrandService.findById(id);
        return ResultGenerator.genSuccessResult(mkBrand);
    }

    @PostMapping("/list")
    public Result list(MkBrandDto mkBrandDto) {
        PageInfo pageInfo = mkBrandService.findList(mkBrandDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/getBrandList")
    public Result getBrandList() {
        List<MkBrand> list = mkBrandService.findAll();
        ;
        return ResultGenerator.genSuccessResult(list);
    }

}
