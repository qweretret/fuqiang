import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '班级',
    align:"center",
    dataIndex: 'clzid_dictText'
   },
   {
    title: '姓名',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '电话号',
    align:"center",
    dataIndex: 'mobile'
   },
   {
    title: '密码',
    align:"center",
    dataIndex: 'paw'
   },
   {
    title: '身份证',
    align:"center",
    dataIndex: 'idcard'
   },
   {
    title: '实习企业',
    align:"center",
    dataIndex: 'ceid_dictText'
   },
   {
    title: '企业评价',
    align:"center",
    dataIndex: 'cpmEvaluation'
   },
   {
    title: '导师',
    align:"center",
    dataIndex: 'tid_dictText'
   },
   {
    title: '导师评价',
    align:"center",
    dataIndex: 'mentorEvaluation'
   },
   {
    title: '头像',
    align:"center",
    dataIndex: 'head',
    customRender:render.renderImage,
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remarks'
   },
   {
    title: '就业状态',
    align:"center",
    dataIndex: 'state_dictText'
   },
   {
    title: '微信uid',
    align:"center",
    dataIndex: 'wxappuid'
   },
   {
    title: '微信openid',
    align:"center",
    dataIndex: 'wxappopenid'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'sex_dictText'
   },
   {
    title: '籍贯',
    align:"center",
    dataIndex: 'nativeplace'
   },
   {
    title: '住址',
    align:"center",
    dataIndex: 'adress'
   },
   {
    title: '邮箱',
    align:"center",
    dataIndex: 'email'
   },
   {
    title: '紧急联系人关系',
    align:"center",
    dataIndex: 'relationship'
   },
   {
    title: '紧急联系人',
    align:"center",
    dataIndex: 'rname'
   },
   {
    title: '紧急联系人电话',
    align:"center",
    dataIndex: 'rphone'
   },
   {
    title: '账号是否可用',
    align:"center",
    dataIndex: 'isdisable_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '班级',
    field: 'clzid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_clazz,name,id"
     },
  },
  {
    label: '姓名',
    field: 'name',
    component: 'Input',
  },
  {
    label: '电话号',
    field: 'mobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^1[3456789]\d{9}$/, message: '请输入正确的手机号码!'},
          ];
     },
  },
  {
    label: '密码',
    field: 'paw',
    component: 'InputPassword',
  },
  {
    label: '身份证',
    field: 'idcard',
    component: 'Input',
  },
  {
    label: '实习企业',
    field: 'ceid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_practicecmp,name,id"
     },
  },
  {
    label: '企业评价',
    field: 'cpmEvaluation',
    component: 'InputTextArea',
  },
  {
    label: '导师',
    field: 'tid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sys_user,realname,id"
     },
  },
  {
    label: '导师评价',
    field: 'mentorEvaluation',
    component: 'InputTextArea',
  },
  {
    label: '头像',
    field: 'head',
     component: 'JImageUpload',
     componentProps:{
      },
  },
  {
    label: '备注',
    field: 'remarks',
    component: 'Input',
  },
  {
    label: '就业状态',
    field: 'state',
    defaultValue: "在家待业",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_static_stu"
     },
  },
  {
    label: '微信uid',
    field: 'wxappuid',
    component: 'Input',
  },
  {
    label: '微信openid',
    field: 'wxappopenid',
    component: 'Input',
  },
  {
    label: '性别',
    field: 'sex',
    defaultValue: "男",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"sex"
     },
  },
  {
    label: '籍贯',
    field: 'nativeplace',
    component: 'Input',
  },
  {
    label: '住址',
    field: 'adress',
    component: 'Input',
  },
  {
    label: '邮箱',
    field: 'email',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^([\w]+\.*)([\w]+)@[\w]+\.\w{3}(\.\w{2}|)$/, message: '请输入正确的电子邮件!'},
          ];
     },
  },
  {
    label: '紧急联系人关系',
    field: 'relationship',
    component: 'Input',
  },
  {
    label: '紧急联系人',
    field: 'rname',
    component: 'Input',
  },
  {
    label: '紧急联系人电话',
    field: 'rphone',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^1[3456789]\d{9}$/, message: '请输入正确的手机号码!'},
          ];
     },
  },
  {
    label: '账号是否可用',
    field: 'isdisable',
    defaultValue: "正常",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"status"
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
