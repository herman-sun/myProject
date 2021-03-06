package com.shiro2.mapper;

import com.shiro2.entity.Tree;
import com.shiro2.entity.TreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreeMapper {
    List findByUid(Integer uid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int countByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int deleteByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int insert(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int insertSelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    List<Tree> selectByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    Tree selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int updateByExample(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int updateByPrimaryKeySelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Wed May 27 14:14:08 CST 2020
     */
    int updateByPrimaryKey(Tree record);
}