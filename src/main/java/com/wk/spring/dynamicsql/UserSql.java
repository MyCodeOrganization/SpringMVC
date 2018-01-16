package com.wk.spring.dynamicsql;

import org.apache.ibatis.jdbc.SQL;

/**
 * PackageName com.wk.spring.dynamicsql
 * Created by wangkang on 2018/1/15.
 */
public class UserSql {
    public String getListByCondSql(final String columns,final String where,
                                             final String orderby,final String limit){
        String limitSql = "";
        if (!(null == limit || limit.trim().equals(""))){
            limitSql = "limit " + limit;
        }
        String orderbySql = "";
        if (!(null == orderby || orderby.trim().equals(""))){
            orderbySql = "order by " + orderby;
        }
        return new SQL(){
            {
                if (!(null == columns || columns.trim().equals(""))){
                    SELECT(columns);
                }else{
                    SELECT("*");
                }
                FROM("info");
                if (!(null == where || where.trim().equals(""))){
                    WHERE(where);
                }
            }
        }.toString()+orderby+limitSql;
    }

    public String deleteByCond(final String where){
        return new SQL(){
            {
                DELETE_FROM("info");
                if (!(null == where || where.trim().equals(""))){
                    WHERE(where);
                }
            }
        }.toString();
    }
    public String getCountByCond(final String where){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("info");
                if (!(null == where || where.trim().equals(""))){
                    WHERE(where);
                }
            }
        }.toString();
    }
}
