<script setup>

const { product } = defineProps({
  product: {
    type: Object,
    required: true
  }
});

</script>

<template>
  <router-link
      class="item"
      :to="`/products/${product.productCode}`">
    <img :src="product.productImageUrl" :alt="product.productName" class="product-image">
    <div class="product-details">
      <p class="product-name">상품명: {{ product.productName }}</p>
      <p class="product-price">상품 가격: {{ product.productPrice }}</p>
      <p class="product-description">상품 설명: {{ product.productDescription }}</p>
      <p class="product-category">상품 카테고리: {{ product.category.categoryName }}</p>
      <p class="product-stock">상품 수량: {{ product.productStock }}</p>
    </div>
  </router-link>
</template>

<style scoped>
.item {
  display: flex;
  align-items: center;
  padding: 20px;
  border-bottom: 1px solid lightgray;
  text-align: left;
  cursor: pointer;
  transition: background-color 0.3s;
  text-decoration: none;
  color : black;
}

.item:hover {
  background-color: #f0f0f0;
}

.product-image {
  width: 100px;
  height: auto;
  margin-right: 20px;
}

.product-details {
  flex: 1;
}

.product-name, .product-price, .product-description, .product-category, .product-stock {
  margin: 5px 0;
}
</style>