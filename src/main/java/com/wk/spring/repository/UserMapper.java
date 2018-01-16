//package com.wk.spring.repository;
//
//import com.wk.spring.dynamicsql.UserSql;
//import com.wk.spring.entity.UserEntity;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
///**
// * PackageName com.wk.spring.repository
// * Created by wangkang on 2018/1/15.
// */
//public interface UserMapper {
//    @Delete("DELETE FROM info WHERE id = #{id}")
//    int deleteById(Long id);
//
//    @Insert("INSERT into info (name,age,sex)" +
//            "values(#{name,jdbcType=VARCHAR},#{age,jdbcType=SMALLINT,#{sex,jdbcType=SMALLINT}})")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    int insert(UserEntity entity);
//
//    @Results(
//            {
//                    @Result(property = "id",column = "id"),
//                    @Result(property = "name",column = "name"),
//                    @Result(property = "age",column = "age"),
//                    @Result(property = "sex",column = "sex")
//            }
//    )
//    @Select("SELECT * FROM info WHERE id = #{id} limit 1")
//    UserEntity selectById(Long id);
//
//    @Results({
//            @Result(property = "id",column = "id"),
//            @Result(property = "name",column = "name"),
//            @Result(property = "age",column = "age"),
//            @Result(property = "sex",column = "sex")
//    })
//    @Select("SELECT * FROM info limit #{offset},#{size}")
//    List<UserEntity> findAllByPages(@Param("offset") int offset,@Param("size") int size);
//
//    @Results({
//            @Result(property = "id",column = "id"),
//            @Result(property = "name",column = "name"),
//            @Result(property = "age",column = "age"),
//            @Result(property = "sex",column = "sex")
//    })
//    @SelectProvider(type = UserSql.class,method = "getListByCondSql")
//    List<UserEntity> getListByCond(String columns,String where,String orderby,String limit);
//
//    @Update("UPDATE info set name=#{name,jdbcType=VARCHAR},age=#{age,jdbcType=SMALLINT},sex=#{sex,jdbcType=SAMLLINT}")
//    int updateByEntity(UserEntity entity);
//
//    @SelectProvider(type=UserSql.class,method = "getCountByCond")
//    int getCountByCond(String where);
//
//    @DeleteProvider(type = UserSql.class,method = "deleteByCond")
//    int deleteByCond(String where);
//
//    @Select("SELECT count(*) FROM info")
//    int getCount();
//}
