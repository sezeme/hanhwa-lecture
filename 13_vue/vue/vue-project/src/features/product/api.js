import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080'
});

/* 상품 목록 조회 api */
export const getProducts = params => api.get("/products", {params})

/* 상품 상세 조회 api */
export const getProduct = id => api.get(`/products/${id}`)