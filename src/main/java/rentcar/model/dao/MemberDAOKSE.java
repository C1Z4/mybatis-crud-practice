package rentcar.model.dao;

import org.apache.ibatis.session.SqlSession;
import rentcar.mapper.MemberMapperKSE;
import rentcar.model.dto.MemberAndLevelDTOKSE;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

public class MemberDAOKSE {
    private MemberMapperKSE mapper;

    public List<MemberAndLevelDTOKSE> selectAllMemeber(SqlSession sqlSession) {
        mapper = sqlSession.getMapper(MemberMapperKSE.class);

        List<MemberAndLevelDTOKSE> memberList = mapper.selectAllMember();

        return memberList;
    }

    public MemberAndLevelDTOKSE selectMemberById(SqlSession sqlSession, int memberCode) {
        mapper = sqlSession.getMapper(MemberMapperKSE.class);

        MemberAndLevelDTOKSE member = mapper.selectMemberById(memberCode);

        return member;
    }

    public int registMember(SqlSession sqlSession, MemberDTO_rjw member) {
        mapper = sqlSession.getMapper(MemberMapperKSE.class);

        int result = mapper.registMapper(member);

        return result;
    }

    public int modifyMember(SqlSession sqlSession, MemberDTO_rjw member) {
        mapper = sqlSession.getMapper(MemberMapperKSE.class);

        int result = mapper.modifyMember(member);

        return result;
    }

    public int removeMember(SqlSession sqlSession, String memberCode) {
        mapper = sqlSession.getMapper(MemberMapperKSE.class);

        int result = mapper.removeMember(memberCode);

        return result;
    }
}
