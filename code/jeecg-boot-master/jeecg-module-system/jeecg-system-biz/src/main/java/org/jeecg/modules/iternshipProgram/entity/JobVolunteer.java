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
 * @Description: 实习志愿表
 * @Author: jeecg-boot
 * @Date:   2022-09-19
 * @Version: V1.0
 */
@Data
@TableName("job_volunteer")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="job_volunteer对象", description="实习志愿表")
public class JobVolunteer implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**学生*/
	@Excel(name = "学生", width = 15, dictTable = "job_stu", dicText = "name", dicCode = "id")
	@Dict(dictTable = "job_stu", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "学生")
    private java.lang.String stuid;
	/**企业*/
	@Excel(name = "企业", width = 15, dictTable = "job_practicecmp", dicText = "name", dicCode = "id")
	@Dict(dictTable = "job_practicecmp", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "企业")
    private java.lang.String enterpriseid;
	/**实习岗位*/
	@Excel(name = "实习岗位", width = 15,dictTable = "job_case", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "实习岗位")
    @Dict(dictTable = "job_case", dicText = "name", dicCode = "id")
    private java.lang.String jobName;
	/**理由*/
	@Excel(name = "理由", width = 15)
    @ApiModelProperty(value = "理由")
    private java.lang.String reason;
	/**是否就业*/
	@Excel(name = "是否就业", width = 15, dicCode = "job_employment")
	@Dict(dicCode = "job_employment")
    @ApiModelProperty(value = "是否就业")
    private java.lang.Integer employment;
	/**是否指导*/
	@Excel(name = "是否指导", width = 15, dicCode = "job_guidance")
	@Dict(dicCode = "job_guidance")
    @ApiModelProperty(value = "是否指导")
    private java.lang.Integer guidance;
	/**班主任意见*/
	@Excel(name = "班主任意见", width = 15)
    @ApiModelProperty(value = "班主任意见")
    private java.lang.String teacherOpinion;
	/**同意状态*/
	@Excel(name = "同意状态", width = 15, dicCode = "job_consent")
	@Dict(dicCode = "job_consent")
    @ApiModelProperty(value = "同意状态")
    private java.lang.Integer state;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String note;
	/**系级指导*/
	@Excel(name = "系级指导", width = 15)
    @ApiModelProperty(value = "系级指导")
    private java.lang.String departmentOpinion;
	/**条款*/
	@Excel(name = "条款", width = 15)
    @ApiModelProperty(value = "条款")
    private java.lang.String clause;
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
