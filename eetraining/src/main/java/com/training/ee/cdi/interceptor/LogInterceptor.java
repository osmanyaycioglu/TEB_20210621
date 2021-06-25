package com.training.ee.cdi.interceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Log
public class LogInterceptor {

    @AroundInvoke
    public Object doIntercept(final InvocationContext context) {
        Method methodLoc = context.getMethod();
        System.out.println("Method name : " + methodLoc);
        Parameter[] parametersLoc = methodLoc.getParameters();
        for (Parameter parameterLoc : parametersLoc) {
            System.out.println("Method param " + parameterLoc);
        }
        Object[] parameters2Loc = context.getParameters();
        for (Object objectLoc : parameters2Loc) {
            System.out.println("Param values : " + objectLoc);
        }
        try {
            Object proceedLoc = context.proceed();
            if (proceedLoc instanceof String) {
                String str = (String) proceedLoc;
                return str + " intercepted";
            }
            return proceedLoc;
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

}
