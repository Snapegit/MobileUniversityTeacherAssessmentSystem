package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KechengrenwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KechengrenwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KechengrenwuView;


/**
 * 课程任务
 *
 * @author 
 * @email 
 * @date 2024-04-23 09:31:38
 */
public interface KechengrenwuService extends IService<KechengrenwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengrenwuVO> selectListVO(Wrapper<KechengrenwuEntity> wrapper);
   	
   	KechengrenwuVO selectVO(@Param("ew") Wrapper<KechengrenwuEntity> wrapper);
   	
   	List<KechengrenwuView> selectListView(Wrapper<KechengrenwuEntity> wrapper);
   	
   	KechengrenwuView selectView(@Param("ew") Wrapper<KechengrenwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengrenwuEntity> wrapper);

   	

}

