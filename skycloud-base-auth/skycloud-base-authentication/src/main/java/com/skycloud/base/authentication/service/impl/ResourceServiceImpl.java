/*
 * The MIT License (MIT)
 * Copyright © 2019 <sky>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.skycloud.base.authentication.service.impl;

import com.skycloud.base.authentication.enums.ResourceType;
import com.skycloud.base.authentication.mapper.ResourceMapper;
import com.skycloud.base.authentication.model.bo.ResourceTreeNodeBo;
import com.skycloud.base.authentication.model.domain.Resource;
import com.skycloud.base.authentication.model.dto.UserDto;
import com.skycloud.base.authentication.service.ResourceService;
import com.sky.framework.common.json.JsonUtils;
import com.sky.framework.common.tree.ITreeNode;
import com.sky.framework.common.tree.Tree;
import com.sky.framework.web.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * 资源表
 *
 * @author code generator
 * @date 2019-09-11 13:33:46
 */
@Service("resourcesService")
public class ResourceServiceImpl extends BaseService<Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public String listMenuByUserId(UserDto userDto) {
        userDto.setType(ResourceType.MENU.getKey() + "");
        List<Resource> resources = resourceMapper.listResourceByUserId(userDto);
        List<ITreeNode> list = new ArrayList<>();
        resources.forEach(resource -> list.add(new ResourceTreeNodeBo(resource)));
        Tree tree = new Tree(list);
        String data = JsonUtils.toJsonString(tree.getRoot(), "parent", "allChildren");
        return data;
    }

    @Override
    public List<Resource> listButtonByUserId(UserDto userDto) {
        userDto.setType(ResourceType.BUTTON.getKey() + "");
        List<Resource> resources = resourceMapper.listResourceByUserId(userDto);
        for (Resource resource : resources) {
            resource.setCode(resource.getCode().replace(":", "_"));
        }
        return resources;
    }
}
