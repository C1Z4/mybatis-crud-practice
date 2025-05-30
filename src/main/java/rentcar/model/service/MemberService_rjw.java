package rentcar.model.service;

import org.apache.ibatis.session.SqlSession;
import rentcar.mapper.RentCarMapper_rjw;
import rentcar.model.dto.LevelDTO;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

import static rentcar.common.Template.getSqlSession;

public class MemberService_rjw {

    public MemberDTO_rjw selectMemberLevelInfo(Integer memberCode) {

        SqlSession sqlSession = getSqlSession();

        RentCarMapper_rjw rentCarMapper = sqlSession.getMapper(RentCarMapper_rjw.class);

        MemberDTO_rjw memberLevelInfo = rentCarMapper.selectMemberLevelInfo(memberCode);

        sqlSession.close();

        return memberLevelInfo;
    }

    public List<MemberDTO_rjw> selectAllMemberWithLevel() {

        SqlSession sqlSession = getSqlSession();

        RentCarMapper_rjw rentCarMapper = sqlSession.getMapper(RentCarMapper_rjw.class);

        List<MemberDTO_rjw> memberWithLevelList = rentCarMapper.selectAllMemberWithLevel();

        sqlSession.close();

        return memberWithLevelList;
    }

    public boolean registMember(MemberDTO_rjw member) {

        SqlSession sqlSession = getSqlSession();

        RentCarMapper_rjw rentCarMapper = sqlSession.getMapper(RentCarMapper_rjw.class);

        int result = rentCarMapper.registerMember(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }


    public boolean modifyMember(MemberDTO_rjw member) {
        SqlSession sqlSession = getSqlSession();

        RentCarMapper_rjw rentCarMapper = sqlSession.getMapper(RentCarMapper_rjw.class);

        if (member.getLevel() != null && member.getLevel().getLevel() != null) {
            String level = member.getLevel().getLevel();
            LevelDTO completeLevelInfo = rentCarMapper.selectLevelByName(level);

            if (completeLevelInfo != null) {
                member.setLevel(completeLevelInfo);
            }
        }

        int result = rentCarMapper.modifyMember(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean deleteMember(Integer memberCode) {
        SqlSession sqlSession = getSqlSession();

        RentCarMapper_rjw rentCarMapper = sqlSession.getMapper(RentCarMapper_rjw.class);

        int result = rentCarMapper.deleteMember(memberCode);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }
}
