package org.jeecg.modules.iternshipProgram.entity;

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
 * @Description: 实习方案表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Data
@TableName("job_case")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="job_case对象", description="实习方案表")
public class JobCase implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**企业id*/
	@Excel(name = "企业id", width = 15, dictTable = "job_practicecmp", dicText = "name", dicCode = "id")
	@Dict(dictTable = "job_practicecmp", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "企业id")
    private java.lang.String company;
	/**岗位名称*/
	@Excel(name = "岗位名称", width = 15)
    @ApiModelProperty(value = "岗位名称")
    private java.lang.String name;
	/**招聘人数*/
	@Excel(name = "招聘人数", width = 15)
    @ApiModelProperty(value = "招聘人数")
    private java.lang.String maxneed;
	/**经验*/
	@Excel(name = "经验", width = 15)
    @ApiModelProperty(value = "经验")
    private java.lang.String exps;
	/**学历*/
	@Excel(name = "学历", width = 15, dicCode = "job_case_xueli")
	@Dict(dicCode = "job_case_xueli")
    @ApiModelProperty(value = "学历")
    private java.lang.String xueli;
	/**待遇*/
	@Excel(name = "待遇", width = 15)
    @ApiModelProperty(value = "待遇")
    private java.lang.String sarry;
	/**技术要求*/
	@Excel(name = "技术要求", width = 15)
    @ApiModelProperty(value = "技术要求")
    private java.lang.String tech;
	/**工作内容*/
	@Excel(name = "工作内容", width = 15)
    @ApiModelProperty(value = "工作内容")
    private java.lang.String content;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
	/**开始时间*/
	@Excel(name = "开始时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间")
    private java.util.Date bgntm;
	/**结束时间*/
	@Excel(name = "结束时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    private java.util.Date endtm;
	/**要求实习的时间*/
	@Excel(name = "要求实习的时间", width = 15)
    @ApiModelProperty(value = "要求实习的时间")
    private java.lang.String internshipDay;
	/**实习单位资质评审*/
	@Excel(name = "实习单位资质评审", width = 15, dicCode = "job_case_qroiu")
	@Dict(dicCode = "job_case_qroiu")
    @ApiModelProperty(value = "实习单位资质评审")
    private java.lang.String qroiu;
	/**审查人*/
	@Excel(name = "审查人", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "id")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "id")
    @ApiModelProperty(value = "审查人")
    private java.lang.String reviewer;
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
