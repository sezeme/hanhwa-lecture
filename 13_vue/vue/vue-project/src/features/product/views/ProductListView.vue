<script setup>

import {onMounted, reactive, ref} from "vue";
import {getProducts} from "@/features/product/api.js";
import SkeletonList from "@/components/common/SkeletonList.vue";
import ProductList from "@/features/product/componenets/ProductList.vue";
import PagingBar from "@/components/common/PagingBar.vue";
import SearchBar from "@/components/common/SearchBar.vue";

const products = ref([]);
const pagination = reactive({
  currentPage: 1,
  totalPages: 1,
  totalItems: 0
});
const searchParams = reactive({
  categoryCode : null,
  productName : ''
});
const isLoading = ref(true);

const fetchProducts = async (page = 1) => {
  isLoading.value = true;
  try {
    // api 호출 (axios lib)
    const {data: wrapper} = await getProducts({
      page : page,
      categoryCode : searchParams.categoryCode,
      productName : searchParams.productName
    });
    const respData = wrapper.data;
    products.value = respData.products || [];
    // Object.assign(target, ...sources) : source의 속성을 모두 꺼내 target에 덮어쓰기
    Object.assign(pagination, respData.pagination ?? {});
    isLoading.value = false;
  } catch (e) {
    console.log('상품 목록 로드 실패', e);
  }

}

// 검색 이벤트 발생 시 수행할 함수
const onSearch = params => {
  Object.assign(searchParams, params);
  pagination.currentPage = 1;
  fetchProducts();
}

onMounted(() => fetchProducts());
</script>

<template>
  <SearchBar @search="onSearch"/>
  <!-- ProductList 가 조회 되지 않았을 때 보여줄 뼈대 컴포넌트 -->
  <SkeletonList v-if="isLoading"/>
  <!-- ProductList 가 조회 되었을 때 보여줄 컴포넌트 -->
  <ProductList v-else :products="products"/>
  <PagingBar
      v-bind="pagination"
      @page-changed="fetchProducts"
  />
</template>

<style scoped>

</style>