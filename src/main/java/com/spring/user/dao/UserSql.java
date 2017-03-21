package com.spring.user.dao;

import com.alibaba.druid.sql.builder.SQLBuilder;
import com.alibaba.druid.sql.builder.SQLBuilderFactory;
import com.spring.user.pojo.User;

/**
 * Created by xxb on 2017/3/21.
 */
public class UserSql {

    public String getUserSql(User user) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from user where ");
        if (user.getUserId() != null) {
            sql.append("id=").append(user.getUserId());
        }

        return sql.toString();
    }
}
