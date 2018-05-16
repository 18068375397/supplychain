package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkProductDto;
import com.xinyonghang.supplychain.model.MkProduct;
import com.xinyonghang.supplychain.service.MkProductService;
import com.xinyonghang.supplychain.utils.GsonUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/26.
 */
@RestController
@RequestMapping("/mk/product")
public class MkProductController {
    @Resource
    private MkProductService mkProductService;

    @RequestMapping("/toProductList")
    public ModelAndView toProductList() {
        return new ModelAndView("sub/product/productList");
    }

    @RequestMapping("/toAddProduct")
    public ModelAndView toAddProduct() {
        return new ModelAndView("sub/product/addProduct");
    }

    @RequestMapping("/toEditProduct")
    public ModelAndView toEditProduct() {
        return new ModelAndView("sub/product/editProduct");
    }

    @PostMapping("/add")
    public Result add() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        JsonObject params = GsonUtil.StringToJsonObject(request.getAttribute("jsonString").toString());
        Result result = mkProductService.saveProduct(params);
        return result;
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkProductService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkProduct mkProduct) {
        mkProductService.update(mkProduct);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkProduct mkProduct = mkProductService.findById(id);
        return ResultGenerator.genSuccessResult(mkProduct);
    }

    @PostMapping("/list")
    public Result list(MkProductDto mkProductDto) {
        PageInfo pageInfo = mkProductService.findList(mkProductDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据条件查询
     *
     * @param mkProductDto
     * @return
     */
    @PostMapping("/queryList")
    public Result queryList(MkProductDto mkProductDto) {
        List<MkProduct> list = mkProductService.queryList(mkProductDto);
        return ResultGenerator.genSuccessResult(list);
    }

}
