package com.zxl.movie.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zxl.movie.domain.Movie;
import com.zxl.movie.vo.MovieVO;

public interface MovieService {
	PageInfo<Movie> selects(MovieVO movievo,Integer pageNum,Integer pageSize);

	int updatestatus(Integer status, Integer id);

	
}
