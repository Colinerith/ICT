package com.hj.settingweb_boot.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.hj.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> selectYearNum(String year) {
        // TODO Auto-generated method stub
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectLoginYear(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("yearCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }

	@Override
	public HashMap<String, Object> selectMonthNum(String month) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
     
        try {
            retVal = uMapper.selectLoginMonth(month);
            retVal.put("month", month);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("monthCnt", -999);
            retVal.put("month", month);
            retVal.put("is_success", false);
        }
		return retVal;
	}

	@Override
	public HashMap<String, Object> selectDateNum(String date) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectLoginDate(date);
            retVal.put("date", date);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("dateCnt", -999);
            retVal.put("date", date);
            retVal.put("is_success", false);
        }
		return retVal;
	}

	@Override
	public HashMap<String, Object> totalYearNum() {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.totalLoginYear();
            //retVal.put("date", date);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("cnt", -999);
            //retVal.put("date", date);
            retVal.put("is_success", false);
        }
		return retVal;
	}

	@Override
	public HashMap<String, Object> totalMonthNum() {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	        try {
	            retVal = uMapper.totalLoginMonth();
	            retVal.put("is_success", true);
	            
	        }catch(Exception e) {
	            retVal.put("cnt", -999);
	            retVal.put("is_success", false);
	        }
			return retVal;
	}

	@Override
	public HashMap<String, Object> totalDateNum() {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	        try {
	            retVal = uMapper.totalLoginDate();
	            retVal.put("is_success", true);
	            
	        }catch(Exception e) {
	            retVal.put("cnt", -999);
	            retVal.put("is_success", false);
	        }
			return retVal;
	}

	@Override
	public HashMap<String, Object> avgDateNum() {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	        try {
	            retVal = uMapper.avgLoginDate();
	            retVal.put("is_success", true);
	            
	        }catch(Exception e) {
	            retVal.put("cnt", -999);
	            retVal.put("is_success", false);
	        }
			return retVal;
	}

	@Override
	public HashMap<String, Object> avgWeekdayNum() {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	       try {
	            retVal = uMapper.avgLoginWeekday();
	            retVal.put("is_success", true);
	            
	        }catch(Exception e) {
	            retVal.put("cnt", -999);
	            retVal.put("is_success", false);
	        }
			return retVal;
	}

	@Override
	public HashMap<String, Object> avgMonthDepartmentNum() {
	       HashMap<String, Object> retVal = new HashMap<String,Object>();
	        
	        try {
	            retVal = uMapper.avgLoginMonthDepartment();
	            retVal.put("is_success", true);
	            
	        }catch(Exception e) {
	            retVal.put("cnt", -999);
	            retVal.put("is_success", false);
	        }
			return retVal;
	}
 
}