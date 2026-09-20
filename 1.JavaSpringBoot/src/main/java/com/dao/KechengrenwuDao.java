package com.dao;

import com.entity.KechengrenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechengrenwuVO;
import com.entity.view.KechengrenwuView;


/**
 * 课程任务
 * 
 * @author 
 * @email 
 * @date 2024-04-23 09:31:38
 */
public interface KechengrenwuDao extends BaseMapper<KechengrenwuEntity> {
	
	List<KechengrenwuVO> selectListVO(@Param("ew") Wrapper<KechengrenwuEntity> wrapper);
	
	KechengrenwuVO selectVO(@Param("ew") Wrapper<KechengrenwuEntity> wrapper);
	
	List<KechengrenwuView> selectListView(@Param("ew") Wrapper<KechengrenwuEntity> wrapper);

	List<KechengrenwuView> selectListView(Pagination page,@Param("ew") Wrapper<KechengrenwuEntity> wrapper);

	
	KechengrenwuView selectView(@Param("ew") Wrapper<KechengrenwuEntity> wrapper);
	

}
