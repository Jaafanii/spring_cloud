package org.sid.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RefreshScope
@RestController
public class CompanyRestService {
    @Value("${param}")
    int param;
    @Value("${mail}")
    String mail;
    @GetMapping("/config")
    Map<String,Object> getParams(){
        Map<String,Object> list=new HashMap<>();
        list.put("parm",param);
        list.put("mail",mail);
        list.put("threadName",Thread.currentThread().getName());
        return list;
    }
}
