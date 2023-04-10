import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业id',
    align:"center",
    dataIndex: 'company_dictText'
   },
   {
    title: '岗位名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '招聘人数',
    align:"center",
    dataIndex: 'maxneed'
   },
   {
    title: '经验',
    align:"center",
    dataIndex: 'exps'
   },
   {
    title: '学历',
    align:"center",
    dataIndex: 'xueli_dictText'
   },
   {
    title: '待遇',
    align:"center",
    dataIndex: 'sarry'
   },
   {
    title: '技术要求',
    align:"center",
    dataIndex: 'tech'
   },
   {
    title: '工作内容',
    align:"center",
    dataIndex: 'content'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark',
    helpMessage: ['这是简单的提示'],
   },
   {
    title: '开始时间',
    align:"center",
    dataIndex: 'bgntm',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '结束时间',
    align:"center",
    dataIndex: 'endtm',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '要求实习的时间',
    align:"center",
    dataIndex: 'internshipDay'
   },
   {
    title: '实习单位资质评审',
    align:"center",
    dataIndex: 'qroiu_dictText'
   },
   {
    title: '审查人',
    align:"center",
    dataIndex: 'reviewer_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业id',
    field: 'company',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_practicecmp,name,id"
     },
  },
  {
    label: '岗位名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '招聘人数',
    field: 'maxneed',
    component: 'Input',
  },
  {
    label: '经验',
    field: 'exps',
    component: 'Input',
  },
  {
    label: '学历',
    field: 'xueli',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_case_xueli"
     },
  },
  {
    label: '待遇',
    field: 'sarry',
    component: 'Input',
  },
  {
    label: '技术要求',
    field: 'tech',
    component: 'Input',
  },
  {
    label: '工作内容',
    field: 'content',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'remark',
    component: 'Input',

  },
  {
    label: '开始时间',
    field: 'bgntm',
    component: 'DatePicker',
  },
  {
    label: '结束时间',
    field: 'endtm',
    component: 'DatePicker',
  },
  {
    label: '要求实习的时间',
    field: 'internshipDay',
    component: 'Input',
  },
  {
    label: '实习单位资质评审',
    field: 'qroiu',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_case_qroiu"
     },
  },
  {
    label: '审查人',
    field: 'reviewer',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_user,realname,id"
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
