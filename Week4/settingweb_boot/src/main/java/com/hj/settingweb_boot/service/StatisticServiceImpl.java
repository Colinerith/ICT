package com.hj.settingweb_boot.service;

import java.awt.List;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hj.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> selectYearNum(@RequestParam String year) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectLoginYear(year);
            retVal.put("year", year);
            retVal.put("requestLog", "L -y");
            retVal.put("statement", "Success");
            
        }catch(Exception e) {
            retVal.put("yearCnt", -999);
            retVal.put("year", year);
            retVal.put("requestLog", "L -y");
            retVal.put("statement", "Fail");
        }
        
        return retVal;
    }

	@Override
	public HashMap<String, Object> selectMonthNum(String month) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
     
        try {
            retVal = uMapper.selectLoginMonth(month);
            retVal.put("month", month);
            retVal.put("requestLog", "L -m");
            retVal.put("statement", "Success");
            
        }catch(Exception e) {
            retVal.put("monthCnt", -999);
            retVal.put("requestLog", "L -m");
            retVal.put("statement", "Fail");
        }
		return retVal;
	}

	@Override
	public HashMap<String, Object> selectDateNum(String date) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectLoginDate(date);
            retVal.put("date", date);
            retVal.put("requestLog", "L -d");
            retVal.put("statement", "Success");
            
        }catch(Exception e) {
            retVal.put("dateCnt", -999);
            retVal.put("date", date);
            retVal.put("requestLog", "L -d");
            retVal.put("statement", "Fail");
        }
		return retVal;
	}

	@Override
	public HashMap<String, Object> avgDateNum() {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	        try {
	            retVal = uMapper.avgLoginDate();
	            retVal.put("requestLog", "L -a");
	            retVal.put("statement", "Success");
	            
	        }catch(Exception e) {
	            retVal.put("avgCnt", -999);
	            retVal.put("requestLog", "L -a");
	            retVal.put("statement", "Fail");
	        }
			return retVal;
	}

	@Override
	public HashMap<String, Object> avgWeekdayNum() {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	       try {
	            retVal = uMapper.avgLoginWeekday();
	            retVal.put("requestLog", "L -aw");
	            retVal.put("statement", "Success");
	            
	        }catch(Exception e) {
	            retVal.put("avgCnt", -999);
	            retVal.put("requestLog", "L -aw");
	            retVal.put("statement", "Fail");
	        }
			return retVal;
	}

	@Override
	public HashMap<String, Object> selectMonthDepartmentNum(String month, String department) {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	        try {
	            retVal = uMapper.selectLoginMonthDepartment(month, department);
	            retVal.put("month", month);
	            retVal.put("department", department);
	            retVal.put("requestLog", "L -md");
	            retVal.put("statement", "Success");
	            
	        }catch(Exception e) {
	            retVal.put("monthCnt", -999);
	            retVal.put("month", month);
	            retVal.put("department", department);
	            retVal.put("requestLog", "L -md");
	            retVal.put("statement", "Fail");
	        }
			return retVal;
	}
}