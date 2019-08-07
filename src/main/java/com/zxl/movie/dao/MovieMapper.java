package com.zxl.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zxl.movie.domain.Movie;
import com.zxl.movie.vo.MovieVO;

public interface MovieMapper {
	List<Movie> selects(MovieVO movievo);
	@Update("update  movie set status = #{status} where id = #{id}")
	int updatestatus(@Param("status")Integer status,@Param("id") Integer id);
}
