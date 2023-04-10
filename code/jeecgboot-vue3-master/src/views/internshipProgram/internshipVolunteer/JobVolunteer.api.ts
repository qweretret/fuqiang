import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";
import {onMounted} from 'vue';
const { createConfirm } = useMessage();

enum Api {
  list = '/jobVolunteer/jobVolunteer/list',
  save='/jobVolunteer/jobVolunteer/add',
  edit='/jobVolunteer/jobVolunteer/edit',
  deleteOne = '/jobVolunteer/jobVolunteer/delete',
  deleteBatch = '/jobVolunteer/jobVolunteer/deleteBatch',
  importExcel = '/jobVolunteer/jobVolunteer/importExcel',
  exportXls = '/jobVolunteer/jobVolunteer/exportXls',
  //查询企业下的岗位
  getjobCase = '/jobVolunteer/jobVolunteer/getjobCase',
}
/**
 * 导出api
 * @param params
 */
export const getExportUrl = Api.exportXls;
/**
 * 导入api
 */
export const getImportUrl = Api.importExcel;
/**
 * 列表接口
 * @param params
 */
export const list = (params) =>
  defHttp.get({url: Api.list, params});

/**
 * 删除单个
 */
export const deleteOne = (params,handleSuccess) => {
  return defHttp.delete({url: Api.deleteOne, params}, {joinParamsToUrl: true}).then(() => {
    handleSuccess();
  });
}
/**
 * 批量删除
 * @param params
 */
export const batchDelete = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({url: Api.deleteBatch, data: params}, {joinParamsToUrl: true}).then(() => {
        handleSuccess();
      });
    }
  });
}
/**
 * 保存或者更新
 * @param params
 */
export const saveOrUpdate = (params, isUpdate) => {
  let url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({url: url, params});
}

/**
 * 查询选择企业后显示该企业下的岗位
 */
 export const getjobCase = (params) =>
 defHttp.get({url: Api.getjobCase, params});