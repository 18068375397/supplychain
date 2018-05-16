package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkSailOrderDetailDto;
import com.xinyonghang.supplychain.model.MkSailOrderDetail;
import com.xinyonghang.supplychain.service.MkSailOrderDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/sail/order/detail")
public class MkSailOrderDetailController {
    @Resource
    private MkSailOrderDetailService mkSailOrderDetailService;

    @PostMapping("/add")
    public Result add(MkSailOrderDetail mkSailOrderDetail) {
        mkSailOrderDetailService.save(mkSailOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkSailOrderDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkSailOrderDetail mkSailOrderDetail) {
        mkSailOrderDetailService.update(mkSailOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkSailOrderDetail mkSailOrderDetail = mkSailOrderDetailService.findById(id);
        return ResultGenerator.genSuccessResult(mkSailOrderDetail);
    }

    @PostMapping("/list")
    public Result list(MkSailOrderDetailDto mkSailOrderDetailDto) {
        PageInfo pageInfo = mkSailOrderDetailService.findList(mkSailOrderDetailDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
