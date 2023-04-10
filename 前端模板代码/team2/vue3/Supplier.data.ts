import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '单位名称',
    align:"center",
    dataIndex: 'companyName'
   },
   {
    title: '纳税人识别号',
    align:"center",
    dataIndex: 'taxpayerNum'
   },
   {
    title: '单位电话',
    align:"center",
    dataIndex: 'companyMobile'
   },
   {
    title: '办公地址',
    align:"center",
    dataIndex: 'companyAddr'
   },
   {
    title: '注册时间',
    align:"center",
    dataIndex: 'registerTime',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '注册地址',
    align:"center",
    dataIndex: 'registerAddr'
   },
   {
    title: '经济性质',
    align:"center",
    dataIndex: 'attribute'
   },
   {
    title: '负责人姓名',
    align:"center",
    dataIndex: 'principalName'
   },
   {
    title: '负责人电话',
    align:"center",
    dataIndex: 'principalMobile'
   },
   {
    title: '经营主体类别',
    align:"center",
    dataIndex: 'sellSubject'
   },
   {
    title: '税务规模',
    align:"center",
    dataIndex: 'taxationScale'
   },
   {
    title: '开户行及账号  json数组',
    align:"center",
    dataIndex: 'bankAccount'
   },
   {
    title: '主要销售货物',
    align:"center",
    dataIndex: 'marketGoods'
   },
   {
    title: '税务诚信等级
            分年度',
    align:"center",
    dataIndex: 'taxationCreditLevel'
   },
   {
    title: '入库引进人',
    align:"center",
    dataIndex: 'storageBringMan'
   },
   {
    title: '场所勘察情况',
    align:"center",
    dataIndex: 'siteState'
   },
   {
    title: '负面及正面情况',
    align:"center",
    dataIndex: 'evaluateState'
   },
   {
    title: '其他信息',
    align:"center",
    dataIndex: 'ortherInfo'
   },
   {
    title: '附件',
    align:"center",
    dataIndex: 'document'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '单位名称',
    field: 'companyName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入单位名称!'},
          ];
     },
  },
  {
    label: '纳税人识别号',
    field: 'taxpayerNum',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入纳税人识别号!'},
          ];
     },
  },
  {
    label: '单位电话',
    field: 'companyMobile',
    component: 'Input',
  },
  {
    label: '办公地址',
    field: 'companyAddr',
    component: 'Input',
  },
  {
    label: '注册时间',
    field: 'registerTime',
    component: 'DatePicker',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入注册时间!'},
          ];
     },
  },
  {
    label: '注册地址',
    field: 'registerAddr',
    component: 'Input',
  },
  {
    label: '经济性质',
    field: 'attribute',
    component: 'Input',
  },
  {
    label: '负责人姓名',
    field: 'principalName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入负责人姓名!'},
          ];
     },
  },
  {
    label: '负责人电话',
    field: 'principalMobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入负责人电话!'},
          ];
     },
  },
  {
    label: '经营主体类别',
    field: 'sellSubject',
    component: 'Input',
  },
  {
    label: '税务规模',
    field: 'taxationScale',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入税务规模!'},
          ];
     },
  },
  {
    label: '开户行及账号  json数组',
    field: 'bankAccount',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入开户行及账号  json数组!'},
          ];
     },
  },
  {
    label: '主要销售货物',
    field: 'marketGoods',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入主要销售货物!'},
          ];
     },
  },
  {
    label: '税务诚信等级
            分年度',
    field: 'taxationCreditLevel',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入税务诚信等级
            分年度!'},
          ];
     },
  },
  {
    label: '入库引进人',
    field: 'storageBringMan',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入入库引进人!'},
          ];
     },
  },
  {
    label: '场所勘察情况',
    field: 'siteState',
    component: 'Input',
  },
  {
    label: '负面及正面情况',
    field: 'evaluateState',
    component: 'Input',
  },
  {
    label: '其他信息',
    field: 'ortherInfo',
    component: 'Input',
  },
  {
    label: '附件',
    field: 'document',
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
