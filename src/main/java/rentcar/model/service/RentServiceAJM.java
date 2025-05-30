package rentcar.model.service;

import org.apache.ibatis.session.SqlSession;
import rentcar.mapper.RentCarMapperAJM;
import rentcar.model.dto.MemberDTO_rjw;

import java.util.List;

import static rentcar.common.Template.getSqlSession;

public class RentServiceAJM {

    public static List<MemberDTO_rjw> selectAllMember() {

        SqlSession sqlSession = getSqlSession();

        RentCarMapperAJM rentCarMapperAJM = sqlSession.getMapper(RentCarMapperAJM.class);

        List<MemberDTO_rjw> memberList = rentCarMapperAJM.selectAllMember();

        sqlSession.close();

        return memberList;
    }

    public boolean registMember(MemberDTO_rjw member) {

        SqlSession sqlSession = getSqlSession();

        RentCarMapperAJM rentCarMapperAJM = sqlSession.getMapper(RentCarMapperAJM.class);

        int result = rentCarMapperAJM.registMember(member);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true : false;

    }
    public boolean modifyMember(MemberDTO_rjw member) {

        SqlSession sqlSession = getSqlSession();

        RentCarMapperAJM rentCarMapperAJM = sqlSession.getMapper(RentCarMapperAJM.class);

        int result = rentCarMapperAJM.modifyMember(member);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true : false;
    }

    public boolean deleteMember(MemberDTO_rjw member) {

        SqlSession sqlSession = getSqlSession();

        RentCarMapperAJM rentCarMapperAJM = sqlSession.getMapper(RentCarMapperAJM.class);

        int result = rentCarMapperAJM.deleteMember(member);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true : false;
    }
}
