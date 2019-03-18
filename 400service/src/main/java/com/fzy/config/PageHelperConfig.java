package com.fzy.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * 适用于mybatis的分页插件pageHelper的配置类
 * @author fzywhy
 *
 */
@Configuration				//表示此类用来做配置
public class PageHelperConfig {
	
	@Bean					//表示启动PageHelper这个拦截器
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		//offsetAsPageNum设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
		properties.setProperty("offsetAsPageNum", "true");
		//rowBoundsWithCount设置为true时，使用RowBounds分页会进行count查询
		properties.setProperty("rowBoundsWithCount", "true");
		//reasonable：启用合理化时，若pageNum<1会查询第一页，若pageNum>pages会查询最后一页
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}







