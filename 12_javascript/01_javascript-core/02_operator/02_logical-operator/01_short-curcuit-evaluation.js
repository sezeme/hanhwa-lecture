// 단축 평가
// 표현식을 평가하는 도중 평가 결과가 확정 된 경우 나머지 평가 과정을 생략하는 것
// &&, || 연산자 표현식의 결과가 때로는 boolean 값이 아닐 수도 있다.

// 'apple' 이 Truthy 한 값이기 때문에 true로 평가 되고 논리 연산의 결과를 결정한 첫 번째
// 피 연산자 'apple'이 그대로 반환되었다.
console.log('apple' || 'banana');
console.log(false || 'banana');

console.log('apple' && 'banana');
console.log(false && 'banana');

// 객체를 가리키기를 기대하는 변수가 null 또는 undefined가 아닌지 확인하고
// 프로퍼티를 참조할 때 단축 평가를 활용할 수 있다.
var obj = null;
// TypeError: Cannot read properties of null (reading 'value'
// var val = obj.value;
// obj가 Falsy(null, undefined) 값이면 좌항만 실행하여 val2 -> null
// obj가 Truthy 값이면 val2 -> obj.value
var val2 = obj && obj.value;
