import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'employeeId',
    align:"center",
    dataIndex: 'employeeId'
   },
   {
    title: '等级',
    align:"center",
    dataIndex: 'level'
   },
   {
    title: '专业',
    align:"center",
    dataIndex: 'major'
   },
   {
    title: '发证机关',
    align:"center",
    dataIndex: 'institution'
   },
   {
    title: '注册日期/发证日期',
    align:"center",
    dataIndex: 'start',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '有效期止',
    align:"center",
    dataIndex: 'end',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '附件',
    align:"center",
    dataIndex: 'document'
   },
   {
    title: '是否网查',
    align:"center",
    dataIndex: 'isSearch'
   },
   {
    title: '有无评审表',
    align:"center",
    dataIndex: 'hasReview'
   },
   {
    title: '类别',
    align:"center",
    dataIndex: 'type'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'employeeId',
    field: 'employeeId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入employeeId!'},
          ];
     },
  },
  {
    label: '等级',
    field: 'level',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入等级!'},
          ];
     },
  },
  {
    label: '专业',
    field: 'major',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入专业!'},
          ];
     },
  },
  {
    label: '发证机关',
    field: 'institution',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发证机关!'},
          ];
     },
  },
  {
    label: '注册日期/发证日期',
    field: 'start',
    component: 'DatePicker',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入注册日期/发证日期!'},
          ];
     },
  },
  {
    label: '有效期止',
    field: 'end',
    component: 'DatePicker',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入有效期止!'},
          ];
     },
  },
  {
    label: '附件',
    field: 'document',
    component: 'Input',
  },
  {
    label: '是否网查',
    field: 'isSearch',
    component: 'Input',
  },
  {
    label: '有无评审表',
    field: 'hasReview',
    component: 'Input',
  },
  {
    label: '类别',
    field: 'type',
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
