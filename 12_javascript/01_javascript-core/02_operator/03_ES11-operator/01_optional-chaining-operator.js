// 옵셔널 체이닝 연산자 (ES11-2020에서 추가)
// 좌항의 피연산자가 null 또는 undefined인 경우 undefined 를 반환하고
// 그렇지 않으면 우항의 프로퍼티 참조를 이어간다.
var obj = null;
var val = obj?.value;
console.log(val);

// 단축 평가를 이용하면 빈 문자열과 같은 Falsy 값을 false로 취급하는
var str = '';
var len = str && str.length; // 유효한 값이 있을 경우에만 담을게요. but falsy 값이 그대로 반환됨
console.log(len);
var len2 = str?.length; // null과 undefined만 판단, 그게 아니라면 length를 처리
console.log(len2);