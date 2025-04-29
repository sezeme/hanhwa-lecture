<script setup>
import { ref } from 'vue'

const props = defineProps({
  categories: {
    type: Array,
    default: () => [
      { code: '', name: '전체 카테고리' },
      { code: '1', name: '식사' },
      { code: '2', name: '디저트' },
      { code: '3', name: '음료' }
    ]
  }
})

// 검색 이벤트 emit
const emit = defineEmits(['search'])

// 상태를 ref로 분리
const categoryCode = ref('')
const productName  = ref('')

// 검색 실행 함수
const emitSearch = () => {
  emit('search', {
    categoryCode: categoryCode.value || null,
    productName:  productName.value  || null
  })
}
</script>

<template>
  <div class="search-bar">
    <label for="category-select">카테고리</label>
    <select
        id="category-select"
        v-model.lazy="categoryCode"
        @change="emitSearch"
    >
      <option
          v-for="cat in props.categories"
          :key="cat.code"
          :value="cat.code"
      >
        {{ cat.name }}
      </option>
    </select>
    <input
        id="product-input"
        type="text"
        v-model.trim.lazy="productName"
        placeholder="상품명을 입력하세요"
        @keyup.enter="emitSearch"
    />

    <button
        @click="emitSearch"
        aria-label="검색하기"
    >
      검색
    </button>
  </div>
</template>

<style scoped>
.search-bar {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
  justify-content: flex-end;
  align-items: center;
}
label {
  font-size: 0.9rem;
}
select,
input {
  padding: 5px;
}
button {
  padding: 5px 10px;
  background-color: #2196f3;
  color: white;
  border: none;
  cursor: pointer;
}
button:hover {
  background-color: #1976d2;
}
</style>
