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
 * @Description: 班级表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Data
@TableName("job_clazz")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="job_clazz对象", description="班级表")
public class JobClazz implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**班级名称*/
	@Excel(name = "班级名称", width = 15)
    @ApiModelProperty(value = "班级名称")
    private java.lang.String name;
	/**级*/
	@Excel(name = "级", width = 15)
    @ApiModelProperty(value = "级")
    private java.lang.String grade;
	/**系名*/
	@Excel(name = "系名", width = 15, dictTable = "job_dept", dicText = "name", dicCode = "id")
	@Dict(dictTable = "job_dept", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "系名")
    private java.lang.String dptnm;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remarks;
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
