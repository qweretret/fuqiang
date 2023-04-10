package org.jeecg.fuqiang.team2.entity;

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
 * @Description: 项目表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_project")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_project对象", description="项目表")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**name*/
	@Excel(name = "name", width = 15)
    @ApiModelProperty(value = "name")
    private String name;
	/**负责人*/
	@Excel(name = "负责人", width = 15)
    @ApiModelProperty(value = "负责人")
    private String principal;
	/**负责人电话*/
	@Excel(name = "负责人电话", width = 15)
    @ApiModelProperty(value = "负责人电话")
    private String principalMobile;
	/**类型*/
	@Excel(name = "类型", width = 15)
    @ApiModelProperty(value = "类型")
    private String kind;
	/**项目类别*/
	@Excel(name = "项目类别", width = 15)
    @ApiModelProperty(value = "项目类别")
    private String type;
	/**项目描述*/
	@Excel(name = "项目描述", width = 15)
    @ApiModelProperty(value = "项目描述")
    private String description;
	/**合同价*/
	@Excel(name = "合同价", width = 15)
    @ApiModelProperty(value = "合同价")
    private BigDecimal contractPrice;
	/**结算价*/
	@Excel(name = "结算价", width = 15)
    @ApiModelProperty(value = "结算价")
    private BigDecimal lastPrice;
	/**变更价*/
	@Excel(name = "变更价", width = 15)
    @ApiModelProperty(value = "变更价")
    private BigDecimal changePrice;
	/**开工日期*/
	@Excel(name = "开工日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "开工日期")
    private Date start;
	/**竣工日期 如果为空，则仍然在建*/
	@Excel(name = "竣工日期 如果为空，则仍然在建", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "竣工日期 如果为空，则仍然在建")
    private Date end;
	/**中标日期*/
	@Excel(name = "中标日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "中标日期")
    private Date gainDate;
	/**合同日期*/
	@Excel(name = "合同日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "合同日期")
    private Date contractDate;
	/**岗位人员*/
	@Excel(name = "岗位人员", width = 15)
    @ApiModelProperty(value = "岗位人员")
    private String postEmployee;
	/**区域*/
	@Excel(name = "区域", width = 15)
    @ApiModelProperty(value = "区域")
    private String area;
	/**资料完成情况*/
	@Excel(name = "资料完成情况", width = 15)
    @ApiModelProperty(value = "资料完成情况")
    private String dataProgress;
	/**入库情况*/
	@Excel(name = "入库情况", width = 15)
    @ApiModelProperty(value = "入库情况")
    private String storageState;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String remark;
	/**附件*/
	@Excel(name = "附件", width = 15)
    @ApiModelProperty(value = "附件")
    private String document;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
