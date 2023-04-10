<template>
  <a-spin :spinning="confirmLoading">
    <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol">
      <a-row>
        <a-col :span="24">
          <a-form-item label="name" v-bind="validateInfos.name">
            <a-input v-model:value="formData.name" placeholder="请输入name" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="负责人" v-bind="validateInfos.principal">
            <a-input v-model:value="formData.principal" placeholder="请输入负责人" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="负责人电话" v-bind="validateInfos.principalMobile">
            <a-input v-model:value="formData.principalMobile" placeholder="请输入负责人电话" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="类型" v-bind="validateInfos.kind">
            <a-input v-model:value="formData.kind" placeholder="请输入类型" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="项目类别" v-bind="validateInfos.type">
            <a-input v-model:value="formData.type" placeholder="请输入项目类别" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="项目描述" v-bind="validateInfos.description">
            <a-input v-model:value="formData.description" placeholder="请输入项目描述" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="合同价" v-bind="validateInfos.contractPrice">
	          <a-input-number v-model:value="formData.contractPrice" placeholder="请输入合同价" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="结算价" v-bind="validateInfos.lastPrice">
	          <a-input-number v-model:value="formData.lastPrice" placeholder="请输入结算价" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="变更价" v-bind="validateInfos.changePrice">
	          <a-input-number v-model:value="formData.changePrice" placeholder="请输入变更价" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="开工日期" v-bind="validateInfos.start">
		        <a-date-picker placeholder="请选择开工日期" v-model:value="formData.start" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="竣工日期 如果为空，则仍然在建" v-bind="validateInfos.end">
		        <a-date-picker placeholder="请选择竣工日期 如果为空，则仍然在建" v-model:value="formData.end" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="中标日期" v-bind="validateInfos.gainDate">
		        <a-date-picker placeholder="请选择中标日期" v-model:value="formData.gainDate" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="合同日期" v-bind="validateInfos.contractDate">
		        <a-date-picker placeholder="请选择合同日期" v-model:value="formData.contractDate" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="岗位人员" v-bind="validateInfos.postEmployee">
            <a-input v-model:value="formData.postEmployee" placeholder="请输入岗位人员" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="区域" v-bind="validateInfos.area">
            <a-input v-model:value="formData.area" placeholder="请输入区域" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="资料完成情况" v-bind="validateInfos.dataProgress">
            <a-input v-model:value="formData.dataProgress" placeholder="请输入资料完成情况" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="入库情况" v-bind="validateInfos.storageState">
            <a-input v-model:value="formData.storageState" placeholder="请输入入库情况" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="备注" v-bind="validateInfos.remark">
            <a-input v-model:value="formData.remark" placeholder="请输入备注" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="附件" v-bind="validateInfos.document">
            <a-input v-model:value="formData.document" placeholder="请输入附件" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref, reactive, defineExpose, nextTick, defineProps, computed } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useMessage } from '/@/hooks/web/useMessage';
  import moment from 'moment';
  import { getValueType } from '/@/utils';
  import { saveOrUpdate } from '../Project.api';
  import { Form } from 'ant-design-vue';
  
  const props = defineProps({
    disabled: { type: Boolean, default: false },
  });
  const formRef = ref();
  const useForm = Form.useForm;
  const emit = defineEmits(['register', 'ok']);
  const formData = reactive<Record<string, any>>({
    id: '',
    name: '',   
    id: '',
    principal: '',   
    id: '',
    principalMobile: '',   
    id: '',
    kind: '',   
    id: '',
    type: '',   
    id: '',
    description: '',   
    id: '',
    contractPrice: undefined,
    id: '',
    lastPrice: undefined,
    id: '',
    changePrice: undefined,
    id: '',
    start: '',   
    id: '',
    end: '',   
    id: '',
    gainDate: '',   
    id: '',
    contractDate: '',   
    id: '',
    postEmployee: '',   
    id: '',
    area: '',   
    id: '',
    dataProgress: '',   
    id: '',
    storageState: '',   
    id: '',
    remark: '',   
    id: '',
    document: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = {
    name: [{ required: true, message: '请输入name!'},],
    kind: [{ required: true, message: '请输入类型!'},],
    type: [{ required: true, message: '请输入项目类别!'},],
    contractPrice: [{ required: true, message: '请输入合同价!'},],
    postEmployee: [{ required: true, message: '请输入岗位人员!'},],
    area: [{ required: true, message: '请输入区域!'},],
    storageState: [{ required: true, message: '请输入入库情况!'},],
  };
  const { resetFields, validate, validateInfos } = useForm(formData, validatorRules, { immediate: true });
  
  /**
   * 新增
   */
  function add() {
    edit({});
  }

  /**
   * 编辑
   */
  function edit(record) {
    nextTick(() => {
      resetFields();
      //赋值
      Object.assign(formData, record);
    });
  }

  /**
   * 提交数据
   */
  async function submitForm() {
    // 触发表单验证
    await validate();
    confirmLoading.value = true;
    const isUpdate = ref<boolean>(false);
    //时间格式化
    let model = formData;
    if (model.id) {
      isUpdate.value = true;
    }
    //循环数据
    for (let data in model) {
      //如果该数据是数组并且是字符串类型
      if (model[data] instanceof Array) {
        let valueType = getValueType(formRef.value.getProps, data);
        //如果是字符串类型的需要变成以逗号分割的字符串
        if (valueType === 'string') {
          model[data] = model[data].join(',');
        }
      }
    }
    await saveOrUpdate(model, isUpdate.value)
      .then((res) => {
        if (res.success) {
          createMessage.success(res.message);
          emit('ok');
        } else {
          createMessage.warning(res.message);
        }
      })
      .finally(() => {
        confirmLoading.value = false;
      });
  }


  defineExpose({
    add,
    edit,
    submitForm,
  });
</script>

<style lang="less" scoped>
  .antd-modal-form {
    height: 500px !important;
    overflow-y: auto;
    padding: 24px 24px 24px 24px;
  }
</style>
