package com.hj.settingweb_boot.service;

import java.util.HashMap;
import java.util.List;

public interface StatisticService {
    public HashMap<String,Object> selectYearNum(String year);
    public HashMap<String,Object> selectMonthNum(String month);
    public HashMap<String,Object> selectDateNum(String date);
    public HashMap<String,Object> selectMonthDepartmentNum(String month, String department);
//    public List<HashMap<String,Object>> totalYearNum();
//    public HashMap<String,Object> totalMonthNum();
//    public HashMap<String,Object> totalDateNum();
    public HashMap<String,Object> avgDateNum();
    public HashMap<String,Object> avgWeekdayNum();
}