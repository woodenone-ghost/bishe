package zhangjie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhangjie.model.UserInformation;
import zhangjie.model.UserInformationExample;

public interface UserInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    long countByExample(UserInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int deleteByExample(UserInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int deleteByPrimaryKey(String account);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int insert(UserInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int insertSelective(UserInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    List<UserInformation> selectByExample(UserInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    UserInformation selectByPrimaryKey(String account);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserInformation record, @Param("example") UserInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int updateByExample(@Param("record") UserInformation record, @Param("example") UserInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int updateByPrimaryKeySelective(UserInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated Mon Feb 18 14:03:23 CST 2019
     */
    int updateByPrimaryKey(UserInformation record);
}