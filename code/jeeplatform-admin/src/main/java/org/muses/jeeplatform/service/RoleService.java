package org.muses.jeeplatform.service;

import org.muses.jeeplatform.core.dao.repository.admin.RoleRepository;
import org.muses.jeeplatform.core.entity.admin.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Nicky on 2017/7/30.
 */
@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    /**
     * 构建PageRequest对象
     * @param num
     * @param size
     * @param asc
     * @param string
     * @return
     */
    private PageRequest buildPageRequest(int num, int size, Sort.Direction asc,
                                         String string) {
        return new PageRequest(num-1, size,null,string);
    }

    /**
     * 获取所有的菜单信息并分页显示
     * @param pageNo
     * 			当前页面数
     * @param pageSize
     * 			每一页面的页数
     * @return
     */
    public Page<Role> findAll(int pageNo, int pageSize, Sort.Direction dir, String str){
        PageRequest pageRequest = buildPageRequest(pageNo, pageSize, dir, str);
        Page<Role> roles = roleRepository.findAll(pageRequest);
        return roles;
    }

}
