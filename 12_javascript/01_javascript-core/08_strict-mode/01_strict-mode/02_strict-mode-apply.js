// strict mode 적용하기

// 1. 전역의 선두에 추가 : 스크립트 전체에 strict mode 적용
// 'use strict';

function test() {
    // 2. 함수 몸체의 선두에 추가 : 해당 함수와 중첩 함수에 strict mode 적용
    // 'use strict';

    x = 10; // ReferenceError: x is not defined

    // 코드의 선두가 아니라면 strict mode 적용 되지 않음
    'use strict';
}

test();

console.log(x);

/*
* 전역에 엄격 모드를 적용하면 스크립트 태그 단위로 적용 되어 strict mode와 non strict mode의 혼용으로
* 인한 오류가 발생할 수 있음에 유의한다.
* <script>
    'use strict';
* </script>
* ...
* <script>
    x = 10; // 엄격 모드 적용 X, 에러 발생 X
* </script>
* */

// 서드파티 라이브러리가 non strict mode인 경우 즉시 실행 함수로 스크립트 전체를 감싸서
// 스코프를 구분하고 즉시 실행 함수의 선두에 strict mode를 적용한다.
(function(){
    'use strict';

    // 코드 작성
})();
