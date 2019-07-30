package it.cast.jiewen.web.dao;

import it.cast.jiewen.web.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id=#{id}")
    public Member findByid(String id) throws Exception;
}
