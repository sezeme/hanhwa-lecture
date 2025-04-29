<template>
  <form @submit.prevent="submitForm" class="container mt-4">
    <div class="mb-3">
      <label for="productName" class="form-label">상품명</label>
      <input type="text" id="productName" v-model="formData.productName" class="form-control" required />
    </div>

    <div class="mb-3">
      <label for="productPrice" class="form-label">상품 가격</label>
      <input type="number" id="productPrice" v-model.number="formData.productPrice" class="form-control" required />
    </div>

    <div class="mb-3">
      <label for="productDescription" class="form-label">상품 설명</label>
      <textarea id="productDescription" v-model="formData.productDescription" class="form-control" required></textarea>
    </div>

    <div class="mb-3">
      <label for="categoryCode" class="form-label">카테고리</label>
      <select id="categoryCode" v-model.number="formData.categoryCode" class="form-select" required>
        <option value="1">식사</option>
        <option value="2">디저트</option>
        <option value="3">음료</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="productStock" class="form-label">재고 수량</label>
      <input type="number" id="productStock" v-model.number="formData.productStock" class="form-control" required />
    </div>

    <!-- 상태 선택: 수정 모드에서만 보여줌 -->
    <div v-if="isEditMode" class="mb-3">
      <label for="status" class="form-label">상태</label>
      <select id="status" v-model="formData.status" class="form-select" required>
        <option value="USABLE">사용 가능</option>
        <option value="DISABLE">사용 불가</option>
      </select>
    </div>

    <!-- 이미지 업로드: 생성 모드에서만 필수 -->
    <div class="mb-3">
      <label for="productImg" class="form-label">상품 이미지</label>
      <input
          type="file"
          id="productImg"
          @change="handleFileChange"
          class="form-control"
          accept="image/*"
          :required="!isEditMode"
      />
    </div>
    <button type="submit" class="btn btn-primary w-100" :disabled="!isFormValid">{{ submitLabel }}</button>
  </form>
</template>

<script setup>
import { ref, watch, computed } from 'vue';

const {initialData, submitLabel} = defineProps({
  initialData: { type: Object, default: null },
  submitLabel: { type: String, default: '제출' }
});

const emit = defineEmits(['submit']);

// 생성 vs 수정 모드 구분
const isEditMode = computed(() => initialData !== null);

const formData = ref({
  productName:       '',
  productPrice:      0,
  productDescription:'',
  categoryCode:      1,
  productStock:      0,
  status:            'USABLE',
  file:              null
});

// 수정 모드이면 initialData 주입
watch(
    () => initialData,
    data => {
      if (data) {
        Object.assign(formData.value, {
          productName:       data.productName,
          productPrice:      data.productPrice,
          productDescription:data.productDescription,
          categoryCode:      data.category.categoryCode,
          productStock:      data.productStock,
          status:            data.status
        });
        // file 은 교체 시에만 설정
        formData.value.file = null;
      }
    },
    { immediate: true }
);

const handleFileChange = e => {
  formData.value.file = e.target.files[0] || null;
};

// 생성 모드일 때만 파일이 필수이므로, edit 모드에선 항상 true 처리
const isFormValid = computed(() => {
  const f = formData.value;
  return (
      f.productName &&
      f.productPrice > 0 &&
      f.productStock > 0 &&
      f.productDescription &&
      f.categoryCode &&
      f.status &&
      (!(!isEditMode.value && !f.file)) // 생성 모드면 f.file 존재해야 함
  );
});

function submitForm() {
  const { file, ...rest } = formData.value;
  emit('submit', { payload: rest, file });
}
</script>

