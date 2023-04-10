import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'name',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: 'gender',
    align:"center",
    dataIndex: 'gender'
   },
   {
    title: 'mobile',
    align:"center",
    dataIndex: 'mobile'
   },
   {
    title: '身份证号码',
    align:"center",
    dataIndex: 'idCard'
   },
   {
    title: '身份证地址',
    align:"center",
    dataIndex: 'idCardAddr'
   },
   {
    title: '常住地',
    align:"center",
    dataIndex: 'permanentAddr'
   },
   {
    title: '有无犯罪记录、失信记录',
    align:"center",
    dataIndex: 'hasIllegal'
   },
   {
    title: '诚信情况',
    align:"center",
    dataIndex: 'creditState'
   },
   {
    title: '擅长专业',
    align:"center",
    dataIndex: 'adeptMajor'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'name',
    field: 'name',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入name!'},
          ];
     },
  },
  {
    label: 'gender',
    field: 'gender',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入gender!'},
          ];
     },
  },
  {
    label: 'mobile',
    field: 'mobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入mobile!'},
          ];
     },
  },
  {
    label: '身份证号码',
    field: 'idCard',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入身份证号码!'},
          ];
     },
  },
  {
    label: '身份证地址',
    field: 'idCardAddr',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入身份证地址!'},
          ];
     },
  },
  {
    label: '常住地',
    field: 'permanentAddr',
    component: 'Input',
  },
  {
    label: '有无犯罪记录、失信记录',
    field: 'hasIllegal',
    component: 'Input',
  },
  {
    label: '诚信情况',
    field: 'creditState',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入诚信情况!'},
          ];
     },
  },
  {
    label: '擅长专业',
    field: 'adeptMajor',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入擅长专业!'},
          ];
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
