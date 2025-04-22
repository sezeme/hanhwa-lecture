// 변화 상황

// 1. 일반 함수의 this
// 생성자 함수가 아닌 일반 함수 내부에서는 this를 사용할 필요가 없기 때문에
// strict mode에서는 함수를 일반 함수로 호출하면 this에 undefined가 바인딩 된다.
(function(){
    'use strict';

    function test() {
        console.log(this);
    }

    test(); // 엄격모드 사용하지 않으면 전역객체가 나오는데, 사용할 필요가 없음

    new test();
})();

// 2. arguments 객체
// 매개변수에 전달 된 인수를 재할당 하여 변경해도 arguments 객체에 반영되지 않는다.
(function(x){
    'use strict';

    x = 2;

    console.log(arguments);

})(1);
