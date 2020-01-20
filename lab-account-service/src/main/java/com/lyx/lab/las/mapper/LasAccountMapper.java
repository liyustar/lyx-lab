package com.lyx.lab.las.mapper;

import com.lyx.lab.las.model.LasAccount;
import com.lyx.lab.las.model.LasAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LasAccountMapper {
    long countByExample(LasAccountExample example);

    int deleteByExample(LasAccountExample example);

    int deleteByPrimaryKey(String accCode);

    int insert(LasAccount record);

    int insertSelective(LasAccount record);

    List<LasAccount> selectByExample(LasAccountExample example);

    LasAccount selectByPrimaryKey(String accCode);

    int updateByExampleSelective(@Param("record") LasAccount record, @Param("example") LasAccountExample example);

    int updateByExample(@Param("record") LasAccount record, @Param("example") LasAccountExample example);

    int updateByPrimaryKeySelective(LasAccount record);

    int updateByPrimaryKey(LasAccount record);
}