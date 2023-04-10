import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '单位',
    align:"center",
    dataIndex: 'unit'
   },
   {
    title: '税率',
    align:"center",
    dataIndex: 'taxRate'
   },
   {
    title: '不含税价',
    align:"center",
    dataIndex: 'excludeTax'
   },
   {
    title: '含税价',
    align:"center",
    dataIndex: 'includeTax'
   },
   {
    title: '区域',
    align:"center",
    dataIndex: 'area'
   },
   {
    title: '供应商',
    align:"center",
    dataIndex: 'supplierId'
   },
   {
    title: '数据来源',
    align:"center",
    dataIndex: 'dataSoure'
   },
   {
    title: '检查日期',
    align:"center",
    dataIndex: 'checkDate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '采购日期',
    align:"center",
    dataIndex: 'purcherDate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '标准or内容',
    align:"center",
    dataIndex: 'content'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark'
   },
   {
    title: '走势',
    align:"center",
    dataIndex: 'trend'
   },
   {
    title: '材料类型',
    align:"center",
    dataIndex: 'typeId'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '单位',
    field: 'unit',
    component: 'Input',
  },
  {
    label: '税率',
    field: 'taxRate',
    component: 'InputNumber',
  },
  {
    label: '不含税价',
    field: 'excludeTax',
    component: 'InputNumber',
  },
  {
    label: '含税价',
    field: 'includeTax',
    component: 'InputNumber',
  },
  {
    label: '区域',
    field: 'area',
    component: 'Input',
  },
  {
    label: '供应商',
    field: 'supplierId',
    component: 'Input',
  },
  {
    label: '数据来源',
    field: 'dataSoure',
    component: 'Input',
  },
  {
    label: '检查日期',
    field: 'checkDate',
    component: 'DatePicker',
  },
  {
    label: '采购日期',
    field: 'purcherDate',
    component: 'DatePicker',
  },
  {
    label: '标准or内容',
    field: 'content',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'remark',
    component: 'Input',
  },
  {
    label: '走势',
    field: 'trend',
    component: 'Input',
  },
  {
    label: '材料类型',
    field: 'typeId',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
