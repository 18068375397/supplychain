package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkBuyOrderDto;
import com.xinyonghang.supplychain.model.MkBuyOrder;
import com.xinyonghang.supplychain.service.MkBuyOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/buy/order")
public class MkBuyOrderController {
    @Resource
    private MkBuyOrderService mkBuyOrderService;

    @RequestMapping("/toBuyOrderList")
    public ModelAndView toProductList() {
        return new ModelAndView("sub/buyOrder/buyOrderList");
    }

    @RequestMapping("/toAddBuyOrder")
    public ModelAndView toAddBuyOrder() {
        return new ModelAndView("sub/buyOrder/addBuyOrder");
    }

    @PostMapping("/add")
    public Result add(MkBuyOrder mkBuyOrder) {
        mkBuyOrderService.save(mkBuyOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkBuyOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkBuyOrder mkBuyOrder) {
        mkBuyOrderService.update(mkBuyOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkBuyOrder mkBuyOrder = mkBuyOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mkBuyOrder);
    }

    @PostMapping("/list")
    public Result list(MkBuyOrderDto mkBuyOrderDto) {
        PageInfo pageInfo = mkBuyOrderService.findList(mkBuyOrderDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
