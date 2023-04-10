<template>
  <a-spin :spinning="confirmLoading">
    <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol">
      <a-row>
        <a-col :span="24">
          <a-form-item label="单位" v-bind="validateInfos.unit">
            <a-input v-model:value="formData.unit" placeholder="请输入单位" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="税率" v-bind="validateInfos.taxRate">
	          <a-input-number v-model:value="formData.taxRate" placeholder="请输入税率" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="不含税价" v-bind="validateInfos.excludeTax">
	          <a-input-number v-model:value="formData.excludeTax" placeholder="请输入不含税价" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="含税价" v-bind="validateInfos.includeTax">
	          <a-input-number v-model:value="formData.includeTax" placeholder="请输入含税价" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="区域" v-bind="validateInfos.area">
            <a-input v-model:value="formData.area" placeholder="请输入区域" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="供应商" v-bind="validateInfos.supplierId">
            <a-input v-model:value="formData.supplierId" placeholder="请输入供应商" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="数据来源" v-bind="validateInfos.dataSoure">
            <a-input v-model:value="formData.dataSoure" placeholder="请输入数据来源" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="检查日期" v-bind="validateInfos.checkDate">
		        <a-date-picker placeholder="请选择检查日期" v-model:value="formData.checkDate" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="采购日期" v-bind="validateInfos.purcherDate">
		        <a-date-picker placeholder="请选择采购日期" v-model:value="formData.purcherDate" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="标准or内容" v-bind="validateInfos.content">
            <a-input v-model:value="formData.content" placeholder="请输入标准or内容" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="备注" v-bind="validateInfos.remark">
            <a-input v-model:value="formData.remark" placeholder="请输入备注" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="走势" v-bind="validateInfos.trend">
            <a-input v-model:value="formData.trend" placeholder="请输入走势" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="材料类型" v-bind="validateInfos.typeId">
            <a-input v-model:value="formData.typeId" placeholder="请输入材料类型" :disabled="disabled"></a-input>
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
  import { saveOrUpdate } from '../Stuff.api';
  import { Form } from 'ant-design-vue';
  
  const props = defineProps({
    disabled: { type: Boolean, default: false },
  });
  const formRef = ref();
  const useForm = Form.useForm;
  const emit = defineEmits(['register', 'ok']);
  const formData = reactive<Record<string, any>>({
    id: '',
    unit: '',   
    id: '',
    taxRate: undefined,
    id: '',
    excludeTax: undefined,
    id: '',
    includeTax: undefined,
    id: '',
    area: '',   
    id: '',
    supplierId: '',   
    id: '',
    dataSoure: '',   
    id: '',
    checkDate: '',   
    id: '',
    purcherDate: '',   
    id: '',
    content: '',   
    id: '',
    remark: '',   
    id: '',
    trend: '',   
    id: '',
    typeId: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = {
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
