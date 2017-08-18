package com.zhaopin.mapper;

import com.zhaopin.entity.Discussion;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface DiscussionMapper {
    @Delete({
        "delete from discussion",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into discussion (fromid, toid, ",
        "discussionid)",
        "values (#{fromid,jdbcType=BIGINT}, #{toid,jdbcType=BIGINT}, ",
        "#{discussionid,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    int insert(Discussion discussion);

    @Select({
        "select",
        "id, fromid, toid, discussionid",
        "from discussion",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="fromid", property="fromid", jdbcType= JdbcType.BIGINT),
        @Result(column="toid", property="toid", jdbcType= JdbcType.BIGINT),
        @Result(column="discussionid", property="discussionid", jdbcType= JdbcType.BIGINT)
    })
    Discussion selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, fromid, toid, discussionid",
            "from discussion",
            /*"where fromid = #{0} and toid = #{1}",--这种根据索引取参数的方式会报错*/
            "where fromid = #{fromid} and toid = #{toid}",
            "order by id desc limit 1"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="fromid", property="fromid", jdbcType= JdbcType.BIGINT),
            @Result(column="toid", property="toid", jdbcType= JdbcType.BIGINT),
            @Result(column="discussionid", property="discussionid", jdbcType= JdbcType.BIGINT)
    })
    Discussion selectByFromidAndToid(@Param("fromid") long fromid, @Param("toid") long toid);

    @Select({
        "select",
        "id, fromid, toid, discussionid",
        "from discussion"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="fromid", property="fromid", jdbcType= JdbcType.BIGINT),
        @Result(column="toid", property="toid", jdbcType= JdbcType.BIGINT),
        @Result(column="discussionid", property="discussionid", jdbcType= JdbcType.BIGINT)
    })
    List<Discussion> selectAll();

    @Update({
        "update discussion",
        "set fromid = #{fromid,jdbcType=BIGINT},",
          "toid = #{toid,jdbcType=BIGINT},",
          "discussionid = #{discussionid,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Discussion discussion);
}