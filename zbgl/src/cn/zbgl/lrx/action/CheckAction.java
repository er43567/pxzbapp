package cn.zbgl.lrx.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Namespace("/")
@ParentPackage("json-default")//非json时，则为"struts-default"

@Controller("checkAction")
@Scope("prototype")
public class CheckAction {

}
