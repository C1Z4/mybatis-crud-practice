package rentcar.model.service;

import org.apache.ibatis.session.SqlSession;
import rentcar.mapper.RentCarMapperAJM;
import rentcar.model.dto.MemberDTO;

import java.util.List;

import static rentcar.common.Template.getSqlSession;

public class RentServiceAJM {

    public static List<MemberDTO> selectAllMember() {

        SqlSession sqlSession = getSqlSession();

        RentCarMapperAJM rentCarMapperAJM = sqlSession.getMapper(RentCarMapperAJM.class);

        List<MemberDTO> memberList = rentCarMapperAJM.selectAllMember();

        sqlSession.close();

        return memberList;
    }

    public boolean registMember(MemberDTO member) {

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
    public boolean modifyMember(MemberDTO member) {

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

    public boolean deleteMember(MemberDTO member) {

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
