package org.jeecg.modules.system.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 实习生基本信息表
 * @Author: jeecg-boot
 * @Date:   2022-09-14
 * @Version: V1.0
 */
@Data
@TableName("job_stu")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="job_stu对象", description="实习生基本信息表")
public class JobStu implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**班级id*/
	@Excel(name = "班级id", width = 15, dictTable = "job_clazz", dicText = "name", dicCode = "id")
	@Dict(dictTable = "job_clazz", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "班级id")
    private java.lang.String clzid;
	/**姓名*/
	@Excel(name = "姓名", width = 15)
    @ApiModelProperty(value = "姓名")
    private java.lang.String name;
	/**电话号*/
	@Excel(name = "电话号", width = 15)
    @ApiModelProperty(value = "电话号")
    private java.lang.String mobile;
	/**密码*/
	@Excel(name = "密码", width = 15)
    @ApiModelProperty(value = "密码")
    private java.lang.String paw;
	/**身份证*/
	@Excel(name = "身份证", width = 15)
    @ApiModelProperty(value = "身份证")
    private java.lang.String idcard;
	/**实习企业id*/
	@Excel(name = "实习企业id", width = 15, dictTable = "job_practicecmp", dicText = "name", dicCode = "id")
	@Dict(dictTable = "job_practicecmp", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "实习企业id")
    private java.lang.String ceid;
	/**企业评价*/
	@Excel(name = "企业评价", width = 15)
    @ApiModelProperty(value = "企业评价")
    private java.lang.String cpmEvaluation;
	/**导师tid*/
	@Excel(name = "导师tid", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "id")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "id")
    @ApiModelProperty(value = "导师tid")
    private java.lang.String tid;
	/**导师评价*/
	@Excel(name = "导师评价", width = 15)
    @ApiModelProperty(value = "导师评价")
    private java.lang.String mentorEvaluation;
	/**头像*/
	@Excel(name = "头像", width = 15)
    @ApiModelProperty(value = "头像")
    private java.lang.String head;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remarks;
	/**状态-在家待业-实习-服兵役*/
	@Excel(name = "状态-在家待业-实习-服兵役", width = 15, dicCode = "job_static_stu")
	@Dict(dicCode = "job_static_stu")
    @ApiModelProperty(value = "状态-在家待业-实习-服兵役")
    private java.lang.String state;
	/**微信uid*/
	@Excel(name = "微信uid", width = 15)
    @ApiModelProperty(value = "微信uid")
    private java.lang.String wxappuid;
	/**微信openid*/
	@Excel(name = "微信openid", width = 15)
    @ApiModelProperty(value = "微信openid")
    private java.lang.String wxappopenid;
	/**性别*/
	@Excel(name = "性别", width = 15, dicCode = "sex")
	@Dict(dicCode = "sex")
    @ApiModelProperty(value = "性别")
    private java.lang.String sex;
	/**籍贯*/
	@Excel(name = "籍贯", width = 15)
    @ApiModelProperty(value = "籍贯")
    private java.lang.String nativeplace;
	/**住址*/
	@Excel(name = "住址", width = 15)
    @ApiModelProperty(value = "住址")
    private java.lang.String adress;
	/**邮箱*/
	@Excel(name = "邮箱", width = 15)
    @ApiModelProperty(value = "邮箱")
    private java.lang.String email;
	/**紧急联系人关系*/
	@Excel(name = "紧急联系人关系", width = 15)
    @ApiModelProperty(value = "紧急联系人关系")
    private java.lang.String relationship;
	/**紧急联系人*/
	@Excel(name = "紧急联系人", width = 15)
    @ApiModelProperty(value = "紧急联系人")
    private java.lang.String rname;
	/**紧急联系人电话*/
	@Excel(name = "紧急联系人电话", width = 15)
    @ApiModelProperty(value = "紧急联系人电话")
    private java.lang.String rphone;
	/**账号是否可用*/
	@Excel(name = "账号是否可用", width = 15, dicCode = "status")
	@Dict(dicCode = "status")
    @ApiModelProperty(value = "账号是否可用")
    private java.lang.String isdisable;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
}
