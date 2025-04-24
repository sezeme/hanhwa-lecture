// 객체 구조 분해 할당
const pants = {
    productName : '배기 팬츠',
    color : '검정색',
    price : 30000
};

const { productName,  price, color } = pants;
console.log(productName);
console.log(color);
console.log(price);

// 각 변수의 서술 순서는 무관하며 { 객체 프로퍼티 : 목표 변수 } 형식으로 작성하여
// 프로퍼티 키 값과 다른 변수명을 설정할 수도 있다.
const { productName : pn,  price : pr, color : co } = pants;
console.log(pn);
console.log(co);
console.log(pr);