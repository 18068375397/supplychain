package com.xinyonghang.supplychain.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component("mapperAop")
public class MapperAop implements Ordered {
    @Pointcut("execution(* com.xinyonghang.supplychain.dao.*Dao.*.insert*(..)) || execution(*  tk.mybatis.mapper.common.*.*.insert*(..))")
    public void insert() {
    }

    @Pointcut("execution(* com.xinyonghang.supplychain.dao.*Dao.*.update*(..)) || execution(* tk.mybatis.mapper.common.*.*.update*(..))")
    public void update() {
    }

    @Around("insert() || update()")
    public Object insert(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            // TODO 从用户信息中获取
            String realName = "system";
            try {
                Object object = args[0];
                if (signature.getName().indexOf("insert") != -1) {
                    Method setCreatedAt = object.getClass().getMethod("setCreateTime", Date.class);
                    setCreatedAt.invoke(object, new Date());
                    Method method = object.getClass().getMethod("getOperator");
                    Object operator = method.invoke(object);
                    if (operator == null || "".equals(operator.toString().trim())) {
                        Method setCreatedBy = object.getClass().getMethod("setOperator", String.class);
                        setCreatedBy.invoke(object, realName);
                    }

                } else if (signature.getName().indexOf("update") != -1) {
                    Method setCreatedAt = object.getClass().getMethod("setLastOperatorTime", Date.class);
                    setCreatedAt.invoke(object, new Date());
                    Method method = object.getClass().getMethod("getLastOperator");
                    Object operator = method.invoke(object);
                    if (operator == null || "".equals(operator.toString().trim())) {
                        Method setCreatedBy = object.getClass().getMethod("setLastOperator", String.class);
                        setCreatedBy.invoke(object, realName);
                    }
                }
            } catch (Exception e) {
                // TODO: exception
            }

        }
        Object proceed = pjp.proceed();
        return proceed;
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
