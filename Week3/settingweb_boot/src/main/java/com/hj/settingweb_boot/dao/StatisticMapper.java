package com.hj.settingweb_boot.dao;
import java.util.HashMap;

import com.hj.settingweb_boot.dto.StatisticDto;
 
public interface  StatisticMapper {
    public HashMap<String, Object> selectLoginYear(String year);
    public HashMap<String, Object> selectLoginMonth(String month);
    public HashMap<String, Object> selectLoginDate(String month);
    public HashMap<String, Object> totalLoginYear();
    public HashMap<String, Object> totalLoginMonth();
    public HashMap<String, Object> totalLoginDate();
    public HashMap<String, Object> avgLoginDate();
    public HashMap<String, Object> avgLoginWeekday();
    public HashMap<String, Object> avgLoginMonthDepartment();
}