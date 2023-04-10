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
 * @Description: 供应商表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_supplier")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_supplier对象", description="供应商表")
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**单位名称*/
	@Excel(name = "单位名称", width = 15)
    @ApiModelProperty(value = "单位名称")
    private String companyName;
	/**纳税人识别号*/
	@Excel(name = "纳税人识别号", width = 15)
    @ApiModelProperty(value = "纳税人识别号")
    private String taxpayerNum;
	/**单位电话*/
	@Excel(name = "单位电话", width = 15)
    @ApiModelProperty(value = "单位电话")
    private String companyMobile;
	/**办公地址*/
	@Excel(name = "办公地址", width = 15)
    @ApiModelProperty(value = "办公地址")
    private String companyAddr;
	/**注册时间*/
	@Excel(name = "注册时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "注册时间")
    private Date registerTime;
	/**注册地址*/
	@Excel(name = "注册地址", width = 15)
    @ApiModelProperty(value = "注册地址")
    private String registerAddr;
	/**经济性质*/
	@Excel(name = "经济性质", width = 15)
    @ApiModelProperty(value = "经济性质")
    private String attribute;
	/**负责人姓名*/
	@Excel(name = "负责人姓名", width = 15)
    @ApiModelProperty(value = "负责人姓名")
    private String principalName;
	/**负责人电话*/
	@Excel(name = "负责人电话", width = 15)
    @ApiModelProperty(value = "负责人电话")
    private String principalMobile;
	/**经营主体类别*/
	@Excel(name = "经营主体类别", width = 15)
    @ApiModelProperty(value = "经营主体类别")
    private String sellSubject;
	/**税务规模*/
	@Excel(name = "税务规模", width = 15)
    @ApiModelProperty(value = "税务规模")
    private String taxationScale;
	/**开户行及账号  json数组*/
	@Excel(name = "开户行及账号  json数组", width = 15)
    @ApiModelProperty(value = "开户行及账号  json数组")
    private String bankAccount;
	/**主要销售货物*/
	@Excel(name = "主要销售货物", width = 15)
    @ApiModelProperty(value = "主要销售货物")
    private String marketGoods;
	/**税务诚信等级
            分年度*/
	@Excel(name = "税务诚信等级 分年度", width = 15)
    @ApiModelProperty(value = "税务诚信等级 分年度")
    private java.lang.String taxationCreditLevel;
	/**入库引进人*/
	@Excel(name = "入库引进人", width = 15)
    @ApiModelProperty(value = "入库引进人")
    private java.lang.String storageBringMan;
	/**场所勘察情况*/
	@Excel(name = "场所勘察情况", width = 15)
    @ApiModelProperty(value = "场所勘察情况")
    private java.lang.String siteState;
	/**负面及正面情况*/
	@Excel(name = "负面及正面情况", width = 15)
    @ApiModelProperty(value = "负面及正面情况")
    private java.lang.String evaluateState;
	/**其他信息*/
	@Excel(name = "其他信息", width = 15)
    @ApiModelProperty(value = "其他信息")
    private java.lang.String ortherInfo;
	/**附件*/
	@Excel(name = "附件", width = 15)
    @ApiModelProperty(value = "附件")
    private java.lang.String document;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
}
