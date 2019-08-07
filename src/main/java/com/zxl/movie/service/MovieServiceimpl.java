package com.zxl.movie.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxl.movie.dao.MovieMapper;
import com.zxl.movie.domain.Movie;
import com.zxl.movie.vo.MovieVO;

@Service
public class MovieServiceimpl implements MovieService {
	@Resource
	private MovieMapper mapper;

	@Override
	public PageInfo<Movie> selects(MovieVO movievo,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Movie> list = mapper.selects(movievo);
		PageInfo<Movie> info = new PageInfo<Movie>(list);
		return info;
	}

	@Override
	public int updatestatus(Integer status, Integer id) {
		// TODO Auto-generated method stub
		return mapper.updatestatus(status,id);
	}

}
