package com.hj.settingweb_boot.test;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.hj.settingweb_boot.dao.StatisticMapper;
import com.hj.settingweb_boot.service.StatisticService;
 
 
@Controller
public class settingTest {
   
    @Autowired
    private StatisticService service;
    
    @ResponseBody 
    @RequestMapping("/login/year")
    public Map<String, Object> sqlYearSelect(String year) throws Exception{ 
        return service.selectYearNum(year);
    }
    
    @ResponseBody 
    @RequestMapping("/login/month")
    public Map<String, Object> sqlMonthSelect(String month) throws Exception{ 
        return service.selectMonthNum(month);
    }
    
    @ResponseBody 
    @RequestMapping("/login/date")
    public Map<String, Object> sqlDateSelect(String date) throws Exception{ 
        return service.selectDateNum(date);
    }
    
    @ResponseBody 
    @RequestMapping("/login/year/")
    public Map<String, Object> sqlYearTotal() throws Exception{ 
        return service.totalYearNum();
    }
    
    @ResponseBody 
    @RequestMapping("/login/month/")
    public Map<String, Object> sqlMonthTotal() throws Exception{ 
        return service.totalMonthNum();
    }
    
    @ResponseBody 
    @RequestMapping("/login/date/")
    public Map<String, Object> sqlDateTotal() throws Exception{ 
        return service.totalDateNum();
    }
    
    @ResponseBody 
    @RequestMapping("/login/date/avg")
    public Map<String, Object> sqlDateAvg() throws Exception{ 
        return service.avgDateNum();
    }
    
    @ResponseBody 
    @RequestMapping("/login/weekday/avg")
    public Map<String, Object> sqlWeekdayAvg() throws Exception{ 
        return service.avgWeekdayNum();
    }
    
    @ResponseBody 
    @RequestMapping("/login/month/department")
    public Map<String, Object> sqlMonthDepartmentTotal() throws Exception{ 
        return service.avgMonthDepartmentNum();
    }
    
    @RequestMapping("/test")
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "hj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}