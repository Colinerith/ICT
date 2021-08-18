package com.hj.service;

import java.util.List;
import com.hj.vo.MovieVO;
 
public interface MovieService {
    public List<MovieVO> selectMovie() throws Exception;
}