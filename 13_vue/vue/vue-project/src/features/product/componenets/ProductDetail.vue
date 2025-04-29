<template>
  <div class="product-detail">
    <img :src="product.productImageUrl" alt="Product Image" class="product-image img-fluid" />
    <h1 class="mt-3">상품명 : {{ product.productName }}</h1>
    <p><strong>상품 가격 :</strong> {{ product.productPrice }}</p>
    <p><strong>상품 설명 :</strong> {{ product.productDescription }}</p>
    <p><strong>카테고리명 :</strong> {{ product.category.categoryName }}</p>
    <p><strong>상품 수량 :</strong> {{ product.productStock }}</p>
  </div>
</template>

<script setup>
const { product } = defineProps({
  product: {
    type: Object,
    required: true
  }
});

</script>

<style scoped>
.product-detail {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.product-image {
  width: 300px;
  height: auto;
  object-fit: cover;
  margin-bottom: 20px;
}

h1 {
  margin-bottom: 10px;
  font-size: 2rem;
}

p {
  margin: 5px 0;
  font-size: 1.2rem;
}

strong {
  font-weight: bold;
}
</style>
