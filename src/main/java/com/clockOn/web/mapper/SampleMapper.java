package com.clockOn.web.mapper;

import org.apache.ibatis.annotations.Select;

public interface SampleMapper {
	@Select("select now()")
	public String getTime();
	
}
