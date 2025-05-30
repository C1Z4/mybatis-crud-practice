package rentcar.model.dao;

import org.apache.ibatis.session.SqlSession;
import rentcar.mapper.MemberMapper_YJE;
import rentcar.model.dto.MemberAndLevelDTO_YJE;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

public class MemberDAO_YJE {
    public static List<MemberDTO_rjw> selectAllMembers(SqlSession sqlSession) {

        MemberMapper_YJE mapper = sqlSession.getMapper(MemberMapper_YJE.class);

        return mapper.selectAllMembers();
    }

    public static List<MemberAndLevelDTO_YJE> selectAllMembersWith(SqlSession sqlSession) {

        MemberMapper_YJE mapper = sqlSession.getMapper(MemberMapper_YJE.class);

        return mapper.selectAllMembersWith();
    }

    public static MemberDTO_rjw selectMemberByCode(SqlSession sqlSession, int code) {

        MemberMapper_YJE mapper = sqlSession.getMapper(MemberMapper_YJE.class);

        return mapper.selectMemberByCode(code);
    }

    public MemberAndLevelDTO_YJE selectMemberByCodeWith(SqlSession sqlSession, int code) {

        MemberMapper_YJE mapper = sqlSession.getMapper(MemberMapper_YJE.class);

        return mapper.selectMemberByCodeWith(code);
    }

    public int insertMember(SqlSession sqlSession, MemberDTO_rjw member) {

        MemberMapper_YJE mapper = sqlSession.getMapper(MemberMapper_YJE.class);

        return mapper.insertMember(member);
    }

    public int updateMember(SqlSession sqlSession, MemberDTO_rjw member) {

        MemberMapper_YJE mapper = sqlSession.getMapper(MemberMapper_YJE.class);

        return mapper.updateMember(member);
    }

    public int deleteMember(SqlSession sqlSession, int code) {

        MemberMapper_YJE mapper = sqlSession.getMapper(MemberMapper_YJE.class);

        return mapper.deleteMember(code);
    }
}
