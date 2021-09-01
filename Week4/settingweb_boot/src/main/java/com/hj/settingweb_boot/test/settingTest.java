package com.hj.settingweb_boot.test;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/login/year/{year}")
    public Map<String, Object> sqlYearSelect(@PathVariable String year) throws Exception{ 
        return service.selectYearNum(year);
    }
    
    @ResponseBody 
    @RequestMapping("/login/month/{month}")
    public Map<String, Object> sqlMonthSelect(@PathVariable String month) throws Exception{ 
        return service.selectMonthNum(month);
    }
    
    @ResponseBody 
    @RequestMapping("/login/date/{date}")
    public Map<String, Object> sqlDateSelect(@PathVariable String date) throws Exception{ 
        return service.selectDateNum(date);
    }
    
    @ResponseBody 
    @RequestMapping("/login/avg")
    public Map<String, Object> sqlDateAvg() throws Exception{ 
        return service.avgDateNum();
    }
    
    @ResponseBody 
    @RequestMapping("/login/avg/weekDay")
    public Map<String, Object> sqlWeekdayAvg() throws Exception{ 
        return service.avgWeekdayNum();
    }
    
    @ResponseBody 
    @RequestMapping("/login/month/{month}/{department}")
    public Map<String, Object> sqlMonthDepartmentTotal(@PathVariable String month, @PathVariable String department) throws Exception{ 
        return service.selectMonthDepartmentNum(month, department);
    }
    
    @RequestMapping("/test")
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "hj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("HELLO WORLD"); 
        resultList.add("TEST1"); 
        resultList.add("TEST2"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}