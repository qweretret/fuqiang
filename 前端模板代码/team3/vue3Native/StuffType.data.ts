import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: 'name',
    align: "center",
    dataIndex: 'name'
  },
  {
    title: '编号',
    align: "center",
    dataIndex: 'code'
  },
  {
    title: '等级',
    align: "center",
    dataIndex: 'level'
  },
  {
    title: '排序',
    align: "center",
    dataIndex: 'sort'
  },
  {
    title: '父id',
    align: "center",
    dataIndex: 'pid'
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
  },
  {
    label: '编号',
    field: 'code',
    component: 'Input',
  },
  {
    label: '等级',
    field: 'level',
    component: 'Input',
  },
  {
    label: '排序',
    field: 'sort',
    component: 'Input',
  },
  {
    label: '父id',
    field: 'pid',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];
