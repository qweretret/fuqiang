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
    title: '负责人',
    align:"center",
    dataIndex: 'principal'
   },
   {
    title: '负责人电话',
    align:"center",
    dataIndex: 'principalMobile'
   },
   {
    title: '类型',
    align:"center",
    dataIndex: 'kind'
   },
   {
    title: '项目类别',
    align:"center",
    dataIndex: 'type'
   },
   {
    title: '项目描述',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '合同价',
    align:"center",
    dataIndex: 'contractPrice'
   },
   {
    title: '结算价',
    align:"center",
    dataIndex: 'lastPrice'
   },
   {
    title: '变更价',
    align:"center",
    dataIndex: 'changePrice'
   },
   {
    title: '开工日期',
    align:"center",
    dataIndex: 'start',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '竣工日期 如果为空，则仍然在建',
    align:"center",
    dataIndex: 'end',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '中标日期',
    align:"center",
    dataIndex: 'gainDate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '合同日期',
    align:"center",
    dataIndex: 'contractDate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '岗位人员',
    align:"center",
    dataIndex: 'postEmployee'
   },
   {
    title: '区域',
    align:"center",
    dataIndex: 'area'
   },
   {
    title: '资料完成情况',
    align:"center",
    dataIndex: 'dataProgress'
   },
   {
    title: '入库情况',
    align:"center",
    dataIndex: 'storageState'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark'
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
    label: '负责人',
    field: 'principal',
    component: 'Input',
  },
  {
    label: '负责人电话',
    field: 'principalMobile',
    component: 'Input',
  },
  {
    label: '类型',
    field: 'kind',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入类型!'},
          ];
     },
  },
  {
    label: '项目类别',
    field: 'type',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目类别!'},
          ];
     },
  },
  {
    label: '项目描述',
    field: 'description',
    component: 'Input',
  },
  {
    label: '合同价',
    field: 'contractPrice',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入合同价!'},
          ];
     },
  },
  {
    label: '结算价',
    field: 'lastPrice',
    component: 'InputNumber',
  },
  {
    label: '变更价',
    field: 'changePrice',
    component: 'InputNumber',
  },
  {
    label: '开工日期',
    field: 'start',
    component: 'DatePicker',
  },
  {
    label: '竣工日期 如果为空，则仍然在建',
    field: 'end',
    component: 'DatePicker',
  },
  {
    label: '中标日期',
    field: 'gainDate',
    component: 'DatePicker',
  },
  {
    label: '合同日期',
    field: 'contractDate',
    component: 'DatePicker',
  },
  {
    label: '岗位人员',
    field: 'postEmployee',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入岗位人员!'},
          ];
     },
  },
  {
    label: '区域',
    field: 'area',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入区域!'},
          ];
     },
  },
  {
    label: '资料完成情况',
    field: 'dataProgress',
    component: 'Input',
  },
  {
    label: '入库情况',
    field: 'storageState',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入入库情况!'},
          ];
     },
  },
  {
    label: '备注',
    field: 'remark',
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
