package demo.webservice;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class SayHiServiceImpl implements SayHiService {
	public String sayHi(String name) {
		if (name == null) {
			return "连名字也不肯告诉我吗？";
		}
		return name + ", 你吃了吗？没吃回家吃去吧。";
	}
	
	public String sayHi2(String name){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("result", name+",你妈妈喊你回家吃饭！");
		Map<String, String> submap = new HashMap<String, String>();
		submap.put("餐具", "筷子和碗");
		submap.put("食物", "青菜豆腐");
		submap.put("地点", "自家厨房");
		map.put("详情", submap);
		return JSON.toJSONString(map);
	}

	public String sayHi3(String name){
		return "{'name':'"+name+"','result':'"+name+",你妈妈喊你回家吃饭！'}";
	}
	
	public String 不告诉你() {
		return "我的名字不告诉你！";
	}
}
