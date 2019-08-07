package com.zxl.movie.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zxl.movie.domain.Movie;
import com.zxl.movie.service.MovieService;
import com.zxl.movie.utils.PageUtil;
import com.zxl.movie.vo.MovieVO;

@Controller
public class MovieController {
	@Resource
	private MovieService service;
	@RequestMapping("selects")
	public String selects(HttpServletRequest request,MovieVO movievo,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "2")Integer pageSize) {
		PageInfo<Movie> info = service.selects(movievo, pageNum, pageSize);
		PageUtil.page(request, "selects", pageSize, info.getList(), (int) info.getTotal(), pageNum);
		request.setAttribute("info",info.getList());
		request.setAttribute("movievo",movievo);
		return "list";
		
	}
	@ResponseBody
	@RequestMapping("updatestatus")
	public int updatestatus(Integer status,Integer id) {
		return service.updatestatus(status,id);
	}
	

}
