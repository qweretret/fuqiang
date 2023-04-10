import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '班级名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '级',
    align:"center",
    dataIndex: 'grade'
   },
   {
    title: '系名',
    align:"center",
    dataIndex: 'dptnm_dictText'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remarks'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '班级名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '级',
    field: 'grade',
    component: 'Input',
  },
  {
    label: '系名',
    field: 'dptnm',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_dept,name,id"
     },
  },
  {
    label: '备注',
    field: 'remarks',
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
