package com.lppz.cloud.componet;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义boot默认的错信息
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest request, ErrorAttributeOptions options) {
        Map<String, Object> attr= super.getErrorAttributes(request, options);
        attr.put("ext",request.getAttribute("ext",0));
        return attr;
    }
    //    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//        Map<String, Object> attr= super.getErrorAttributes(webRequest, options);
//        attr.put("ext",webRequest.getAttribute("ext",0));
//        return attr;
//    }
}
