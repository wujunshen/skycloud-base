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
package com.skycloud.base.authentication.model.po;

import com.sky.framework.web.support.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 用户表
 *
 * @author code generator
 * @date 2019-09-11 13:27:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "t_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码密文
     */
    private String password;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户手机
     */
    private String mobile;
    /**
     * 是否有效用户
     */
    private Boolean enabled;
    /**
     * 账号是否未过期
     */
    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;
    /**
     * 密码是否未过期
     */
    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;
    /**
     * 是否未锁定
     */
    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

}
