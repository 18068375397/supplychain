package com.xinyonghang.supplychain.aop;

import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.utils.GsonUtil;
import com.xinyonghang.supplychain.utils.SpringContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Aspect
@Component("controllerAop")
public class ControllerAop implements Ordered {

    private final Logger log = LoggerFactory.getLogger(getClass());


    @Pointcut("execution(* com.xinyonghang.supplychain.controller.*Controller.*(..)) && !execution(* com.xinyonghang.supplychain.controller.FileController.*(..))")
    public void clientAction() {
    }


    /**
     * Controller切面层
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("clientAction()")
    public Object clientAction(ProceedingJoinPoint pjp) throws Throwable {
//        long startTime = new Date().getTime();
        Class<? extends Object> target = pjp.getTarget().getClass();
        String method = pjp.getSignature().getName();
        if (target != null && method != null) {
            // 获取参数
            // TODO session,token验证  文件上传验证
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Map<String, Object> params = new HashMap<String, Object>();
            Set<String> names = request.getParameterMap().keySet();
            String[] array = (String[]) names.toArray(new String[0]);
            String[] arrayOfString;
            int j = (arrayOfString = array).length;
            for (int i = 0; i < j; i++) {
                String name = arrayOfString[i];
                String value = request.getParameter(name);
                params.put(name, value);
            }
            request.setAttribute("jsonString", GsonUtil.GsonString(params));
            Object proceed = pjp.proceed();
            return proceed;

//            Result result = validParams(request, target, params, method);
//            if (result.getCode() == 200) {
//                request.setAttribute("jsonString", GsonUtil.GsonString(params));
//                Object proceed = pjp.proceed();
//                return proceed;
//            } else {
//                return result;
//            }
        } else {
            //  没有找到对应的方法
            // TODO  返回一个错误页面
            String page = "";
            return page;
        }
    }


    @Override
    public int getOrder() {
        return 1;
    }


    public Result validParams(HttpServletRequest request, Class<? extends Object> target, Map<String, Object> params, String method) {
        Result result = null;
        String validName = target.getSimpleName().split("Controller")[0] + "Valid";
        if (request.getRequestURL().indexOf("/mk/producta/add") != -1) {
            String first = validName.substring(0, 1).toLowerCase();
            String last = validName.substring(1, validName.length());
            validName = first + last;
            boolean has_bean = SpringContextUtils.containsBean(validName);
            Object validBean = null;
            if (has_bean) {
                validBean = SpringContextUtils.getBean(validName);
                try {
                    result = (Result) validBean.getClass().getMethod(method, new Class[]{Map.class}).invoke(validBean, new Object[]{params});
                } catch (Exception e) {
                    result = ResultGenerator.genFailResult(1002, "缺少参数验证方法");
                }
            } else {
                result = ResultGenerator.genFailResult(1001, "缺少参数验证类");
            }
        } else {
            result = ResultGenerator.genSuccessResult();
        }


        return result;
    }


}