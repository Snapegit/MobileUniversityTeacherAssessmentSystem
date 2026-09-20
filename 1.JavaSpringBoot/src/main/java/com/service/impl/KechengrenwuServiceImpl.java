package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KechengrenwuDao;
import com.entity.KechengrenwuEntity;
import com.service.KechengrenwuService;
import com.entity.vo.KechengrenwuVO;
import com.entity.view.KechengrenwuView;

@Service("kechengrenwuService")
public class KechengrenwuServiceImpl extends ServiceImpl<KechengrenwuDao, KechengrenwuEntity> implements KechengrenwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengrenwuEntity> page = this.selectPage(
                new Query<KechengrenwuEntity>(params).getPage(),
                new EntityWrapper<KechengrenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengrenwuEntity> wrapper) {
		  Page<KechengrenwuView> page =new Query<KechengrenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KechengrenwuVO> selectListVO(Wrapper<KechengrenwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KechengrenwuVO selectVO(Wrapper<KechengrenwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KechengrenwuView> selectListView(Wrapper<KechengrenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengrenwuView selectView(Wrapper<KechengrenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
