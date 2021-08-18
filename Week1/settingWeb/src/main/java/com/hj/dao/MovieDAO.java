package com.hj.dao;
import java.util.List;
import com.hj.vo.MovieVO;
 
public interface MovieDAO {
    public List<MovieVO> selectMovie() throws Exception;
}